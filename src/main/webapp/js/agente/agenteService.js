App.factory("AgenteService", function($http, API){
	return {
		list: function(){
			return $http.get(API+'agente');
		},
		create: function(item){
			return $http.post(API+'agente', item);
		},
		update: function(item){
			return $http.post(API+'agente/alterar', item);	
		},
		remove: function(item){
			return $http.post(API+'agente/delete', item);
		}
	}
})