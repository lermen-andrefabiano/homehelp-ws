$(document).ready(function(){
	App.Modulos.Senha.init();
});

App.Modulos.Senha = {
	init : function() {
		$('#btnPrimeiroAcesso').on('click', function(){
			$(this).button('loading');				
			App.Modulos.Senha.trocarSenha();
		});		
	},
	trocarSenha : function(){
		console.log('login');
		
		var login = {
			senha : $('#txtNovaSenha').val()
		};		

		$.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'usuario/senha',
			data : login,
		}).done(function(result) {
			self.home(result);
		}).fail(function(xhr, type) {
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnPrimeiroAcesso').button('reset');
			});				
		}).always(function() {
		});
		
	},
	home : function(result){
		$('#btnPrimeiroAcesso').button('reset');
		console.log('home', result);
		location.href='home.html';
	}
} || App.Modulos.Senha;