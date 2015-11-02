$(document).ready(function(){
	App.Modulos.Login.init();
});

App.Modulos.Login = {
	init : function() {
		$('#txtLogin').on('click', function(){
			App.Modulos.Login.login();
		});
		$('#txtPrimeiroAcesso').on('click', function(){
			App.Modulos.Login.primeiroAcesso();
		});
	},
	listar : function() {
		var self = this;		
		
		 $.ajax({
			type : 'GET',
			url : $.ajaxSetup().urlBase + 'indicador/notas',
			data : App.Modules.KPI.IndicadorAtual,
			beforeSend : function(xhr) {
				carregando(true);
				new ElapsedTimeListener(xhr);
			},
			error : App.Modules.KPI.Dados.tratarErrosServidor
		}).done(function(notas){
			self.render(notas);
		}).fail(function(xhr, type){
			if (type === 'abort') {
				console.log('request aborted');
			}
		}).always(function() {
			carregando(false);
		});
		
	},
	render : function() {
		
		var data = {
				title : 'andre fabiano  lermen',
				body : 'This is my first post!'
		}
		
		$("#conteudo").html(this.template(data));
		
	},
	login : function(){
		console.log('login');
		App.Modulos.Login.Logou = {
				id : '1'
		};
		
		location.href='home.html';
	},
	primeiroAcesso : function(){
		console.log('primeiroAcesso');
		location.href='primeiroAcesso.html';
	}
} || App.Modulos.Login;