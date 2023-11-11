package pe.edu.cibertec.proyectointegrador.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoDocumento;
import pe.edu.cibertec.proyectointegrador.service.TipoDocumentoService;

import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {

        private TipoDocumentoService tipoDocumentoService;

        @GetMapping("/listar")
        @ResponseBody
        public List<TipoDocumento> listarTipodocumento(){
            return tipoDocumentoService.listarTipodocumento();
        }
}
