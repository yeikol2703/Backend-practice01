package cr.una.crudapp.backend.modelo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * Entidad Persona
 *
 */
@Entity
@Table(name = "persona")
public class Persona {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    @Getter
    @Setter
    private long idPersona;
    @Column(name = "nombre")
    @Getter
    @Setter
    private String nombre;
    @Column(name = "numCedula")
    @Getter
    @Setter
    private String numCedula;  
    @OneToMany(mappedBy="persona")
    @Getter
    @Setter
    private List<Casa> casas;

}
