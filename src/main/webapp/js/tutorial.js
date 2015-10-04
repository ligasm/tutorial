AUI.add(
    'tutorial',
    function (A) {

        var PATIENT_MAP_TUTORIAL_VIEWED = 'tutorial_viewed_state';

        var Tutorial = A.Component.create(
            {
                EXTENDS: A.Base,

                NAME: 'tutorial',

                prototype: {

                    initializer: function (config) {
                        var instance = this;

                        instance._totorialSteps = config.tutorialSteps;
                        instance._welcomePopup = config.welcomePopup;


                    },

                    activateTutorial: function(){
                        var instance = this;

                        instance._getTutorialViewed(instance._showWelcomModal);
                    },

                    _showWelcomModal: function(shown) {
                        var instance = this;

                        shown = (shown == 'get') ? false : shown;

                        if (!shown) {
                            var tutorialModal = instance._getTutorialModal();

                            tutorialModal.showInfo(instance._welcomePopup);

                            tutorialModal._modal.addToolbar(
                                [
                                    {
                                        label: 'Close',
                                        on: {
                                            click: function() {
                                                tutorialModal._modal.hide();
                                            }
                                        }
                                    },
                                    {
                                        cssClass: 'pull-left btn-link',
                                        label: 'Don\'t show this next time.',
                                        on: {
                                            click: function() {
                                                Liferay.Store(PATIENT_MAP_TUTORIAL_VIEWED, true);

                                                tutorialModal._modal.hide();
                                            }
                                        }
                                    },
                                    {
                                        cssClass: 'btn-brand',
                                        label: 'Start Tutorial',
                                        on: {
                                            click: A.bind('_onWelcomeModalTutorialClick', instance)
                                        }
                                    }
                                ]
                            );

                            if (instance._tutorialPopover) {
                                instance._tutorialPopover.end();
                            }
                        }
                    },

                    _onWelcomeModalTutorialClick: function() {
                        var instance = this;

                        var tutorialModal = instance._getTutorialModal();

                        var tutorialPopover = new Liferay.TutorialPopover(
                            {
                                tutorialSteps: instance._totorialSteps
                            }
                        );

                        tutorialPopover.start();

                        instance._tutorialPopover = tutorialPopover;

                        tutorialModal._modal.hide();
                    },

                    _getTutorialModal: function() {
                        var instance = this;

                        var tutorialModal = instance._tutorialModal;

                        if (!tutorialModal) {
                            tutorialModal = new Liferay.TutorialModal();

                            instance._tutorialModal = tutorialModal;
                        }

                        return tutorialModal;
                    },



                    _getTutorialViewed: function(cb) {
                        var instance = this;

                        Liferay.Store(PATIENT_MAP_TUTORIAL_VIEWED, A.bind(cb, instance));
                    }

                }
            }
        );

        Liferay.Tutorial = Tutorial;
    },
    '',
    {
        requires: ['aui-base', 'aui-component', 'tutorial-popover', 'liferay-store']
    }
);