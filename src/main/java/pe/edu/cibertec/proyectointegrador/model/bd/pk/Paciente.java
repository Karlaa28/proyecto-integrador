package pe.edu.cibertec.proyectointegrador.model.bd.pk;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpaciente;
    @Column(name = "dnipa")
    private String dnipa;
    @Column(name = "nombrespa")
    private String nombrespa;
    @Column(name = "apellidospa")
    private String apellidospa;
    @Column(name = "apellidosmapa")
    private String apellidosmapa;
    @Column(name = "telefonopa")
    private String telefonopa;
    @Column(name = "fechanacimientopa")
    private Date fechanacimientopa;
    @Column(name = "sexopa")
    private String sexopa;
    @Column(name = "pesopa")
    private String pesopa;
    @Column(name = "alturapa")
    private String alturapa;

    @ManyToOne
    @JoinColumn(name = "sangreid")
    private TipoDeSangre tipodesangre;

    @ManyToOne
    @JoinColumn(name = "sedeid")
    private Sede sede;
}
