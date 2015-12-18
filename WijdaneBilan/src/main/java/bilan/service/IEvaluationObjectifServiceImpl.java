package bilan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IEvaluationObjectifRepository;
import bilan.dtos.EvaluationObjectifDTO;
import bilan.entities.EvaluationObjectif;


@Service
@Transactional
public class IEvaluationObjectifServiceImpl implements IEvaluationObjectifService{
	
	@Autowired
	private IEvaluationObjectifRepository evaluationObjectifRepository;

	@Override
	public EvaluationObjectif trouverEvaluationObjectif(int idC, int idE,int idO) {
		// TODO Auto-generated method stub
		return evaluationObjectifRepository.findEvaluationObjectif(idC, idE, idO);
	}

	public IEvaluationObjectifRepository getEvaluationObjectifRepository() {
		return evaluationObjectifRepository;
	}

	public void setEvaluationObjectifRepository(
			IEvaluationObjectifRepository evaluationObjectifRepository) {
		this.evaluationObjectifRepository = evaluationObjectifRepository;
	}

	@Override
	public EvaluationObjectif ajouterEvaluationObjectif(EvaluationObjectif eval) {
		return evaluationObjectifRepository.save(eval);
	}

	@Override
	public int evaluerObjectif(EvaluationObjectifDTO ev, int idEval) {
		EvaluationObjectif eval=new EvaluationObjectif();
		eval=evaluationObjectifRepository.findEvaluation(idEval);
		eval.setResultatObj(ev.getResultatObj());
		return evaluationObjectifRepository.evaluerObjectif(eval.getResultatObj(), idEval);
	}
	


}
