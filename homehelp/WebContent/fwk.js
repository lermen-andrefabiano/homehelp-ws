var App = {} || App

App.Modulos = {
	Configuracao : {
		URL_REST : 'http://10.0.0.100:8080'
	}
} || App.Modulos

$.ajaxSetup({
	urlBase: "http://10.0.0.100:8080/homehelp/rest/",
	cache : false
});