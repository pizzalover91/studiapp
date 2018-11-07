package de.studiapp.pms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.studiapp.pms.model.Vorlesungsverschiebung;

@Repository
public interface VorlesungsverschiebungRepository extends CrudRepository<Vorlesungsverschiebung, Long> {
	


}
