package de.studiapp.pms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.studiapp.pms.repository.AdministrationsRepository;
import de.studiapp.pms.model.*;

@Service
@Transactional
public class AdministrationsService {
	
	@Autowired
	private AdministrationsRepository administrationsRepository;
	
	
	public Iterable<Administration> admin(){
		return ((AdministrationsService) administrationsRepository).admin();
	}

}
