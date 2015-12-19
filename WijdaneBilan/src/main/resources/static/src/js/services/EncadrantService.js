app.factory('Encadrant', function($http) {
  var promise;
  var Encadrant = {
    findAll: function() {
      if ( !promise ) {
        promise = $http.get("http://localhost:8181/encadrants/findAll").then(function (response) {
          console.log(response);
          return response.data;
        });
      }
      return promise;
    }
  };
  return Encadrant;
})
.factory('Evaluations', function($http,$window) {
  var promise;
  var Evaluations = {
    findEvaluations: function() {
      if ( !promise ) {
        promise = $http.get("http://localhost:8181/objectifs/encadrantObjectifs/"+$window.sessionStorage.idUser).then(function (response) {
          console.log(response);
          return response.data;
        });
      }
      return promise;
    }
  };
  return Evaluations;
})
.factory('ObjectifsEvalues', function($http,$window) {
  var promise;
  var ObjectifsEvalues = {
    findObjectifsEvalues: function() {
      if ( !promise ) {
        promise = $http.get("http://localhost:8181/objectifs/encadrantObjectifsEvalues/"+$window.sessionStorage.idUser).then(function (response) {
          console.log(response);
          return response.data;
        });
      }
      return promise;
    }
  };
  return ObjectifsEvalues;
});