$(document).ready(function(){
	App.Modulos.Login.init();
});

App.Modulos.Login = {
	init : function() {
		$('#btnLogin').on('click', function(){
			console.log('click login');
			location.href='home.html';
			//App.Modulos.Login.login();
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
			if (type === 'abort') {
				console.log('request aborted');
			}
		}).always(function() {
		});
		
	},
	render : function(result) {
		App.Modulos.Login.Logou = {};
		
		$.extend(App.Modulos.Login.Logou, result);		
		
		if(App.Modulos.Login.Logou.LoginDTO.id!=null){
			location.href='home.html';
		}else{
			alert('Login inválido!');
		}			
	},
	primeiroAcesso : function(){
		console.log('primeiroAcesso');
		location.href='primeiroAcesso.html';
	}
} || App.Modulos.Login;