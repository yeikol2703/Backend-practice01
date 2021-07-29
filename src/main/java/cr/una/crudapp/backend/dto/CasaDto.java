/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.una.crudapp.backend.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Data;


/**
 *
 * DTO para la entidad Casa
 *
 */
@Data
public class CasaDto {

    private long idCasa;
    @NotBlank(message = "No ha completado este label")
    private Date fecha;
    @NotBlank(message = "No ha completado este label")
    private double area;
    @NotBlank(message = "No ha completado este label")
    private String color;
    @NotBlank(message = "No ha completado este label")
    private boolean nueva;
}
