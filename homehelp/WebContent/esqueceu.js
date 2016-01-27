$(document).ready(function(){
	App.Modulos.EsqueceuSenha.init();
});

App.Modulos.EsqueceuSenha = {
	init : function() {
		$('#btnEnviarSenha').on('click', function(){
			$(this).button('loading');				
			App.Modulos.EsqueceuSenha.esqueceu();
		});		
	},
	esqueceu : function(){
		console.log('esqueceu');	

		$.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'usuario/esqueceu/'+$('#txtEmail').val(),
		}).done(function(result) {
			self.home(result);
		}).fail(function(xhr, type) {
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnEnviarSenha').button('reset');
			});				
		}).always(function() {
		});
		
	},
	home : function(result){
		$('#btnEnviarSenha').button('reset');
		console.log('home', result);
		location.href='home.html';
	}
} || App.Modulos.EsqueceuSenha;