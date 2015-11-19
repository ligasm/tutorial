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

        var TutorialSetup = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial-setup',

                ATTRS: {
                    position: {
                        value : DEFAULT_POSITON
                    },
                    elem: {
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
                                cssClass: 'tutorial-setup-popover',
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
                                    'node':instance.get('elem')
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

                                instance._elem = elem;
                                instance. _setPosition(DEFAULT_POSITON);
                                instance._popover.get('boundingBox').one(".content").set('value','');
                                instance._popover.set('visible', true);
                                return false;
                            });
                    },
                    _setPosition : function(index) {
                        var instance = this;
                        var len = POSITIONS.length;

                        index = (len +(index % len)) % len;

                        var position = POSITIONS[index];
                        instance._popover.align(instance._elem, [position[0],position[1]]);
                        instance._popover.set('position', position[2]);
                        instance.set('position', index);
                    }

                }
            }
        );

        Liferay.TutorialSetup = TutorialSetup;

        var SETUP_CONFIG_TEMPLATE =
            '<div class="tutorial-step-config">' +
            '   <select>' +
            '      <option value="click">Click</option>' +
            '      <option value="dbclick">Double</option>' +
            '      <option value="http">Go to address</option>' +
            '   </select>' +
            '   <input type="text"/>' +
            '</div>';


        var TutorialSetupConfig = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial-setup-config',

                prototype: {

                    initializer: function (config) {
                        var instance = this;

                        instance._config = config;
                        instance._index = 0;

                        var bodyContent = A.Node.create(SETUP_CONFIG_TEMPLATE);

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

                        instance.fire('setupConfigSave',{config:instance._config,index:instance._index});
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

        Liferay.TutorialSetupConfig = TutorialSetupConfig;

        var CONFIG_TEMPLATE_WRAPPER =
            '<div class="tutorial-setup-container">' +
            '   <ol></ol>' +
            '   <div class="btn-row pagination-right">' +
            '       <button class="btn-save" data-action="save"><i class="icon-ok"></i></button>' +
            '   </div>' +
            '</div>'

        var CONFIG_TEMPLATE =
            '<li class="tutorial-step">' +
            '   <div class="btn-row pagination-right">' +
            '       <button class="btn btn-setup" data-action="setup"><i class="icon-cogs"></i></button>' +
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
                        var instance = this;

                        instance._container = A.Node.create(CONFIG_TEMPLATE_WRAPPER);

                        instance._setup = new Liferay.TutorialSetup();

                        instance._setupConfig = new Liferay.TutorialSetupConfig();

                        instance._container.one('.btn-save').on('click',function(){
                            var unsorted = instance.get('steps');
                            var order = [];
                            var sorted = [];

                            instance._container.all('.tutorial-step').each(function(){
                                order.push(this.attr('data-index'));
                            });

                            for(var i=0;i<order.length;i++){
                                sorted.push(unsorted[order[i]]);
                            }

                            console.log(JSON.stringify(sorted));

                        });

                        instance._container.delegate('click',function(){
                            var index = this.ancestor('li').attr('data-index');
                            var data = instance.get('steps')[index];
                            instance._setupConfig.show(data.config,index);
                        },'.btn-setup');

                        instance._sortableLayout = new A.SortableList(
                            {
                                dropCondition: function(event) {
                                    return true;
                                },
                                dropOn: '.tutorial-setup-container > ol',
                                nodes: '.tutorial-setup-container > ol > li',
                            }
                        );

                        A.one('body').appendChild(instance._container);

                        instance._setup.on('tutorialStepSave', function(event) {
                            var text = event['text'];
                            var position = event['position'];
                            var elem = event['elem'];

                            instance.addTutorialStep(text, position, elem);
                        });

                        instance._setupConfig.on('setupConfigSave', function(event) {
                            var config = event['config'];
                            var index = event['index'];
                            var steps = instance.get('steps');

                            steps[index]['config'] = config;

                        });
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

                        var configTemplate = A.Node.create(CONFIG_TEMPLATE);

                        configTemplate.one(".text > span").set('text',text);

                        configTemplate.attr('data-index', index);

                        instance._container.one('ol').appendChild(configTemplate);

                        instance._sortableLayout.add(configTemplate);

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