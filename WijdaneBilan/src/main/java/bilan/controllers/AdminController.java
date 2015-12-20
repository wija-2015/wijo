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
import bilan.entities.Managerrh;
import bilan.entities.Admin;
import bilan.service.IAdminService;

@RestController
@RequestMapping("admins")
public class AdminController {

@Autowired
private IAdminService adminService;

//Pour que l'admin puisse s'authentifier
@RequestMapping(value="signin", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public long signinAdmin(@RequestBody Admin a, HttpServletResponse response){
	 if(adminService.verify(a.getMailUser(), a.getMatriculeUser())==0) {
		 return 0 ;
	 }
	 else 
		 return adminService.getIdAdmin(a.getMailUser(), a.getMatriculeUser());
}
//Avoir la liste des managers RH
@RequestMapping(value="/managers", method = RequestMethod.GET)
public List<Managerrh> findAllManagers(){
	return adminService.trouverManagers();
}

public IAdminService getAdminService() {
	return adminService;
}
public void setAdminService(IAdminService adminService) {
	this.adminService = adminService;
}

}

