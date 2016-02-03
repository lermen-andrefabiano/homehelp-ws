$(document).ready(function(){
	App.Modulos.Especialidade.init();
});

App.Modulos.Especialidade = {
	init : function() {
		App.Modulos.Especialidade.listar();
		$('#btnBuscarEspecialidade').on('click', function(){
			$(this).button('loading');	
			var especialidade = $('#txtBuscarEspecialidade').val();
			App.Modulos.Especialidade.getEspecialidades(especialidade);
		});
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
					self.populaModalExcluir(this);			
				});					
			});				
		}else{
			bootbox.alert('Não foram encontradas especialidades.\nPor favor, refaça sua pesquisa.');
		}		
	},	
	populaModalExcluir : function($a) {			
		var id = $($a).data('id');	
		var esp = $($a).data('esp');
		
		var especialidadeSel = {
			descricao : esp,
			id : id
		};
		
		var template = Handlebars.compile($("#modal-excluir-template").html());			
		$(".modal-content").html(template(especialidadeSel));	
		
		App.Modulos.Especialidade.especialidadeSel = especialidadeSel;
		
		$('#btnExcluir').on('click', function(){
			$(this).button('loading');	
			App.Modulos.Especialidade.excluir(id);
		});				
		
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
	},
	getEspecialidades : function(especialidade) {
		console.log('getEspecialidades');
		var self = this;	
		
		 $.ajax({
			type : 'GET',			
			url : $.ajaxSetup().urlBase + 'especialidade/getEspecialidades?especialidade='+especialidade	
		}).done(function(result){
			self.renderGetEspecialidades(result);			
		}).fail(function(xhr, type){			
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnBuscarEspecialidade').button('reset');
			});			
		}).always(function() {
			console.log('always');
		});		
	},
	renderGetEspecialidades : function(result) {		
		console.log('renderGetEspecialidades', result);
		
		var self = this;
		
		if(result!=undefined){			
			var template = Handlebars.compile($("#get-especialidades-template").html());
			
			$("#bloco-especialidades").html(template(result));
			
			$('#bloco-especialidades a').each(function(index){
				$(this).on('click', function(){
					console.log('.list-group a', this);		
					App.Modulos.Especialidade.populaModalEsp(this);			
				});					
			});				
		}		
		$('#btnBuscarEspecialidade').button('reset');
	},	
	populaModalEsp : function($a) {			
		var id = $($a).data('id');	
		var esp = $($a).data('esp');
		
		var especialidadeSel = {
			descricao : esp,
			id : id
		};
		
		var template = Handlebars.compile($("#modal-esp-template").html());			
		$(".modal-content").html(template(especialidadeSel));	
		
		App.Modulos.Especialidade.especialidadeSel = especialidadeSel;
		
		$('#btnAdd').on('click', function(){
			$(this).button('loading');	
			App.Modulos.Especialidade.incluir();
		});				
		
	},
	incluir : function() {
		console.log('incluir especialidade');
		var self = this;	
		
		var login = JSON.parse(localStorage.getItem('login'));		
		var usuarioId = login.id;				
		var especialidadeId = App.Modulos.Especialidade.especialidadeSel.id;
		var valorCobrado = $('#txtValorCobrado').val();	
		
		 $.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'especialidade/incluir?usuarioId='+usuarioId+'&especialidadeId='+especialidadeId+'&valorCobrado='+valorCobrado			
		}).done(function(result){
			bootbox.alert('Sucesso ao adicionar especialidade.\nObrigado!.', function(){
				$('#btnAdd').button('reset');
				App.Modulos.Especialidade.listar();
			})		
		}).fail(function(xhr, type){
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnAdd').button('reset');
			})			
		}).always(function() {
			console.log('always');
		});
	}
};