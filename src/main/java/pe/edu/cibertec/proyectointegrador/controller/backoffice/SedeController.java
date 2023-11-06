package pe.edu.cibertec.proyectointegrador.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Sede;
import pe.edu.cibertec.proyectointegrador.service.SedeService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/sede")
public class SedeController {

    private SedeService sedeService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Sede> listarSedes(){
        return sedeService.listarSedes();
    }
}
