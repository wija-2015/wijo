package bilan.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import bilan.dtos.BapDTO;
import bilan.entities.Admin;
import bilan.entities.Bap;
import bilan.entities.Categorie;
import bilan.entities.Managerrh;
import bilan.entities.Objectif;

public interface IBapService {
	
	
	public List<Bap> collabBaps(int idC);
	
	public List<Objectif> ficheObjectifs(int idC, String dateObjectif);
	
	public Bap ajouterBap(BapDTO dto);
	
}
