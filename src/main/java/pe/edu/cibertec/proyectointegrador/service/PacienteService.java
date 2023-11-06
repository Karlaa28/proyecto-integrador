package pe.edu.cibertec.proyectointegrador.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Paciente;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.Sede;
import pe.edu.cibertec.proyectointegrador.model.bd.pk.TipoDeSangre;
import pe.edu.cibertec.proyectointegrador.model.request.PacienteRequest;
import pe.edu.cibertec.proyectointegrador.model.response.ResultadoResponse;
import pe.edu.cibertec.proyectointegrador.repository.PacienteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public ResultadoResponse guardarPaciente(PacienteRequest paciente) {
        String mensaje = "Paciente registrado correctamente";
        Boolean respuesta = true;
        try {
            Paciente objPaciente = new Paciente();
            if (paciente.getIdpaciente()>0) {
                objPaciente.setIdpaciente(paciente.getIdpaciente());

            }
            objPaciente.setDnipa(paciente.getDnipa());
            objPaciente.setNombrespa(paciente.getNombrespa());
            objPaciente.setApellidospa(paciente.getApellidospa());
            objPaciente.setApellidosmapa(paciente.getApellidosmapa());
            objPaciente.setTelefonopa(paciente.getTelefonopa());
            objPaciente.setFechanacimientopa(paciente.getFechanacimientopa());
            objPaciente.setSexopa(paciente.getSexopa());
            objPaciente.setPesopa(paciente.getPesopa());
            objPaciente.setAlturapa(paciente.getAlturapa());

            TipoDeSangre tipodesangre = new TipoDeSangre();
            tipodesangre.setIdtipodesangre(paciente.getTipodesangre());
            objPaciente.setTipodesangre(tipodesangre);

            Sede sede = new Sede();
            sede.setIdsede(paciente.getSede());
            objPaciente.setSede(sede);

            pacienteRepository.save(objPaciente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();  // Imprime la pila de llamadas de la excepción
            mensaje = "Paciente no registrado";
            respuesta = false;

        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
