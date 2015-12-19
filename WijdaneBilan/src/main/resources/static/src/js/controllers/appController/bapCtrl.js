app.controller("bapCtrl",function(ManagerCollabs,Collaborateur,$rootScope,$scope,$http,$state,$window){
	
	Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            }); 
	ManagerCollabs.findCollabs().then(function(d) {
              $scope.collabs = d;
            }); 
			
    $scope.chargerBapsAdmin=function(){
		$http.get("http://localhost:8181/baps/collabBaps/"+$scope.idCollaborateur)
		.success(function(data){
		$scope.baps=data;
		console.log(data);
		});
		};	
			
});

