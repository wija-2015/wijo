app.controller("FeedbackCtrl",function(ManagerCollabs,Collaborateur,Projet,Theme,$scope,$http,$window){
	
    Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            });  
    Projet.findAll().then(function(d) {
              $scope.projets = d;
            });
	Theme.findAll().then(function(d) {
              $scope.themes = d;
            });
    ManagerCollabs.findCollabs().then(function(d) {
              $scope.colls = d;
            });			
  	
	$scope.feedback={} ;
	$scope.feedback.qualification=[] ;
    $scope.inserer_feedback = function () {
		$scope.feedback.idEncadrant=$window.sessionStorage.idUser;
    	datas=$scope.feedback ;
    	$http({
    	    url: 'http://localhost:8181/feedbacks/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		       window.alert("Feedback inséré !");
				$scope.vider();
				  });
    };
	
	$scope.vider = function () {
		$scope.feedback=null ;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////: get Feedbacks of collab
	//$scope.collabfeedbacks={} ;
	$scope.pageCourante=0;	
	$scope.pages=new Array();
    $scope.getEncadrantFeedbacks=function(){
    $http.get("http://localhost:8181/feedbacks/encadrantFeedbacks/"+$scope.idCollaborateur+"/"+$window.sessionStorage.idUser+"/"+$scope.pageCourante)
	   .success(function(data){
	   $scope.collabfeedbacks=data;
	   $scope.pages=new Array(data.totalPages);
	   console.log(data);
	   });
	};
	$scope.gotoPage1=function(page){
      $scope.pageCourante=page;
	  $scope.getEncadrantFeedbacks();
    };
	
    $scope.getCollabFeedbacks=function(){
    $http.get("http://localhost:8181/feedbacks/collabFeedbacks/"+$scope.idCollaborateur+"/"+$scope.pageCourante)
	   .success(function(data){
	   $scope.collabfeedbacks=data;
	   $scope.pages=new Array(data.totalPages);
	   console.log(data);
	   });
	};
	$scope.gotoPage2=function(page){
      $scope.pageCourante=page;
	  $scope.getCollabFeedbacks();
    };
	
	//$scope.collabors=[];
	$scope.getMangerCollabs=function(){
      $http.get("http://localhost:8181/managers/collabs/"+$window.sessionStorage.idUser)
	  .success(function(data){
	   $scope.collabors=data;
	   console.log(data);
	   });
	};

});