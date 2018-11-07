package de.studiapp.pms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.studiapp.pms.model.Administration;

@Repository
public interface AdministrationsRepository extends CrudRepository<Administration, Long> {
	
	Administration findByFach(String fach);

}
