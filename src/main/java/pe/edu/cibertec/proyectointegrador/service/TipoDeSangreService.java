package pe.edu.cibertec.proyectointegrador.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Sede;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoDeSangre;
import pe.edu.cibertec.proyectointegrador.repository.SedeRepository;
import pe.edu.cibertec.proyectointegrador.repository.TipoDeSangreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoDeSangreService {
    private TipoDeSangreRepository tipoDeSangreRepository;

    public List<TipoDeSangre> listarTiposdesangre(){
        return tipoDeSangreRepository.findAll();
    }

}
