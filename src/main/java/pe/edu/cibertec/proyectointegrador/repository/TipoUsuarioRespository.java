package pe.edu.cibertec.proyectointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoUsuario;

@Repository
public interface TipoUsuarioRespository extends JpaRepository<TipoUsuario, Integer> {
}
