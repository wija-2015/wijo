app.controller('FicheCtrl',function(Evaluations,Collaborateur,Categorie,Encadrant,$filter,$http,$scope,$window,$rootScope,$window){
	Encadrant.findAll().then(function(d) {
              $scope.encadrants = d;
            }); 
   Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            });
	Categorie.findAll().then(function(d) {
              $scope.categories = d;
            });
    Evaluations.findEvaluations().then(function(d) {
              $scope.objectifs = d;
            }); 			
    /* $scope.collabs=[];			
	$scope.chargerManagerCollabs=function(){
		$http.get("http://localhost:8181/managers/collabs/"+$scope.iduse)
		.success(function(data){
		$scope.collabs=data;
		console.log(data);
		});
		}; */
    $scope.chargerCollab=function(){
		$http.get("http://localhost:8181/collaborateurs/collab/"+$scope.objectif.idCollaborateur)
		.success(function(data){
		$scope.collab=data;
		console.log(data);
		});
		};
	$scope.chargerFiche=function(){
		$http.get("http://localhost:8181/objectifs/ficheCollab/"+$scope.idCollaborateur)
		.success(function(data){
		$scope.ficheObjectif=data;
		console.log(data);
		});
		};
	$scope.objectif={} ;
	$scope.objectif.evaluations=[] ;
	$scope.inserer_objectif = function () {
		$scope.objectif.idManager=$window.sessionStorage.idUser ;
    	datas=$scope.objectif ;
    	$http({
    	    url: 'http://localhost:8181/objectifs/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		       window.alert("Objectif inséré !");
				$scope.vider();
				  });
    };
	$scope.vider = function () {
		$scope.objectif={} ;
	    $scope.objectif.evaluations=[] ;
	}
	//Evaluer Objectif par encarant
	$scope.evaluerObjectif=function(objectif){
              	$http({
              	    url: 'http://localhost:8181/objectifs/evaluerObjectif/'+objectif[8],
              	    method: 'PUT',
              	    data:objectif
              	})
              	.success(function(response) {
          		          console.log(response);
          				  console.log(JSON.stringify($scope.collaborateur));
          				  window.alert("Objectif évalué avec succés !");
          				  });
           };
});
