$(document).ready(function(){
	App.Modulos.PrimeiroAcesso.init();
});

App.Modulos.PrimeiroAcesso = {
	init : function() {
		$('#btnCadastrar').on('click', function(){
			$(this).button('loading');
			App.Modulos.PrimeiroAcesso.cadastrar();
		});
	},
	cadastrar : function(){
		console.log('cadastrar');
		
		var login = {
			nome : $('#txtNome').val(),
			login : $('#txtLogin').val(),
			email : $('#txtEmail').val(),
			endereco : $('#txtEndereco').val(),
			prestaServico : $('#txtPrestaServico').is(":checked"),			
			senha : $('#txtSenha').val()
		};		

		$.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'usuario/criar',
			data : login,
		}).done(function(result) {
			self.home(result);
		}).fail(function(xhr, type) {
			bootbox.alert('Não foi possível realizar o cadastro.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnCadastrar').button('reset');
			});			
		}).always(function() {
		});		
	},	
	home : function(result){
		$('#btnCadastrar').button('reset');
		console.log('home', result);
		location.href='home.html';
	}
} || App.Modulos.PrimeiroAcesso;