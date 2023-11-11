package pe.edu.cibertec.proyectointegrador.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class PacienteRequest {
    private Integer idpaciente;
    private String dni;
    private String nombres;
    private String apellidospa;
    private String apellidosma;
    private String telefono;
    private String fechanacimiento;
    private String sexo;
    private String peso;
    private String altura;
    private String correo;
    private String contrasena;
    private Integer tipodocumento;
    private Integer tipodesangre;
    private Integer sede;
    private Integer tipousuario;
}
