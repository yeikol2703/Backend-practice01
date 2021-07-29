
package cr.una.crudapp.backend.webservice;

import cr.una.crudapp.backend.comun.Constants;
import cr.una.crudapp.backend.excepcion.CasaNotFoundException;
import cr.una.crudapp.backend.servicio.ICasaServicio;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import cr.una.crudapp.backend.dto.CasaDto;
import cr.una.crudapp.backend.modelo.Casa;

/**
 * WebService Controller para la casa
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "casas")
public class CasaController {

    @Autowired
    private ICasaServicio service;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("{id}")
    @ResponseBody
    public CasaDto encuentraPorId(@PathVariable Long id) throws CasaNotFoundException {
        Casa casa = service.encuentraPorId(id);
        return convierteADto(casa);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CasaDto salva(@Valid @RequestBody CasaDto casaDto) {
        Casa casa = convierteAEntidad(casaDto);
        return convierteADto(service.crear(casa));
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CasaDto actualiza(@Valid @RequestBody CasaDto casaDto) {
        Casa casa = convierteAEntidad(casaDto);
        return convierteADto(service.actualizar(casa));
    }


    @DeleteMapping("{id}")
    @ResponseBody
    public void eliminaPorId(@PathVariable Long id) {
        try {
            service.eliminarPorId(id);
        } catch (CasaNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Casa no encontrada", ex);
        }
    }

    private CasaDto convierteADto(Casa casa) {
        CasaDto casaDto = modelMapper.map(casa, CasaDto.class);
        return casaDto;
    }

  
    private Casa convierteAEntidad(CasaDto casaDto) {
        Casa casa = modelMapper.map(casaDto, Casa.class);
        return casa;
    }
}
