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

import bilan.entities.Projet;
import bilan.service.IProjetService;

@RestController
@RequestMapping("projets")
public class ProjetController {

@Autowired
private IProjetService projetService;

//Trouver la liste des projets
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Projet> getProjets(){
return projetService.toutsProjets();
}
//Ajouter un nouveau projet
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Projet saveProjet(@RequestBody Projet c, HttpServletResponse response){
return projetService.ajouterProjet(c);
}
//Trouver un projet d'id x
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Projet findProjet(@PathVariable("id") int id){
	return projetService.trouverProjet(id);
}
public IProjetService getProjetService() {
	return projetService;
}
public void setProjetService(IProjetService projetService) {
	this.projetService = projetService;
}



}