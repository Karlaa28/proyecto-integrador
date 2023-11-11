package pe.edu.cibertec.proyectointegrador.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoUsuario;
import pe.edu.cibertec.proyectointegrador.repository.TipoUsuarioRespository;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoUsuarioService {
    private TipoUsuarioRespository tipoUsuarioRespository;

    public List<TipoUsuario> listarTipousuario(){
        return tipoUsuarioRespository.findAll();
    }
}
