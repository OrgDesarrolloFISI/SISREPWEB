package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisrepweb.domain.CursoPeriodo;
import pe.edu.sistemas.sisrepweb.domain.Grupo;

@Repository
@Transactional
public interface CursoPeriodoRepository extends JpaRepository<CursoPeriodo, Serializable>{

}
