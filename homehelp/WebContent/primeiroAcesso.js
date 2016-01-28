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
		var self = this;
		
		var data = {
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
			data : JSON.stringify(data),
		}).done(function(login) {
			self.home(login);
		}).fail(function(xhr, type) {
			bootbox.alert('Não foi possível realizar o cadastro.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnCadastrar').button('reset');
			});			
		}).always(function() {
		});		
	},	
	home : function(login){
		console.log('home', login);
		
		if(login.email!=null && login.email!=''){
			localStorage.setItem('login', JSON.stringify(login));
			location.href='home.html';
		}else{
			bootbox.alert('Não foi possível realizar o cadastro.\nPor favor, tente novamente.');			
		}				
		$('#btnCadastrar').button('reset');
	}
};