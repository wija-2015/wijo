package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Profil;

public interface IProfilRepository extends JpaRepository<Profil, Long>{
	
	
	@Query("select a from Profil a where a.idProfil like :x")
	public Profil findProfil(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Profil a where a.idProfil = ?1")
	public int deleteProfil(int id);
	
	@Modifying
	@Transactional
	@Query("update Profil a set a.nomProfil= :nom where a.idProfil = :x")
	public int updateProfil(@Param("nom")String nom,@Param("x")int id);
	
	@Query("select m from Profil m")
	public List<Profil> findAllProfils();
	
}
