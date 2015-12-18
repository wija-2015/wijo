app.factory('Collaborateur', function($http) {
  var promise;
  var Collaborateur = {
    findAll: function() {
      if ( !promise ) {
	     // $http.get(...) : c'est une promesse
		//valeur de retour promise (on peut metre .then apres ) 
		//la fct dans .then() représente le callback du succés
		// .then() permet d’appeler des callbacks de succès ou d’erreur , sa signature :then(successCallback, errorCallback, notifyCallback)
        promise = $http.get("http://localhost:8181/collaborateurs/findAll").then(function (response) {
          // Test Console
          console.log(response);
          // la valeur de retour sera reccuperé par le controller a travers Then()
          return response.data;
        });
      }
      // Retourner la Promise
      return promise;
    }
  };
  return Collaborateur;
})
.factory('AuthenticationService', function() {
    var isAuthenticated = false ;
        return isAuthenticated;
    })
.factory('FicheObjectif', function($http,$window) {
  var promise;
  var FicheObjectif = {
    findFicheObjectif: function() {
      if ( !promise ) {
         promise = $http.get("http://localhost:8181/objectifs//ficheCollab/"+$window.sessionStorage.idUser).then(function (response) {
          console.log(response);
          return response.data;
        });
      }
      return promise;
    }
  };
  return FicheObjectif;
});