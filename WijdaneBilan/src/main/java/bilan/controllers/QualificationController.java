package bilan.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.IAdminRepository;
import bilan.dtos.FeedbackDTO;
import bilan.dtos.QualificationDTO;
import bilan.entities.Feedback;
import bilan.entities.Managerrh;
import bilan.entities.Qualification;
import bilan.service.IBapService;
import bilan.service.IQualificationService;

@RestController
@RequestMapping("qualifications")
public class QualificationController {

@Autowired
private IQualificationService qualificationService;

//Trouver toutes les qualifications des objectifs 
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Qualification> getQualifications(){
return qualificationService.toutsQualifications();
}

public IQualificationService getQualificationService() {
	return qualificationService;
}
public void setQualificationService(IQualificationService qualificationService) {
	this.qualificationService = qualificationService;
}



}
