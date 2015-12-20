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
import bilan.entities.Projet;
import bilan.entities.Theme;
import bilan.service.IBapService;
import bilan.service.IThemeService;

@RestController
@RequestMapping("themes")
public class ThemeController {

@Autowired
private IThemeService themeService;
//Trouver tous les themes
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Theme> getBaps(){
return themeService.toutsThemes();
}
//Ajouter un nouveau theme
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Theme saveTheme(@RequestBody Theme t, HttpServletResponse response){
return themeService.ajouterTheme(t);
}
//Trouver le theme d'id x
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Theme findAdmin(@PathVariable("id") int id){
	return themeService.trouverTheme(id);
}

public IThemeService getThemeService() {
	return themeService;
}
public void setThemeService(IThemeService themeService) {
	this.themeService = themeService;
}

}
