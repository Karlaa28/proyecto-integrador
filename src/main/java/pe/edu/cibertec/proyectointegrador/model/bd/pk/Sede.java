package pe.edu.cibertec.proyectointegrador.model.bd.pk;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "sede")
public class Sede {
    @Id
    private Integer idsede;

    @Column(name = "nombresede")
    private String nombresede;
}
