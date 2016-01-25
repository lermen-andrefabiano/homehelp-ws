$(document).ready(function(){
	App.Modulos.Servicos.init();
});

App.Modulos.Servicos = {
	init : function() {
		$('#btnBuscar').on('click', function(){
			var pesquisa = $('#txtBuscar').val();
			App.Modulos.Servicos.buscar(pesquisa);
		});		
	},
	buscar : function(pesquisa) {
		console.log('buscar', pesquisa);
		var self = this;	
		
		var data = {'especialidade':pesquisa};
		
		 $.ajax({
			type : 'GET',
			url : $.ajaxSetup().urlBase + 'especialidade/get',
			data : data	
		}).done(function(result){
			self.render(result);
		}).fail(function(xhr, type){
			if (type === 'abort') {
				console.log('request aborted');
			}
		}).always(function() {
			console.log('always');
		});
		
	},
	render : function(result) {		
		console.log('result', result);
		
		var data = {
			titulo : result.especialidade.descricao,
			prestador : result.usuario,
			valor : result.valorCobrado
		}
		
		var template = Handlebars.compile($("#servicos-template").html());
		
		$(".list-group").html(template(data));
		
	}	
} || App.Modulos.Servicos;