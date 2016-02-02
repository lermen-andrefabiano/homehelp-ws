$(document).ready(function(){
	App.Modulos.Notificacao.init();
});

App.Modulos.Notificacao = {
	init : function() {
		App.Modulos.Notificacao.notificacoes();		
	},
	notificacoes : function() {
		console.log('notificacoes');
		var self = this;	
		
		var login = JSON.parse(localStorage.getItem('login'));		
		var usuarioId = login.id;
		
		 $.ajax({
			type : 'GET',			
			url : $.ajaxSetup().urlBase + 'chamado/notificacoes?usuarioId='+usuarioId	
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
		console.log('notificacoes', result);
		
		if(result!=undefined){
			App.Modulos.Notificacao.notificacoes = result;

			var template = Handlebars.compile($("#servicos-template").html());
			
			$(".list-group").html(template(result));
			
			$('.list-group a').each(function(index){
				$(this).on('click', function(){
					console.log('.list-group a', this);
					App.Modulos.Notificacao.populaModal(this);
				});					
			});				
		}else{
			bootbox.alert('Não foram encontradas especialidades.\nPor favor, refaça sua pesquisa.');
		}		
	},
	populaModal : function($a) {			
		var id = $($a).data('id');	
	
		for (r in App.Modulos.Notificacao.notificacoes) {
			if(App.Modulos.Notificacao.notificacoes[r].id == id){
				App.Modulos.Notificacao.NotificacaoSel = App.Modulos.Notificacao.notificacoes[r];
				break;
			}
		}
		
		if(App.Modulos.Notificacao.NotificacaoSel!=undefined){
			console.log(App.Modulos.Notificacao.NotificacaoSel);
			var data = {
				title : App.Modulos.Notificacao.NotificacaoSel.data,
				especialidade : App.Modulos.Notificacao.NotificacaoSel.especialidade,
				endereco : App.Modulos.Notificacao.NotificacaoSel.endereco
			};
			
			var template = Handlebars.compile($("#modal-notificacao-template").html());		
			$(".modal-content").html(template(data));	
			
			$('#btnAgendar').on('click', function(){
				$(this).button('loading');	
				App.Modulos.Notificacao.agendar();
			});		
			
			$('#btnRejeitar').on('click', function(){
				$(this).button('loading');	
				App.Modulos.Notificacao.rejeitar();
			});		
			
			$('#dateTimeAgenda').datetimepicker({
				format: "DD/MM/YYYY HH:mm"
			});
		}
	},
	agendar : function() {		
		console.log('agendar chamado');
		var self = this;	

		var chamadoId = App.Modulos.Notificacao.NotificacaoSel.id;			
		
		var info = {	
			'observacao' : $('#txtDescricao').val(),
			'agendamento' : $('#dateTimeAgenda').data("DateTimePicker").date()._d
		};
		
		 $.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'chamado/agendar?chamadoId='+chamadoId,
			data : JSON.stringify(info)	
		}).done(function(result){
			bootbox.alert('Sucesso ao agendar chamado.\nAguarde contato.', function(){
				$('#btnAgendar').button('reset');
				location.reload(); 
			})						
		}).fail(function(xhr, type){
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnAgendar').button('reset');
			})			
		}).always(function() {
			console.log('always');
		});
		
	},	
	rejeitar : function() {		
		console.log('rejeitar chamado');
		var self = this;		

		var chamadoId = App.Modulos.Notificacao.NotificacaoSel.id;	
		
		 $.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'chamado/rejeitar?chamadoId='+chamadoId
		}).done(function(result){
			bootbox.alert('Chamado rejeitado.', function(){
				$('#btnRejeitar').button('reset');
				location.reload(); 
			})					
		}).fail(function(xhr, type){
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnRejeitar').button('reset');
			})			
		}).always(function() {
			console.log('always');
		});
		
	},
};