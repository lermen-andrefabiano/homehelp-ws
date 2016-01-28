$(document).ready(function(){
	App.Modulos.Home.init();
});

App.Modulos.Home = {
	init : function() {
		var login = JSON.parse(localStorage.getItem('login'));
		console.log('home login', login);		
	},	
};