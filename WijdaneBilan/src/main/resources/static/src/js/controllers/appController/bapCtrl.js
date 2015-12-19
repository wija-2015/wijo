app.controller("bapCtrl",function(Collaborateur,$rootScope,$scope,$http,$state,$window){
	
	Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            }); 
	
    $scope.chargerBapsAdmin=function(){
		$http.get("http://localhost:8181/baps/collabBaps/"+$scope.idCollaborateur)
		.success(function(data){
		$scope.baps=data;
		console.log(data);
		});
		};	
			
});

