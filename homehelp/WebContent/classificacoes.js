$(document).ready(function(){
	App.Modulos.Classificacao.init();
});

App.Modulos.Classificacao = {
	init : function() {
		App.Modulos.Classificacao.classificacoes();		
	},
	classificacoes : function() {
		console.log('classificacoes');
		var self = this;	
		
		var login = JSON.parse(localStorage.getItem('login'));		
		var usuarioId = login.id;
		
		 $.ajax({
			type : 'GET',			
			url : $.ajaxSetup().urlBase + 'chamado/classificacoes?usuarioId='+usuarioId	
		}).done(function(result){
			self.render(result);
		}).fail(function(xhr, type){	
			console.log(xhr, type);
			//bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.');			
		}).always(function() {
			console.log('always');
		});		
	},
	render : function(result) {		
		console.log('classificacoes', result);
		
		if(result!=undefined){
			App.Modulos.Classificacao.classificacoes = result;

			var template = Handlebars.compile($("#classificacoes-template").html());
			
			$(".list-group").html(template(result));
			
			$('.list-group a').each(function(index){
				$(this).on('click', function(){
					console.log('.list-group a', this);
					App.Modulos.Classificacao.populaModal(this);
				});					
			});				
		}else{
			bootbox.alert('Não foram encontrados valores a serem classificados.\nPor favor, refaça sua pesquisa.');
		}		
	},
	populaModal : function($a) {			
		var chamadoId = $($a).data('id');	
	
		for (r in App.Modulos.Classificacao.classificacoes) {
			if(App.Modulos.Classificacao.classificacoes[r].chamadoId == chamadoId){
				App.Modulos.Classificacao.ClassificacaoSel = App.Modulos.Classificacao.classificacoes[r];
				break;
			}
		}
		
		if(App.Modulos.Classificacao.ClassificacaoSel!=undefined){
			console.log(App.Modulos.Classificacao.ClassificacaoSel);
			var data = {
				prestador : App.Modulos.Classificacao.ClassificacaoSel.prestador,
				especialidade : App.Modulos.Classificacao.ClassificacaoSel.especialidade,
				descricao : App.Modulos.Classificacao.ClassificacaoSel.descricao
			};
			
			var template = Handlebars.compile($("#modal-classificacao-template").html());		
			$(".modal-content").html(template(data));	
			
			$('#btnClassificar').on('click', function(){
				$(this).button('loading');	
				App.Modulos.Classificacao.classificar();
			});

			$('[type*="radio"]').change(function () {	
				$('#lbNota').text($(this).attr('value'));
			});
		}
	},
	classificar : function() {		
		console.log('classificar chamado');
		var self = this;		
		
		var chamadoId = App.Modulos.Classificacao.ClassificacaoSel.chamadoId;			
		
		var info = {	
			'recomendacao' : $('#txtRecomendacao').val(),
			'nota' : $('#lbNota').text()
		};
		
		 $.ajax({
			type : 'POST',
			url : $.ajaxSetup().urlBase + 'chamado/classificar?chamadoId='+chamadoId,
			data : JSON.stringify(info)	
		}).done(function(result){
			bootbox.alert('Recomendação recebida.\nObrigado!', function(){
				$('#btnClassificar').button('reset');
				location.reload(); 
			})						
		}).fail(function(xhr, type){
			bootbox.alert('Sistema indisponível.\nPor favor, tente novamente mais tarde.', function(){
				$('#btnClassificar').button('reset');
			})			
		}).always(function() {
			console.log('always');
		});
		
	}
};