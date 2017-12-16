package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisrepweb.domain.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Serializable>{
	
}
