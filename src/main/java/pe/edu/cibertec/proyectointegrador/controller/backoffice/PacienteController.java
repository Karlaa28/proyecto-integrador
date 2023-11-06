package pe.edu.cibertec.proyectointegrador.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Paciente;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoDeSangre;
import pe.edu.cibertec.proyectointegrador.model.request.PacienteRequest;
import pe.edu.cibertec.proyectointegrador.model.response.ResultadoResponse;
import pe.edu.cibertec.proyectointegrador.service.PacienteService;
import pe.edu.cibertec.proyectointegrador.service.TipoDeSangreService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    private  final TipoDeSangreService tipoDeSangreService;
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("listaPacientes",
                            pacienteService.listarPacientes());
        return "backoffice/paciente/frmMantPaciente";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/listars")
    @ResponseBody
    public List<TipoDeSangre> listaTiposdesangre() {
        return tipoDeSangreService.listarTiposdesangre();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarPaciente(
            @RequestBody PacienteRequest pacienteRequest
    ){
        return pacienteService.guardarPaciente(pacienteRequest);
    }
}
