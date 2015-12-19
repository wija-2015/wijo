package bilan.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IBapRepository;
import bilan.entities.Bap;
import bilan.entities.Objectif;

/**
 * @author WIJDANE
 *
 */
@Service
@Transactional
public class IBapServiceImpl implements IBapService{
	
	@Autowired
	private IBapRepository bapRepository;
	
	@Override
	public List<Bap> collabBaps(int idC) {
		// TODO Auto-generated method stub
		return bapRepository.collabBaps(idC);
	}
	@Override
	public List<Objectif> ficheObjectifs(int idC, String dateObjectif) {
		return bapRepository.ficheObjectifs(idC, dateObjectif);
	}

	public IBapRepository getBapRepository() {
		return bapRepository;
	}

	public void setBapRepository(IBapRepository bapRepository) {
		this.bapRepository = bapRepository;
	}

	
	
}
