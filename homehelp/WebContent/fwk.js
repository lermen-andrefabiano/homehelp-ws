var App = {
		Modulos : {}
} || App;

$.ajaxSetup({
	urlBase: "http://localhost:8080/homehelp/rest/",
	cache : false,
	headers:{
//        'Access-Control-Allow-Origin'   : '*',
//        'Accept'                        : 'application/json',
        'Content-Type' : 'application/json; charset=utf-8',
    },
	dataType: 'json'	  
});