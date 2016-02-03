$(document).ready(function(){
	App.Modulos.Especialidade.init();
});

App.Modulos.Especialidade = {
	init : function() {
		App.Modulos.Especialidade.listar();
	},
	listar : function() {
		console.log('listar especialidades');
		var self = this;	

		var login = JSON.parse(localStorage.getItem('login'));		
		var prestadorId = login.id;
		
		 $.ajax({
			type : 'GET',			
			url : $.ajaxSetup().urlBase + 'especialidade/getEspecialidaPrestador?prestadorId='+prestadorId	
		}).done(function(result){
			self.render(result);
		}).fail(function(xhr, type){	
			console.log(xhr, type);
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.');			
		}).always(function() {
			console.log('always');
		});		
	},
	render : function(result) {		
		console.log('especialidades', result);
		
		var self = this;
		
		if(result!=undefined){			
			var template = Handlebars.compile($("#especialidades-template").html());
			
			$(".list-group").html(template(result));
			
			$('.list-group a').each(function(index){
				$(this).on('click', function(){
					console.log('.list-group a', this);		
					var id = $(this).data('id');
					self.excluir(id);			
				});					
			});				
		}else{
			bootbox.alert('Não foram encontradas especialidades.\nPor favor, refaça sua pesquisa.');
		}		
	},	
	excluir : function(id) {
		var self = this;	
		
		 $.ajax({
			type : 'GET',			
			url : $.ajaxSetup().urlBase + 'especialidade/excluir?usuarioEspecialidadeId='+id	
		}).done(function(result){			
			bootbox.alert('Especialidade excluída.', function(){
				App.Modulos.Especialidade.listar();
			});		
		}).fail(function(xhr, type){			
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.');			
		}).always(function() {
			console.log('always');
		});				
	}
};