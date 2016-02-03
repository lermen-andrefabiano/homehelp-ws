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
		
		if(result!=undefined){			
			var template = Handlebars.compile($("#especialidades-template").html());
			
			$(".list-group").html(template(result));
			
			$('.list-group a').each(function(index){
				$(this).on('click', function(){
					console.log('.list-group a', this);					
				});					
			});				
		}else{
			bootbox.alert('Não foram encontradas especialidades.\nPor favor, refaça sua pesquisa.');
		}		
	}	
};