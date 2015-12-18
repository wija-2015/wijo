app.controller("forms",function($scope,$window){
$scope.isManager=$window.sessionStorage.isManager ;
	$scope.isCollab= $window.sessionStorage.isCollab ;
	$scope.isAdmin= $window.sessionStorage.isAdmin ;
     $scope.isEncadrant= $window.sessionStorage.isEncadrant ;

  })
  ; 