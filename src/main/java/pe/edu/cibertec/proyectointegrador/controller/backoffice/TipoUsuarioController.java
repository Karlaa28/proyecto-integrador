package pe.edu.cibertec.proyectointegrador.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoUsuario;
import pe.edu.cibertec.proyectointegrador.service.TipoUsuarioService;

import java.util.List;
@AllArgsConstructor
@Controller
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

        private TipoUsuarioService tipoUsuarioService;

        @GetMapping("/listar")
        @ResponseBody
        public List<TipoUsuario> listarTipousuario(){
            return tipoUsuarioService.listarTipousuario();
        }
}
