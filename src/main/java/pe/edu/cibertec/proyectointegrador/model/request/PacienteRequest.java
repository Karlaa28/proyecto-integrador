package pe.edu.cibertec.proyectointegrador.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class PacienteRequest {
    private Integer idpaciente;
    private String dnipa;
    private String nombrespa;
    private String apellidospa;
    private String apellidosmapa;
    private String telefonopa;
    private Date fechanacimientopa;
    private String sexopa;
    private String pesopa;
    private String alturapa;
    private Integer tipodesangre;
    private Integer sede;
}
