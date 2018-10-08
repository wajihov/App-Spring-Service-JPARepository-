package org.sid.dao;

import org.sid.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Client, Long> {

	@Query("select c from Client c where c.nom || c.prenom like :x")
	public Page<Client> chercherClient(@Param("x") String mc, Pageable pageable);

}
