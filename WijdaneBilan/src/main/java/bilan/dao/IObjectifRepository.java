package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Objectif;

public interface IObjectifRepository extends JpaRepository<Objectif, Long>{
	
	
	@Modifying
	@Transactional
	@Query("delete Objectif a where a.idObjectif = ?1")
	public int deleteObjectif(int id);
	
	@Modifying
	@Transactional
	@Query("update Objectif a set a.description= :desc where a.idObjectif = :x")
	public int updateAObjectif(@Param("desc")String desc, @Param("x")int id);
	
	@Query("select distinct o from Objectif o,EvaluationObjectif ev, Bap bap where o.idObjectif= ev.objectif.idObjectif and "
			+ "ev.collaborateur.idCollaborateur=bap.collaborateur.idCollaborateur and "
			+ "ev.collaborateur.idCollaborateur like :idC and o.dateObjectif >= all (select b.dateBap from Bap b where "
			+ " b.collaborateur.idCollaborateur like :idC)")
	public List<Objectif> ficheCollab(@Param("idC")int idC);
	
	/*@Query("select distinct o from Objectif o,EvaluationObjectif ev, Bap bap where o.idObjectif= ev.objectif.idObjectif and "
			+ "ev.collaborateur.idCollaborateur=bap.collaborateur.idCollaborateur and "
			+ "ev.collaborateur.idCollaborateur like :idC and bap.collaborateur.idCollaborateur like :idC and "
			+ "o.dateObjectif > max(bap.dateBap)")
	public List<Objectif> ficheCollab(@Param("idC")int idC);*/
	
	//Recuperer les objectifs à evaluer d'un encadrant
	@Query("select ev,o from EvaluationObjectif ev, Objectif o where ev.encadrant.idEncadrant like :idE and "
				+ "ev.objectif.idObjectif= o.idObjectif and ev.resultatObj =0")
		public List<Objectif> encadrantObjectifs(@Param("idE")int idE);
	
	//Recuperer les objectifs déja évalués d'un encadrants
	@Query("select ev,o from EvaluationObjectif ev, Objectif o where ev.encadrant.idEncadrant like :idE and "
					+ "ev.objectif.idObjectif= o.idObjectif and ev.resultatObj <>0")
			public List<Objectif> encadrantObjectifsEvalues(@Param("idE")int idE);

	public List<Objectif> findAll();
	
}

