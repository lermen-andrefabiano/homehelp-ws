$(document).ready(function(){
	App.Modulos.Senha.init();
});

App.Modulos.Senha = {
	init : function() {
		$('#btnTrocaSenha').on('click', function(){
			$(this).button('loading');				
			App.Modulos.Senha.trocarSenha();
		});		
	},
	trocarSenha : function(){
		console.log('trocarSenha');
		
		var self = this;
		var login = JSON.parse(localStorage.getItem('login'));		
		var usuarioId = login.id;
		
		$.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'usuario/senha?usuarioId='+usuarioId,
			data : $('#txtNovaSenha').val(),
		}).done(function() {
			bootbox.alert('Senha alterada com sucesso.', function(){
				self.perfil();
			});			
		}).fail(function(xhr, type) {
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnTrocaSenha').button('reset');
			});				
		}).always(function() {
		});
		
	},
	perfil : function(){
		$('#btnTrocaSenha').button('reset');		
		location.href='perfil.html';
	}
} || App.Modulos.Senha;