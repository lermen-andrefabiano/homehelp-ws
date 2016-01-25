$(document).ready(function(){
	App.Modulos.PrimeiroAcesso.init();
});

App.Modulos.PrimeiroAcesso = {
	init : function() {
		$('#btnCadastrar').on('click', function(){
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
			self.render(result);
		}).fail(function(xhr, type) {
			if (type === 'abort') {
				console.log('request aborted');
				alert('Não foi possível realizar o cadastro');
			}
		}).always(function() {
		});
		
	},	
	home : function(){
		console.log('home');
		location.href='home.html';
	}
} || App.Modulos.Login;