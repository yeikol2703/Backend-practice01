package cr.una.crudapp.backend.dto;

import java.util.List;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import cr.una.crudapp.backend.modelo.Casa;


/**
 *
 * DTO para la entidad Persona
 *
 */


@Data
public class PersonaDto {
    private Long idPersona;
    @NotBlank(message = "No ha completado este label")
    private String nombre;
    @NotBlank(message = "No ha completado este label")
    private String numCedula;
    @NotBlank(message = "No ha completado este label")
    private List<Casa> Casas;
}
