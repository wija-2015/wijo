package bilan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Bap;
import bilan.entities.Feedback;
import bilan.entities.Objectif;

public interface IBapRepository extends JpaRepository<Bap, Long>{
	
	//Trouver tous les bap d'un collaborateur
	@Query("select b from Bap b where b.collaborateur.idCollaborateur like :x")
	public List<Bap> collabBaps(@Param("x")int idC);
	
	//Trouver la fiche d'objectifs du Bap de l'année y et du collaborateur x
	@Query("select o from Objectif o, EvaluationObjectif ev where ev.collaborateur.idCollaborateur like :x and "
			+ "o.idObjectif=ev.objectif.idObjectif and to_char(o.dateObjectif,'YYYY/MM') =:y")
	public List<Objectif> ficheObjectifs(@Param("x")int idC, @Param("y")String dateObjectif);
	
	//Trouver les feedbacks du Bap de l'annee y et du collaborateur x
	@Query("select f from Feedback f, Bap b where f.collaborateur.idCollaborateur like :x and b.collaborateur.idCollaborateur="
			+ "f.collaborateur.idCollaborateur and b.dateBap like :y")
	public List<Feedback> collabFeedbacks(@Param("x")int idC, @Param("y")Date dateBap);
	
	
}
