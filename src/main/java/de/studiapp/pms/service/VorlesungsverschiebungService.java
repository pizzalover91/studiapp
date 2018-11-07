package de.studiapp.pms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import de.studiapp.pms.repository.VorlesungsverschiebungRepository;
import de.studiapp.pms.model.*;


@Service
public class VorlesungsverschiebungService {
	
	@Autowired
	private VorlesungsverschiebungRepository vorlesungsverschiebungsRepository;
	
	
	public List<Vorlesungsverschiebung> listAll(){
		List<Vorlesungsverschiebung> vorlesungsverschiebungen =  new ArrayList<>();
			vorlesungsverschiebungsRepository.findAll().forEach(vorlesungsverschiebungen::add);
		return vorlesungsverschiebungen;
		
	}

}
