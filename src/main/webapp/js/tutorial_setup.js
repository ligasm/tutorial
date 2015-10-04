AUI.add(
    'tutorial-setup',

    function (A) {

        var POPOVER_CONTENT = '<textarea class="content" />';
        var POPOVER_FOOTER = '<button class="btn btn-left" data-action="left"><i class="icon-arrow-left"></i></button>' +
            '<button class="btn btn-primary" data-action="end">OK</button>' +
            '<button class="btn btn-right" data-action="right"><i class="icon-arrow-right"></i></button>';

        var CONFIG_TEMPLATE_WRAPPER =
            '<div class="tutorial-setup-container">' +
            '   <ol></ol>' +
            '   <div class="btn-row pagination-right">' +
            '       <button class="btn-reorganize" data-action="reorganize"><i class="icon-resize-horizontal"></i></button>' +
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

        var TutorialSetup = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial-setup',

                prototype: {

                    initializer: function (config) {
                        var instance = this;

                        var mainContent = A.Node.create(POPOVER_CONTENT);
                        var footerContent = A.Node.create(POPOVER_FOOTER);

                        instance._container = new Liferay.TutorialSetupContainer();

                        instance._popover = new A.Popover(
                            {
                                align: {
                                    points: [A.WidgetPositionAlign.TL, A.WidgetPositionAlign.BR]
                                },
                                cssClass: 'tutorial-setup-popover',
                                footerContent: footerContent,
                                bodyContent: mainContent,
                                position: 'bottom',
                                zIndex: 20
                            }
                        );
                        instance._popover.render();

                        A.one('.tutorial-setup-popover .btn-primary').on('click', function () {
                            var value = instance._popover.get('boundingBox').one(".content").get('value');
                            instance._container.addTutorialStep(value)
                            instance._popover.set('visible', false);
                        });
                        A.one('.tutorial-setup-popover .btn-left').on('click', function () {
                            instance._popover.align(instance._elem, ['rc', 'lc']);
                            instance._popover.set('position','left');
                        });
                        A.one('.tutorial-setup-popover .btn-right').on('click', function () {
                            instance._popover.align(instance._elem, ['lc', 'rc']);
                            instance._popover.set('position','right');
                        });


                        var page = A.one('#wrapper');

                        page.on(
                            'click',
                            function (event) {
                                var elem = event.target;

                                event.stopPropagation();
                                event.preventDefault();


                                elem.setStyle('border', '2px solid yellow');


                                instance._popover.set('visible', true);
                                instance._popover.align(elem, ['tc', 'bc']);
                                instance._popover.get('boundingBox').one(".content").set('value','');
                                instance._elem = elem;
                                return false;
                            });
                    }
                }
            }
        );

        Liferay.TutorialSetup = TutorialSetup;

        var TutorialSetupContainer = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial-setup-container',

                prototype: {

                    initializer: function (config) {
                        var instance = this;

                        instance._container = A.Node.create(CONFIG_TEMPLATE_WRAPPER);
                        instance._container.one('.btn-reorganize').on('click',function(){
                            instance._reorganize();
                        });


                        instance._modal = new A.Modal(
                            {
                                bodyContent: 'Modal body',
                                centered: true,
                                headerContent: '<h3>Modal header</h3>',
                                modal: true,
                                //render: '#modal',
                                width: 450
                            }
                        ).render();
                        instance._modal.hide();

                        instance._container.delegate('click',function(){
                            instance._modal.show();
                        },'.btn-setup');

                        A.one('body').appendChild(instance._container);



                    },
                    addTutorialStep : function(text){
                        var instance = this;
                        var configTemplate = A.Node.create(CONFIG_TEMPLATE);

                        configTemplate.one(".text > span").set('text',text);

                        instance._container.one('ol').appendChild(configTemplate);

                    },
                    _reorganize: function(){
                        var sortableLayout = new A.SortableList(
                            {
                                dropCondition: function(event) {
                                    return true;
                                },
                                dropOn: '.tutorial-setup-container > ol',
                                nodes: '.tutorial-setup-container > ol > li',
                            }
                        );
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