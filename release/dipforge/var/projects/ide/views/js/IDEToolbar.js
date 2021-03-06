/**
 * @class IDEToolbar.Toolbar
 * @extends Ext.container.Viewport
 *
 * The main FeedViewer application
 * 
 * @constructor
 * Create a new Feed Viewer app
 * @param {Object} config The config object
 */

Ext.define('com.dipforge.IDE.Toolbar', {
    extend: 'Ext.toolbar.Toolbar',
    
    alias: 'widget.toolbar',
    suspendLayout: true,
    
    initComponent: function(){
    	  //Ext.QuickTips.init();
        //Ext.apply(this, {
    	  //		items: /*this.createMasterMenu()*/});
        this.callParent(arguments);
    },
    
    
    createMasterMenu: function() {
    	 var menu = Ext.create('Ext.menu.Menu', {
		        id: 'mainMenu',
		        style: {
		            overflow: 'visible'     // For the Combo popup
		        },
		        items: []
		            
		    });
        return menu;
    },
    
    // functions to display feedback
    onButtonClick: function(btn){
        Ext.example.msg('Button Click','You clicked the "{0}" button.', btn.text);
    },

    onItemClick: function(item){
        Ext.example.msg('Menu Click', 'You clicked the "{0}" menu item.', item.text);
    },

    onItemCheck: function(item, checked){
        Ext.example.msg('Item Check', 'You {1} the "{0}" menu item.', item.text, checked ? 'checked' : 'unchecked');
    },

    onItemToggle: function(item, pressed){
        Ext.example.msg('Button Toggled', 'Button "{0}" was toggled to {1}.', item.text, pressed);
    },
 });