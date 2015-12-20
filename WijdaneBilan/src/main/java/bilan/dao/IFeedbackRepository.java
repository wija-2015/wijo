package bilan.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Feedback;
//import bilan.entities.Managerrh;
import bilan.entities.Theme;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long>{
	
	//Trouver les feedbacks donnés par un encadrant x sur un collaborateur y
	@Query("select a from Feedback a where a.collaborateur.idCollaborateur like :x and a.encadrant.idEncadrant like :y")
	public Page<Feedback> encadrantFeedbacks(@Param("x")int idC, @Param("y")int idE,Pageable p);
	
	//Trouver les feedbacks de l'année courante d'un collaborateur x
	@Query("select a from Feedback a where a.collaborateur.idCollaborateur like :x and "
			+ "a.dateDebut >= all (select b.dateCourante from Bap b where "
			+ " b.collaborateur.idCollaborateur like :x)")
	public Page<Feedback> adminFeedbacks(@Param("x")int idC,Pageable p);
	
	//Trouver les feedbacks d'un collaborateur sachant l'identifiant de ce collab
	@Query("select a from Feedback a where a.collaborateur.idCollaborateur like :x")
	public Page<Feedback> collabFeedbacks(@Param("x")int idC,Pageable p);
	
	//Trouver un feedback sachant l'identifiant de ce feedback
	@Query("select f from Feedback f where f.idFeedback like :x")
	public Feedback findFeedback(@Param("x")int id);
	
	
}
