package pe.edu.cibertec.proyectointegrador.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Sede;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoDeSangre;
import pe.edu.cibertec.proyectointegrador.service.SedeService;
import pe.edu.cibertec.proyectointegrador.service.TipoDeSangreService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/tipodesangre")
public class TipoDeSangreController {

    private TipoDeSangreService tipoDeSangreService;

    @GetMapping("/listar")
    @ResponseBody
    public List<TipoDeSangre> listarTipodesangre(){
        return tipoDeSangreService.listarTiposdesangre();
    }
}
