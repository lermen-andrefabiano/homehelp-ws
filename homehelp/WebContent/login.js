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
		var self = this;
		
		var data = {
			login : $('#txtLogin').val(),
			senha : $('#txtSenha').val()
		};		

		$.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'usuario/login',
//			contentType: "application/json; charset=utf-8",
//			dataType: 'json',
			data : JSON.stringify(data),
		}).done(function(login) {
			self.render(login);
		}).fail(function(xhr, type) {
			console.log(xhr, type);
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnLogin').button('reset');
			});				
		}).always(function() {
		});
		
	},
	render : function(login) {
		console.log('login', login);
		
		if(login.email!=null && login.email!=''){
			localStorage.setItem('login', JSON.stringify(login));
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
};