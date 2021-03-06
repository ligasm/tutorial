var pathContext = Liferay.ThemeDisplay.getPathContext() ? Liferay.ThemeDisplay.getPathContext() : "";
var tutorial = Liferay.ThemeDisplay.getPortalURL() + pathContext + '/tutorial-portlet/js/';

AUI().applyConfig({
    modules: {
        'tutorial': {
            fullpath: tutorial + 'tutorial.js',
            requires: ['aui-base', 'aui-component', 'tutorial-popover', 'liferay-store']
        },
        'tutorial-popover': {
            fullpath: tutorial + 'tutorial_popover.js',
            requires: ['aui-base', 'aui-component', 'aui-modal', 'aui-popover', 'aui-template-deprecated', 'aui-node','node-event-simulate']
        },
        'tutorial-setup': {
            fullpath: tutorial + 'tutorial_setup.js',
            requires: ['aui-base', 'aui-component', 'aui-popover', 'node-event-delegate','aui-sortable-list','aui-modal']
        }
    }
});
