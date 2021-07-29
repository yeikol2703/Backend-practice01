package cr.una.crudapp.backend.webservice;

import cr.una.crudapp.backend.comun.Constants;
import cr.una.crudapp.backend.dto.PersonaDto;
import cr.una.crudapp.backend.excepcion.PersonaNotFoundException;
import cr.una.crudapp.backend.modelo.Persona;
import cr.una.crudapp.backend.servicio.IPersonaServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;

/**
 * WebService Controller para la persona
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "personas")
public class PersonaController {

    @Autowired
    private IPersonaServicio service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     *
     * Encuentra la persona por su id
     * Endpoint: /api/v1/personas/1
     * @return Si la persona fue encontrada
     * @throws PersonaNotFoundException Si la persona no fue encontrada, que tire la excepcion
     */
    @GetMapping("{id}")
    @ResponseBody
    public PersonaDto encuentraPorId(@PathVariable Long id) throws PersonaNotFoundException {
        Persona persona = service.encuentraPorId(id);
        return convierteADto(persona);
    }

    /**
     * Salva a la nueva Persona
     * @param personaDto la persona salvada
     * @return la entidad convertida a dto en la BD insertada correctamente
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PersonaDto salva(@Valid @RequestBody PersonaDto personaDto) {
        Persona persona = convierteAEntidad(personaDto);
        return convierteADto(service.crear(persona));
    }

    /**
     * Actualiza una persona existente en la base de datos
     * @param personaDto the priority saved
     * @return the priority updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PersonaDto actualiza(@Valid @RequestBody PersonaDto personaDto) {
        Persona persona = convierteAEntidad(personaDto);
        return convierteADto(service.actualizar(persona));
    }

    /**
     * Elimina persona por el id
     * @param id el id de la entidad que va a ser eliminada
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void eliminaPorId(@PathVariable Long id) {
        try {
            service.eliminarPorId(id);
        } catch (PersonaNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Persona no encontrada", ex);
        }
    }
    /**
     * Convierte la entidad a DTO
     * @param persona entidad Persona
     * @return el DTO
     */
    private PersonaDto convierteADto(Persona persona) {
        PersonaDto personaDto = modelMapper.map(persona, PersonaDto.class);
        return personaDto;
    }

    /**
     * Convierte de DTO  a entidad
     * @param personaDto el DTO
     * @return la entidad
     */
    private Persona convierteAEntidad(PersonaDto personaDto) {
        Persona persona = modelMapper.map(personaDto, Persona.class);
        return persona;
    }
}
