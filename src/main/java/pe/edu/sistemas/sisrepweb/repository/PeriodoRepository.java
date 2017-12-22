package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisrepweb.domain.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Serializable>{
	
	@Query("SELECT p FROM Periodo as p ORDER BY p.idperiodo DESC")
	List<Periodo> listarPeriodosInverso();
	
	public abstract Periodo findByperiodoNombre(String nombre);
}
