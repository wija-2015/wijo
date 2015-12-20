package bilan.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectifDTO {
	
	private int idObjectif;
	private String description;
	private int idCategorie;
	private int idCollaborateur;
	private int idManager;
	private boolean autoriser;
	private Date dateObjectif;
	
	public boolean getAutoriser() {
		return autoriser;
	}
	public void setAutoriser(boolean autoriser) {
		this.autoriser = autoriser;
	}
	public int getIdManager() {
		return idManager;
	}
	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}
	private List<EvaluationObjectifDTO> evaluations= new ArrayList<EvaluationObjectifDTO>() ;
	
	public List<EvaluationObjectifDTO> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(List<EvaluationObjectifDTO> evaluations) {
		this.evaluations = evaluations;
	}
	public int getIdObjectif() {
		return idObjectif;
	}
	public void setIdObjectif(int idObjectif) {
		this.idObjectif = idObjectif;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public int getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(int idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public Date getDateObjectif() {
		return dateObjectif;
	}
	public void setDateObjectif(Date dateObjectif) {
		this.dateObjectif = dateObjectif;
	}
	
	
}
