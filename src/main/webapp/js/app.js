var App = angular.module('App', [
'ngRoute',
'controllers',
'services'
]);

App.config(function($routeProvider){
	$routeProvider
	.when('/', {
		templateUrl: 'views/agente/agente.html',
		controller: 'AgenteCtrl'
	})

	.when('/criaAgente', {
		templateUrl: 'views/agente/criaAgente.html',
		controller: 'AgenteCtrl'
	})

	.when('/editarAgente', {
		templateUrl: 'views/agente/editarAgente.html',
		controller: 'AgenteCtrl'
	})
});

App.value('API', 'http://localhost:8080/angular-app/service/');