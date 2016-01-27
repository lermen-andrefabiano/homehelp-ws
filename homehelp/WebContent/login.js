$(document).ready(function(){
	App.Modulos.Login.init();
});

App.Modulos.Login = {
	init : function() {
		$('#btnLogin').on('click', function(){
			$(this).button('loading');				
			App.Modulos.Login.login();
		});
		$('#btnPrimeiroAcesso').on('click', function(){
			App.Modulos.Login.primeiroAcesso();
		});
	},
	login : function(){
		console.log('login');
		
		var login = {
			login : $('#txtLogin').val(),
			senha : $('#txtSenha').val()
		};		

		$.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'usuario/login',
			data : login,
		}).done(function(result) {
			self.render(result);
		}).fail(function(xhr, type) {
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnLogin').button('reset');
			});				
		}).always(function() {
		});
		
	},
	render : function(result) {
		App.Modulos.Login.Logou = {};
		
		$.extend(App.Modulos.Login.Logou, result);		
		
		if(App.Modulos.Login.Logou.LoginDTO.id!=null){
			location.href='home.html';
		}else{
			bootbox.alert('Login inválido!\nPor favor, tente novamente.');			
		}		
		$('#btnLogin').button('reset');
	},
	primeiroAcesso : function(){
		console.log('primeiroAcesso');
		location.href='primeiroAcesso.html';
	}
} || App.Modulos.Login;