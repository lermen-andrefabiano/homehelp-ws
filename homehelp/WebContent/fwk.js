var App = {} || App

App.Modulos = {
	Configuracao : {
		URL_REST : 'http://10.0.0.100:8080'
	}
} || App.Modulos

App.FWK = {
		listaMais : function(){
			$(".listamaisdeagrade .title_listamais").click(function() {
				$(".listamaisdeagrade ul").slideUp();
				$(".listamaisdeagrade .title_listamais").removeClass("acitve_llistamais");
				if ($(this).next("ul").is(":hidden")){
					$(this).next("ul").slideDown();
					$(this).addClass("acitve_llistamais");
				} 
				else {
					$(this).next("ul").slideUp();
					$(this).removeClass("acitve_llistamais");
				}
			});
		}
}