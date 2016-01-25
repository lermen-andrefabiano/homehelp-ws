$(document).ready(function(){
	App.Modulos.Servicos.init();
});

App.Modulos.Servicos = {
	init : function() {
		$('#btnBuscar').on('click', function(){
			var pesquisa = $('#txtBuscar').val();
			App.Modulos.Servicos.buscar(pesquisa);
		});	
		$('#btnAbrir').on('click', function(){
			App.Modulos.Servicos.abrir();
		});	
		$('.list-group a').each(function(index){
			$(this).on('click', function(){
				console.log('.list-group a', this);
				App.Modulos.Servicos.populaModal(this);
			});		
		});	
	},
	buscar : function(pesquisa) {
		console.log('buscar', pesquisa);
		var self = this;	
		
		 $.ajax({
			type : 'GET',
			url : $.ajaxSetup().urlBase + 'especialidade/get?especialidade='+pesquisa			
		}).done(function(result){
			self.render(result);
		}).fail(function(xhr, type){			
			alert('Erro ao acessar servido!');			
		}).always(function() {
			console.log('always');
		});
		
	},
	render : function(result) {		
		console.log('result', result);
		
		if(result!=undefined){
			App.Modulos.Servicos.result = result;

			var template = Handlebars.compile($("#servicos-template").html());
			
			$(".list-group").html(template(result));
		}else{
			alert('Não foram encontradas especialidades!');
		}
	},
	populaModal : function($a) {			
		var id = $($a).data('id');		 
	
		for (r in App.Modulos.Servicos.result) {
			if(r.id == id){
				App.Modulos.Servicos.ServicoSel = r;
				break;
			}
		}
		
		if(App.Modulos.Servicos.ServicoSel!=undefined){
			var data = {
					title : App.Modulos.Servicos.ServicoSel.especialidade.descricao,
					usuario : App.Modulos.Servicos.ServicoSel.usuario.nome,
					valorCobrado : App.Modulos.Servicos.ServicoSel.valorCobrado
			};
			
			var template = Handlebars.compile($("#modal-servicos-template").html());		
			$(".modal-content").html(template(data));	
		}
	},
	abrir : function() {
		console.log('abrir chamado');
		var self = this;	
		
		var usuarioId = App.Modulos.Login.Logou.LoginDTO.id;
		var prestadorId = App.Modulos.Servicos.ServicoSel.usuario.id;
		var especialidadeId = App.Modulos.Servicos.ServicoSel.especialidade.id;
		var prioridade = 'ALTA';
		
		var info = {
				'observacao' : $('#txtObservacao').val(),
				'descricao' : $('#txtDescricao').val()
		};
		
		 $.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'chamado/abrir?usuarioId='+usuarioId+'&'+prestadorId+'&'+especialidadeId+'&'+prioridade,
			data : info	
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
} || App.Modulos.Servicos;