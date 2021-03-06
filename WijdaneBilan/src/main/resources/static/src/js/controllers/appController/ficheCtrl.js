app.controller('FicheCtrl',function(ManagerCollabs,ObjectifsEvalues,Evaluations,Collaborateur,Categorie,Encadrant,$filter,$http,$scope,$window,$rootScope,$window){
	$scope.iduse=$window.sessionStorage.idUser;
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
    ObjectifsEvalues.findObjectifsEvalues().then(function(d) {
              $scope.objectifsEvalues = d;
            }); 			
    ManagerCollabs.findCollabs().then(function(d) {
              $scope.collabs = d;
            }); 			
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
	$scope.evaluerObjectif=function(Objectif){
              	$http({
              	    url: 'http://localhost:8181/objectifs/evaluerObjectif/'+Objectif.idEvaluationObj,
              	    method: 'PUT',
              	    data:Objectif
              	})
              	.success(function(response) {
          		          console.log(response);
          				  console.log(JSON.stringify($scope.Objectif));
          				  window.alert("Objectif évalué avec succés !");
          				  });
           };
});
