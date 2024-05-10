package tn.mbhc.tudev.javaee.demo.presentation.controller;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import tn.mbhc.tudev.javaee.demo.model.ApplicationEntity;
import tn.mbhc.tudev.javaee.demo.persistence.ApplicationDao;
import tn.mbhc.tudev.javaee.demo.presentation.viewmodel.DemoDataViewModel;

@Named
public class DemoController {

	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
	
	@Inject
	private ApplicationDao appDao;
	
	private DemoDataViewModel appDataViewModel;
	
	@PostConstruct
	public void init() {
		// load test data
		ApplicationEntity applicationEntity = appDao.last();
		
		// map to the view model
		appDataViewModel = new DemoDataViewModel();
		appDataViewModel.setId(applicationEntity.getId());
		appDataViewModel.setName(applicationEntity.getName());
		appDataViewModel.setDescription(applicationEntity.getDescription());
		appDataViewModel.setCreationDate(DTF.format(applicationEntity.getCreationDate()));
	}
	
	public String saveNew() {
		ApplicationEntity applicationEntity = new ApplicationEntity();
		applicationEntity.setName("Application_" + UUID.randomUUID());
		applicationEntity.setDescription("Saved data from the save action");
		appDao.save(applicationEntity);
		reloadModel();
		return "";
	}
	
	private void reloadModel() {
		ApplicationEntity applicationEntity = appDao.last();
		appDataViewModel = new DemoDataViewModel();
		appDataViewModel.setId(applicationEntity.getId());
		appDataViewModel.setName(applicationEntity.getName());
		appDataViewModel.setDescription(applicationEntity.getDescription());
		appDataViewModel.setCreationDate(DTF.format(applicationEntity.getCreationDate()));
	}
	
	public DemoDataViewModel getAppDataViewModel() {
		return appDataViewModel;
	}
	public void setAppDataViewModel(DemoDataViewModel appDataViewModel) {
		this.appDataViewModel = appDataViewModel;
	}
	
}
