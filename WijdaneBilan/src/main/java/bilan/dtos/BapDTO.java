package bilan.dtos;

import java.util.Date;

public class BapDTO {
	
	private int idBap;
	private Date dateBap;
	private int mode;
	private float noteFinaleBap;
	private String poste;
	private int idCollaborateur;
	
	public int getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(int idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public int getIdBap() {
		return idBap;
	}
	public void setIdBap(int idBap) {
		this.idBap = idBap;
	}
	public Date getDateBap() {
		return dateBap;
	}
	public void setDateBap(Date dateBap) {
		this.dateBap = dateBap;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public float getNoteFinaleBap() {
		return noteFinaleBap;
	}
	public void setNoteFinaleBap(float noteFinaleBap) {
		this.noteFinaleBap = noteFinaleBap;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	

}
