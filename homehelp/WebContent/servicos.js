$(document).ready(function(){
	App.Modulos.Servicos.init();
});

App.Modulos.Servicos = {
	init : function() {
		$('#btnBuscar').on('click', function(){
			$(this).button('loading');	
			var pesquisa = $('#txtBuscar').val();
			App.Modulos.Servicos.buscar(pesquisa);
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
			console.log(xhr, type);
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnBuscar').button('reset');
			});			
		}).always(function() {
			console.log('always');
		});		
	},
	render : function(result) {		
		console.log('especialidades', result);
		
		if(result!=undefined){
			App.Modulos.Servicos.especialidades = result;

			var template = Handlebars.compile($("#servicos-template").html());
			
			$(".list-group").html(template(result));
			
			$('.list-group a').each(function(index){
				$(this).on('click', function(){
					console.log('.list-group a', this);
					App.Modulos.Servicos.populaModal(this);
				});					
			});				
		}else{
			bootbox.alert('Não foram encontradas especialidades.\nPor favor, refaça sua pesquisa.');
		}
		$('#btnBuscar').button('reset');
	},
	populaModal : function($a) {			
		var id = $($a).data('id');	
	
		for (r in App.Modulos.Servicos.especialidades.especialidades) {
			if(App.Modulos.Servicos.especialidades.especialidades[r].id == id){
				App.Modulos.Servicos.ServicoSel = App.Modulos.Servicos.especialidades.especialidades[r];
				break;
			}
		}
		
		if(App.Modulos.Servicos.ServicoSel!=undefined){
			console.log(App.Modulos.Servicos.ServicoSel);
			var data = {
				title : App.Modulos.Servicos.ServicoSel.especialidade.descricao,
				usuario : App.Modulos.Servicos.ServicoSel.usuario.nome,
				valorCobrado : App.Modulos.Servicos.ServicoSel.valorCobrado
			};
			
			var template = Handlebars.compile($("#modal-servicos-template").html());		
			$(".modal-content").html(template(data));	
			
			$('#btnAbrir').on('click', function(){
				$(this).button('loading');	
				App.Modulos.Servicos.abrir();
			});		
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
			bootbox.alert('Sucesso ao abrir chamado.\nAguarde contato.')
			$('#btnAbrir').button('reset');
		}).fail(function(xhr, type){
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.')
			$('#btnAbrir').button('reset');
		}).always(function() {
			console.log('always');
		});
		
	},
} || App.Modulos.Servicos;