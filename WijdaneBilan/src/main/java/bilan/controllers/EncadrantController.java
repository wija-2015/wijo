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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bilan.dtos.CollaborateurDTO;
import bilan.dtos.EncadrantDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;
import bilan.entities.Managerrh;
import bilan.entities.Profil;
import bilan.service.IEncadrantService;
import bilan.service.IProfilService;

@RestController
@RequestMapping("encadrants")
public class EncadrantController {

@Autowired
private IEncadrantService encadrantService;
@Autowired
private IProfilService profilService;

//Modifier les données d'un encadrant 
@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
public int updateEncadrant(@PathVariable("id")  int id,@RequestBody Encadrant c){
	 return encadrantService.modifierEncadrant(c.getNomUser(), c.getPrenomUser(),c.getMailUser(),c.getMatriculeUser(), id);
}
//S'authentifier
@RequestMapping(value="signin", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public long signinCollab(@RequestBody Encadrant c, HttpServletResponse response){
	 if(encadrantService.verify(c.getMailUser(), c.getMatriculeUser())==0) {
		 return 0 ;
	 }
	 else 
		 return encadrantService.getIdEncadrant(c.getMailUser(), c.getMatriculeUser());
} 
//Avoir tous les encadrants
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Encadrant> getManagers(){
return encadrantService.toutsEncadrants();
}
//Ajouter un nouvel encadrant
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Encadrant saveEncadrant(@RequestBody EncadrantDTO c,HttpServletResponse response){

	Encadrant enc=new Encadrant();
	enc.setNomUser(c.getNomUser());
	enc.setPrenomUser(c.getPrenomUser());
	enc.setMailUser(c.getMailUser());
	enc.setMatriculeUser(c.getMatriculeUser());
	enc.setPassword(c.getPassword());
	Profil p= new Profil();
	p=profilService.trouverProfil(c.getIdProfil());
	enc.setProfil(p);
	return encadrantService.ajouterEncadrant(enc) ;
}
//Trouver encadrant d'id x
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Encadrant findEncadrant(@PathVariable("id") int id){
	return encadrantService.trouverEncadrant(id);
}
//Trouver les collaborateurs d'un encadrants
@RequestMapping(value="/collabs/{id}", method = RequestMethod.GET)
public List<Collaborateur> findEncadrantCollabs(@PathVariable("id") int id){
	return encadrantService.trouverEncadrantCollabs(id);
}

public IEncadrantService getEncadrantService() {
	return encadrantService;
}
public void setEncadrantService(IEncadrantService encadrantService) {
	this.encadrantService = encadrantService;
}
}

