package bilan.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.entities.Managerrh;
import bilan.entities.Categorie;
import bilan.entities.Projet;
import bilan.service.ICategorieService;

@RestController
@RequestMapping("categories")
public class CategorieController {

@Autowired
private ICategorieService categorieService;

//Avoir la liste des categories
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Categorie> getCategories(){
return categorieService.toutsCategories();
}
//Ajouter une nouvelle categorie à la base de données
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Categorie saveCategorie(@RequestBody Categorie c, HttpServletResponse response){
return categorieService.ajouterCategorie(c);
}
//Trouver une categorie d'id x
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Categorie findCategorie(@PathVariable("id") int id){
	return categorieService.trouverCategorie(id);
}

public ICategorieService getCategorieService() {
	return categorieService;
}
public void setCategorieService(ICategorieService categorieService) {
	this.categorieService = categorieService;
}


}
