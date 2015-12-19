package bilan.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import bilan.entities.Admin;
import bilan.entities.Bap;
import bilan.entities.Managerrh;
import bilan.entities.Objectif;

public interface IBapService {
	
	
	public List<Bap> collabBaps(int idC);
	
	public List<Objectif> ficheObjectifs(int idC, String dateObjectif);
	
}
