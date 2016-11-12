App.controller('AgenteCtrl', function($scope, AgenteService, $route,$routeParams,$location,EnvioService){
	$scope.agente = [];
	$scope.agenteEditar = {};

	$scope.notFound = false;
	AgenteService.list().then(function(data){
		$scope.agente = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.agenteEditar = EnvioService.getParametro();
	
	$scope.deletar = function(item){
		AgenteService.remove(item).then(function(data){
			console.log(item);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.agenteEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarAgente');
	}

	$scope.atualizar = function(item){
		AgenteService.update(item).then(function(data){
				$location.path('/');
			});
	}
	
	$scope.cadastrar = function(agente){
			AgenteService.create(agente).then(function(data){
				$location.path('/');
			});
	}
	
});