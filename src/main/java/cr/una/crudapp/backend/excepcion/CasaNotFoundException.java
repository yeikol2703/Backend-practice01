/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.una.crudapp.backend.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Casa no ha sido encontrada")
public class CasaNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    /**
     * Construye una nueva excepcion con el mensaje de detalle especificado
     *
     * @param message mensaje se guarda por medio del metodo {@link #getMessage ()}.
     */
    public CasaNotFoundException(String message) {
        super(message);
    }
}
