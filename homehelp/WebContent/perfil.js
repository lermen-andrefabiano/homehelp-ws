$(document).ready(function(){
	App.Modulos.Perfil.init();
});

App.Modulos.Perfil = {
	init : function() {
		console.log('perfil...');
		App.Modulos.Perfil.getPerfil();
	},	
	getPerfil : function(){		
		var login = JSON.parse(localStorage.getItem('login'));		
		$('#lbPerfil').text(login.nome);
	}
};