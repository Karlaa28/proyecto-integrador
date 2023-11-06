package pe.edu.cibertec.proyectointegrador.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Sede;
import pe.edu.cibertec.proyectointegrador.repository.SedeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class SedeService {
    private SedeRepository sedeRepository;

    public List<Sede> listarSedes(){
        return sedeRepository.findAll();
    }

}
