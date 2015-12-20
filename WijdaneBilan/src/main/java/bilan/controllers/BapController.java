package bilan.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.IAdminRepository;
import bilan.dtos.BapDTO;
import bilan.dtos.CollaborateurDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;
import bilan.entities.Bap;
import bilan.entities.Objectif;
import bilan.service.IBapService;

@RestController
@RequestMapping("baps")
public class BapController {

@Autowired
private IBapService bapService;

//trouver les baps d'un collaborateur
@RequestMapping(value="/collabBaps/{idC}", method = RequestMethod.GET)
public List<Bap> collabBaps(@PathVariable("idC") int idC){
	return bapService.collabBaps(idC);
}

//Trouver la fiche d'objectifs du Bap de l'année y et du collaborateur x
@RequestMapping(value="/ficheObjectifs/{idC}/{date}", method = RequestMethod.GET)
public List<Objectif> ficheObjectifs(@PathVariable("idC") int idC, @PathVariable("date") String dateObjectif){
	return bapService.ficheObjectifs(idC, dateObjectif);
}
//Ajouter un Bap pour un collaborateur
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Bap saveBap(@RequestBody BapDTO bap,HttpServletResponse response){
	return bapService.ajouterBap(bap);
}
}
