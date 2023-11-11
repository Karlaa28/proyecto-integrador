package pe.edu.cibertec.proyectointegrador.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoDocumento;
import pe.edu.cibertec.proyectointegrador.repository.TipoDocumentoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoDocumentoService {

        private TipoDocumentoRepository tipoDocumentoRepository;

        public List<TipoDocumento> listarTipodocumento(){
            return tipoDocumentoRepository.findAll();
        }

    }
