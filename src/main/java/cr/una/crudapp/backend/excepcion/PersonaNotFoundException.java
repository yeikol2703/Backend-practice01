package cr.una.crudapp.backend.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Persona no ha sido encontrada")
public class PersonaNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    /**
     * Construye una nueva excepcion con el mensaje de detalle especificado
     *
     * @param message mensaje se guarda por medio del metodo {@link #getMessage ()}.
     */
    public PersonaNotFoundException(String message) {
        super(message);
    }
}
