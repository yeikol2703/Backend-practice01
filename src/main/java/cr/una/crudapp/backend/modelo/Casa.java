
package cr.una.crudapp.backend.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Entidad Casa
 *
 */

@Entity
@Table(name = "casa")
public class Casa implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "idCasa")
    @Getter
    @Setter
    private long idCasa;
    @Column(name = "fecha")
    @Getter
    @Setter
    private Date fecha;
    @Column(name = "area")
    @Getter
    @Setter
    private double area;
    @Column(name = "color")
    @Getter
    @Setter
    private String color;
    @Column(name = "nueva")
    @Getter
    @Setter
    private boolean nueva;
    
    
    
}
