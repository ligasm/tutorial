AUI.add(
	'tutorial-popover',
	function(A) {
		var Util = Liferay.Util;

		var TPL_POPOVER_FOOTER = '<button class="btn prev" data-action="prev">Previous</button>' +
			'<button class="btn btn-primary" data-action="end">End Tutorial</button>' +
			'<button class="btn btn-brand next" data-action="next">Next</button>';

		var TutorialPopover = A.Component.create(
			{
				ATTRS: {
					customPosition: {
						setter: '_setCustomPosition',
						validator: A.Lang.isString
					},

					stepIndex: {
						value: 0
					}
				},

				EXTENDS: A.Base,

				NAME: 'tutorialpopover',

				prototype: {
					DEFAULT_ALIGN_POINTS: [A.WidgetPositionAlign.TC, A.WidgetPositionAlign.BC],

					initializer: function(config) {
						var instance = this;

						instance._tutorialSteps = config.tutorialSteps;

						instance.renderUI();
						instance.bindUI();
					},

					renderUI: function() {
						var instance = this;

						var footerContent = A.Node.create(TPL_POPOVER_FOOTER);

						var popover = new A.Popover(
							{
								align: {
									points: [A.WidgetPositionAlign.TL, A.WidgetPositionAlign.BR]
								},
								cssClass: 'tutorial-popover',
								footerContent: footerContent,
								position: 'bottom',
								zIndex: 20
							}
						);

						instance._popover = popover;
					},

					bindUI: function() {
						var instance = this;

						instance._popover.get('boundingBox').delegate('click', instance._onFooterButtonClick, 'button', instance);
					},

					end: function() {
						var instance = this;

						var previousTutorialStep = instance._tutorialSteps[instance.get('stepIndex')];

						if (previousTutorialStep && previousTutorialStep.after) {
							instance._executeAfter(previousTutorialStep);
						}

						instance._popover.hide();
					},

					next: function() {
						var instance = this;

						var stepIndex = instance.get('stepIndex') + 1;

						instance._setStep(stepIndex);

						instance.set('stepIndex', stepIndex);
					},

					prev: function() {
						var instance = this;

						var stepIndex = instance.get('stepIndex') - 1;

						instance._setStep(stepIndex);

						instance.set('stepIndex', stepIndex);
					},

					start: function() {
						var instance = this;

						var popover = instance._popover;

						instance._normalizeStepsConfig();

						instance._setStep(0);

						popover.render();
					},

					_normalizeStepsConfig: function() {
						var instance = this;

						var tutorialSteps = instance._tutorialSteps;

						var length = 0;

						A.each(
							tutorialSteps,
							function(item, index) {
								var alignNode = A.one(item.align.node);

								item.align.node = alignNode;

								if (alignNode && alignNode.test(':visible') && !alignNode.hasClass('hide')) {
									length++;
								}

								if (!item.align.points) {
									item.align.points = instance.DEFAULT_ALIGN_POINTS;
								}
							}
						);

						instance._availableStepsLength = length;
						instance._tutorialSteps = tutorialSteps;
					},

					_onFooterButtonClick: function(event) {
						var instance = this;

						var currentTarget = event.currentTarget;

						var action = currentTarget.attr('data-action');

						if (instance[action]) {
							instance[action]();
						}
					},

					_setCustomPosition: function(val) {
						var instance = this;

						var popoverBoundingBox = instance._popover.get('boundingBox');

						var prevVal = instance.get('customPosition');

						if (prevVal) {
							popoverBoundingBox.removeClass(prevVal);
						}

						popoverBoundingBox.addClass(val);

						return val;
					},

					_setStep: function(index) {
						var instance = this;

						instance.fire(
							'stepChange',
							{
								newVal: index,
								prevVal: instance.get('stepIndex')
							}
						);

						var popover = instance._popover;

						var tutorialStep = instance._tutorialSteps[index];

						if (tutorialStep.before) {
							tutorialStep.before();
						}

						instance._syncAvailableActions(index);

						popover.set('bodyContent', tutorialStep.bodyContent);

						popover.set('position', tutorialStep.position || 'bottom');

						instance.set('customPosition', tutorialStep.customPosition || '');

						var node = tutorialStep.align.node;

						if (tutorialStep.align.selector) {
							node = A.one(tutorialStep.align.selector);
						}

						popover.align(node, tutorialStep.align.points);

						var previousTutorialStep = instance._tutorialSteps[instance.get('stepIndex')];

						if (instance._firstStepChange && previousTutorialStep && previousTutorialStep.after) {
							instance._executeAfter(previousTutorialStep);
						}
						instance._firstStepChange = true;
					},

					_syncAvailableActions: function(index) {
						var instance = this;

						var boundingBox = instance._popover.get('boundingBox');

						var length = instance._availableStepsLength - 1;

						boundingBox.toggleClass('first-step', index <= 0);
						boundingBox.toggleClass('last-step', index >= length);
					},

					_executeAfter : function(step){
						if(typeof step.after === 'function'){
							step.after();
						} else{
							if(step.after.action == 'click' || step.after.action == 'dblclick'){
								step.align.node.simulate(step.after.action)
							} else if(step.after.action == 'http'){
								document.location.href = step.after.value;
							}
						}
					}
				}
			}
		);

		Liferay.TutorialPopover = TutorialPopover;

		var TutorialModal = A.Component.create(
			{
				EXTENDS: A.Base,

				NAME: 'tutorialmodal',

				prototype: {
					showInfo: function(data) {
						var instance = this;

						var modal = instance._getModal();

						modal.set('bodyContent', data.text);

						instance._setHeaderContent(data.title);

						var footer = data.footer;

						if (!footer) {
							footer = null;
						}

						modal.set('footerContent', footer);

						modal.align();
						modal.show();
					},

					_getModal: function() {
						var instance = this;

						var modal = instance._modal;

						if (!modal) {
							modal = instance._renderModal();

							instance._modal = modal;
						}
						else {
							modal.setAttrs(instance._getModalSize());
						}

						return modal;
					},

					_getModalSize: function() {
						var size = {
							width: 700
						};

						if (Util.isTablet()) {
							size = {
								height: '90%',
								width: '90%'
							};
						}

						return size;
					},

					_renderModal: function() {
						var instance = this;

						var config = A.mix(
							instance._getModalSize(),
							{
								centered: true,
								headerContent: '<h3></h3>',
								modal: true,
								zIndex: 1000
							}
						);

						var modal = new A.Modal(config).render();

						return modal;
					},

					_setHeaderContent: function(content) {
						var instance = this;

						var modal = instance._getModal();

						modal.get('headerContent').item(1).html(content);
					}
				}
			}
		);

		Liferay.TutorialModal = TutorialModal;
	},
	'',
	{
		requires: ['aui-base', 'aui-component', 'aui-modal', 'aui-popover', 'aui-template-deprecated']
	}
);