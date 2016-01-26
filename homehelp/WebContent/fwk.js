var App = {} || App;

App.Modulos = {} || App.Modulos;

$.ajaxSetup({
	urlBase: "http://localhost:8080/homehelp/rest/",
	cache : false,
//	headers:{
//        'Access-Control-Allow-Origin'   : '*',
//        'Accept'                        : 'application/json',
//        'Content-Type' : 'application/json',
//    },
	dataType: 'json'	  
});