AUI.add(
    'tutorial-setup',

    function (A) {

        var POPOVER_CONTENT = '<textarea class="content" />';
        var POPOVER_FOOTER = '<button class="btn btn-left" data-action="left"><i class="icon-repeat"></i></button>' +
            '<button class="btn btn-primary" data-action="end">OK</button>' +
            '<button class="btn btn-right" data-action="right"><i class="icon-undo"></i></button>';

        var POSITIONS = [
            ['lc','rc','right'],
            ['bc','tr','top'],
            ['bc','tc','top'],
            ['bc','tl','top'],
            ['rc','lc','left'],
            ['tc','bl','bottom'],
            ['tc','bc','bottom'],
            ['tc','br','bottom']
        ];

        var DEFAULT_POSITON = 6;

        var TutorialStep = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial-step',

                ATTRS: {
                    position: {
                        value : DEFAULT_POSITON
                    },
                    elem: {
                        value:null
                    },
                    index: {
                        value:null
                    }
                },

                prototype: {

                    initializer: function (config) {
                        var instance = this;

                        var mainContent = A.Node.create(POPOVER_CONTENT);
                        var footerContent = A.Node.create(POPOVER_FOOTER);

                        var position = POSITIONS[DEFAULT_POSITON];

                        instance._popover = new A.Popover(
                            {
                                align: {
                                    points: [position[0], position[1]]
                                },
                                cssClass: 'tutorial-step-popover',
                                footerContent: footerContent,
                                bodyContent: mainContent,
                                position: position[2],
                                zIndex: 20
                            }
                        );

                        footerContent.one('.btn-primary').on('click', function () {
                            var value = instance._popover.get('boundingBox').one(".content").get('value');
                            instance._popover.set('visible', false);

                            instance.fire('tutorialStepSave',
                                {
                                    'text':value,
                                    'position':instance.get('position'),
                                    'nodeElem':instance.get('elem'),
                                    'index':instance.get('index')
                                });
                        });
                        footerContent.one('.btn-left').on('click', function () {
                            var index = instance.get('position');

                            instance._setPosition(--index)
                        });
                        footerContent.one('.btn-right').on('click', function () {
                            var index = instance.get('position');

                            instance._setPosition(++index)
                        });

                        instance._popover.set('visible', false);
                        instance._popover.render();

                        var page = A.one('#wrapper');

                        page.on(
                            'click',
                            function (event) {
                                var elem = event.target;

                                event.stopPropagation();
                                event.preventDefault();


                                elem.setStyle('border', '2px solid yellow');

                                instance.display.call(instance, {
                                    node: elem,
                                    position: DEFAULT_POSITON,
                                    text: ''
                                });
                                return false;
                            });
                    },
                    display :function (data){
                        var instance = this;

                        instance.set('elem', data.node);
                        instance.set('index', data.index);
                        instance. _setPosition(data.position);
                        instance._popover.get('boundingBox').one(".content").set('value',data.text);
                        instance._popover.set('visible', true);
                    },
                    _setPosition : function(index) {
                        var instance = this;

                        var len = POSITIONS.length;

                        index = (len +(index % len)) % len;

                        var position = POSITIONS[index];
                        instance._popover.align(instance.get("elem"), [position[0],position[1]]);
                        instance._popover.set('position', position[2]);
                        instance.set('position', index);
                    }

                }
            }
        );

        Liferay.TutorialStep = TutorialStep;

        var STEP_CONFIG_TEMPLATE =
            '<div class="tutorial-step-config">' +
            '   <select>' +
            '      <option value="">&nbsp;</option>' +
            '      <option value="click">Click</option>' +
            '      <option value="dbclick">Double</option>' +
            '      <option value="http">Go to address</option>' +
            '   </select>' +
            '   <input type="text"/>' +
            '</div>';


        var TutorialStepConfig = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial-step-config',

                prototype: {

                    initializer: function (config) {
                        var instance = this;

                        instance._config = config;
                        instance._index = 0;

                        var bodyContent = A.Node.create(STEP_CONFIG_TEMPLATE);

                        instance._modal = new A.Modal(
                            {
                                bodyContent: bodyContent,
                                centered: true,
                                headerContent: '<h3>Configuration</h3>',
                                modal: true,
                                zIndex: 1000,
                                width: 450
                            }
                        );

                        instance._modal.addToolbar(
                            [
                                {
                                    cssClass: 'btn-save',
                                    label: 'Save',
                                    on: {
                                        click: A.bind('_onSaveClick', instance)
                                    }
                                }
                            ]
                        );

                        instance._modal.render();
                        instance._modal.hide();

                        instance._input = bodyContent.one('input');
                        instance._select = bodyContent.one('select');

                        instance._input.hide();

                        instance._select.on('change',function(){
                            instance._resetForm(this.get('value'));
                        });

                    },
                    show:function(config, index) {
                        var instance = this;

                        instance._config = config;
                        instance._index = index;
                        instance._resetForm(config.option);

                        if(config){
                            instance._select.set('value',config.option);
                            instance._input.set('value',config.value);
                        } else{
                            instance._config ={};
                        }

                        instance._modal.show();
                    },
                    hide:function() {
                        var instance =this;
                        instance._modal.hide();
                    },
                    _onSaveClick: function(){
                        var instance =this;

                        instance._config.option = instance._select.get('value');
                        instance._config.value = instance._input.get('value');

                        instance.fire('stepConfigSave',{config:instance._config,index:instance._index});
                        instance._modal.hide();
                    }       ,
                    _resetForm:function(value){
                        var instance = this;

                        if(value == 'http') {
                            instance._input.set('value','');
                            instance._input.show();
                        }else{
                            instance._input.hide();
                        }
                    }
                }
            });

        Liferay.TutorialStepConfig = TutorialStepConfig;

        var TUTORIAL_CONTAINER_TEMPLATE =
            '<div class="tutorial-setup-container">' +
            '   <ol></ol>' +
            '   <div class="btn-row pagination-right">' +
            '       <button class="btn btn-save" data-action="saveAll"><i class="icon-ok"></i></button>' +
            '   </div>' +
            '</div>'

        var TUTORIAL_CONTAINER_ITEM_TEMPLATE =
            '<li class="tutorial-setup-item">' +
            '   <div class="btn-row pagination-right">' +
            '       <button class="btn btn-edit" data-action="editStep"><i class="icon-edit"></i></button>' +
            '       <button class="btn btn-setup" data-action="setupStep"><i class="icon-cogs"></i></button>' +
            '       <button class="btn btn-delete" data-action="removeStep"><i class="icon-remove"></i></button>' +
            '   </div>' +
            '   <div class="text">' +
            '       <span></span>' +
            '   </div>' +
            '</li>';


        var TutorialSetupContainer = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial-setup-container',

                ATTRS: {
                    steps: {
                        value : []
                    }
                },

                prototype: {

                    initializer: function (config) {
                        config = config || {};

                        var instance = this;

                        instance._tutorialcontainer = A.Node.create(TUTORIAL_CONTAINER_TEMPLATE);

                        instance._tutorialStep = new Liferay.TutorialStep();

                        instance._tutorialStepConfig = new Liferay.TutorialStepConfig();

                        instance._sortableLayout = new A.SortableList(
                            {
                                dropCondition: function(event) {
                                    return true;
                                },
                                dropOn: '.tutorial-setup-container > ol',
                                nodes: '.tutorial-setup-container > ol > li',
                            }
                        );

                        if(config.saveFn){
                            instance._saveIO = config.saveFn;
                        }

                        instance.bindUI();

                        instance.renderUI();
                    },
                    renderUI : function (){
                        var instance = this;
                        A.one('body').appendChild(instance._tutorialcontainer);
                    },
                    bindUI :function(){
                        var instance = this;


                        instance._tutorialcontainer.delegate('click', instance._onClickAcrionHandling,'.btn', instance);

                        instance._tutorialStep.on('tutorialStepSave', function(event) {
                            var index = event['index'];
                            if(index){
                                instance.editTutorialStep.call(instance,
                                    event['text'], event['position'], index);
                            } else {
                            instance.addTutorialStep.call(instance,
                                event['text'], event['position'], event['nodeElem']);
                            }
                        });

                        instance._tutorialStepConfig.on('stepConfigSave', function(event) {
                            var config = event['config'];
                            var index = event['index'];
                            var steps = instance.get('steps');

                            steps[index]['config'] = config;
                        });
                    },
                    editStep : function(targetElem){
                        var instance = this;
                        var data = instance._getStepData.call(instance, targetElem);
                        instance._tutorialStep.display(data);
                    },
                    setupStep : function(targetElem){
                        var instance = this;
                        var data = instance._getStepData.call(instance, targetElem);
                        instance._tutorialStepConfig.show(data.config, data.index);
                    },
                    removeStep : function(targetElem){
                        var instance = this;
                        var nodeElem = targetElem.ancestor('li');
                        var index = nodeElem.attr('data-index');
                        nodeElem.remove();
                        delete instance.get('steps')[index];


                    },
                    saveAll:function(){
                        var instance = this;

                        var unsortedData = instance.get('steps');
                        var order = [];
                        var sorted = [];

                        instance._tutorialcontainer.all('.tutorial-setup-item').each(function(){
                            order.push(this.attr('data-index'));
                        });

                        for(var i=0;i<order.length;i++){
                            var step = unsortedData[order[i]];
                            if(step){
                                var storeStep = A.mix({},step);
                                storeStep.elem = instance._elemSerialization(storeStep.elem);
                                sorted.push(storeStep);
                            }
                        }

                        instance._saveIO(JSON.stringify(sorted));
                    },
                    addTutorialStep : function(text, position, elem){
                        var instance = this;

                        var steps = instance.get('steps');
                        var index = steps.length;

                        steps.push({
                            text:text,
                            position:position,
                            elem:elem,
                            config:{}
                        });

                        var configTemplate = A.Node.create(TUTORIAL_CONTAINER_ITEM_TEMPLATE);

                        configTemplate.one(".text > span").set('text', text);

                        configTemplate.attr('data-index', index);

                        instance._tutorialcontainer.one('ol').appendChild(configTemplate);

                        instance._sortableLayout.add(configTemplate);

                    },
                    editTutorialStep : function(text, position, index){
                        var instance = this;

                        var steps = instance.get('steps');

                        A.mix(steps[index],
                            {
                                text: text,
                                position: position
                            },true);

                        instance._tutorialcontainer.one('li.tutorial-setup-item[data-index="'+index+'"] .text > span')
                            .set('text', text);

                    },
                    _getStepData : function (stepElem){
                        var instance = this;
                        var index = stepElem.ancestor('li').attr('data-index');
                        var data = instance.get('steps')[index];
                        data.index = index;
                        return data;
                    } ,
                    _onClickAcrionHandling: function(event) {
                        var instance = this;

                        var currentTarget = event.currentTarget;

                        var action = currentTarget.attr('data-action');

                        if (instance[action]) {
                            instance[action](currentTarget);
                        }
                    },
                    _elemSerialization : function(elem){
                        var path = "";
                        var ancestors = elem.ancestors()._nodes;
                        var index = 0;

                        for(var i = ancestors.length -1; i>=0 ;i--){
                            if(!ancestors[i].id.startsWith("yui")){
                                index = i;
                                break;
                            }
                        }

                        for(var i = index; i<ancestors.length ; i++){
                            var node = ancestors[i];

                            var elemName = node.nodeName;
                            var elemId = node.id

                            path += elemName

                            if(elemId.startsWith("yui")){
                                A.Array.each(node.classList, function(value){
                                    path += "." + value + ", ";
                                });

                                path = path.slice(0, -2);
                            }else{
                                path += "#"+ elemId;
                            }

                            path += " > "
                        }

                        return path.slice(0, -3);
                    },
                    _saveIO : function(data){
                        console.log("Provide save to server operation.");
                        console.log(data);
                    }
                }
            }
        );

        Liferay.TutorialSetupContainer = TutorialSetupContainer;
    },
    '',
    {
        requires: ['aui-base', 'aui-component', 'aui-popover', 'node-event-delegate','aui-sortable-list','aui-modal']
    }
)
;