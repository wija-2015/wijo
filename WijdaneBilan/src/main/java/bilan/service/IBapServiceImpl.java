package bilan.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IBapRepository;
import bilan.dao.ICollabRepository;
import bilan.dtos.BapDTO;
import bilan.entities.Bap;
import bilan.entities.Collaborateur;
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
	@Autowired
	private ICollabRepository collabRepository;
	
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

	@Override
	public Bap ajouterBap(BapDTO dto) {
		Bap b = new Bap();
		Calendar c = Calendar.getInstance() ;
		Collaborateur col=new Collaborateur();
		col=collabRepository.findCollab(dto.getIdCollaborateur());
		c.setTime(dto.getDateBap());
		c.add(Calendar.YEAR, 1);
		b.setDateCourante(c.getTime());
		b.setCollaborateur(col);
		b.setDateBap(dto.getDateBap());
		b.setNoteFinaleBap(dto.getNoteFinaleBap());
		b.setPoste(dto.getPoste());
		return bapRepository.save(b);
	}

	
	
}
