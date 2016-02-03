$(document).ready(function(){
	App.Modulos.Perfil.init();
});

App.Modulos.Perfil = {
	init : function() {
		console.log('perfil...');
		App.Modulos.Perfil.getPerfil();
		
		$('#btnSair').on('click', function(){
			$(this).button('loading');		
			App.Modulos.Perfil.sair();
		});
	},	
	getPerfil : function(){		
		var login = JSON.parse(localStorage.getItem('login'));		
		$('#lbPerfil').text(login.nome);
		
		if(login.prestaServico == false){
			$('#linkEspecialidade').hide();
		}		
	},
	sair : function(){
		console.log('sair...');
		localStorage.removeItem("login");
		location.href='index.html';
		$('#btnSair').button('reset');		
	}
};