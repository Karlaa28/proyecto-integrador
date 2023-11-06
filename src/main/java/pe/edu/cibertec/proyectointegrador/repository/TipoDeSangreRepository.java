package pe.edu.cibertec.proyectointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Sede;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoDeSangre;

@Repository
public interface TipoDeSangreRepository extends JpaRepository<TipoDeSangre, Integer> {
}
