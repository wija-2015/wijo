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

import bilan.entities.Profil;
import bilan.entities.Projet;
import bilan.service.IProfilService;

@RestController
@RequestMapping("profils")
public class ProfilController {

@Autowired
private IProfilService profilService;

//Trouver la liste des profils des encadrants
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Profil> getProfils(){
return profilService.toutsProfils();
} 
//ajouter un nouveau profil
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Profil saveProfil(@RequestBody Profil p, HttpServletResponse response){
	return	profilService.ajouterProfil(p);
}
//Trouver un profil d'id x
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Profil findProfil(@PathVariable("id") int id){
	return profilService.trouverProfil(id);
}
public IProfilService getProfilService() {
	return profilService;
}
public void setProfilService(IProfilService profilService) {
	this.profilService = profilService;
}
}

