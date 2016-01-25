var App = {} || App;

App.Modulos = {} || App.Modulos;

$.ajaxSetup({
	urlBase: "http://192.168.10.73:8080/homehelp/rest/",
	cache : false,
	 headers: {
	        'Content-Type':'application/json'
	  },
	  
});