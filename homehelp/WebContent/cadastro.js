$(document).ready(function(){
	App.Modulos.Cadastro.init();
});

App.Modulos.Cadastro = {
	init : function() {
		App.Modulos.Cadastro.getPerfil();
		$('#btnCadastrar').on('click', function(){
			$(this).button('loading');
			App.Modulos.Cadastro.cadastrar();
		});
	},
	getPerfil : function(){
		var login = JSON.parse(localStorage.getItem('login'));	
		
		console.log('getPerfil', login);
		
		$('#txtNome').val(login.nome);
		$('#txtLogin').val(login.login);
		$('#txtEmail').val(login.email);
		$('#txtEndereco').val(login.endereco);
		$('#txtPrestaServico').attr('checked', login.prestaServico);		
		
	},
	cadastrar : function(){
		console.log('cadastrar');
		var self = this;
		
		var login = JSON.parse(localStorage.getItem('login'));		
		
		var data = {
			id : login.id,
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
			self.perfil(login);
		}).fail(function(xhr, type) {
			bootbox.alert('Não foi possível realizar o cadastro.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnCadastrar').button('reset');
			});			
		}).always(function() {
		});		
	},	
	perfil : function(login){
		console.log('perfil', login);
		
		if(login.email!=null && login.email!=''){
			localStorage.setItem('login', JSON.stringify(login));
			location.href='perfil.html';
		}else{
			bootbox.alert('Não foi possível atualizar o seu cadastro.\nPor favor, tente novamente mais tarde.');			
		}				
		$('#btnCadastrar').button('reset');
	}
};