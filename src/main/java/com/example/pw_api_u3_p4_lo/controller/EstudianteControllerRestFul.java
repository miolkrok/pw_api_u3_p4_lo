package com.example.pw_api_u3_p4_lo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;
import com.example.pw_api_u3_p4_lo.service.IEstudianteService;
import com.example.pw_api_u3_p4_lo.service.IMateriaService;
import com.example.pw_api_u3_p4_lo.service.to.EstudianteTO;
import com.example.pw_api_u3_p4_lo.service.to.MateriaTO;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;
    @Autowired
    private IMateriaService materiaService;

    // GET
    @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Estudiante consultarPorCedula(@PathVariable String cedula) {

        return this.estudianteService.consultarPorCedula(cedula);
        // return
        // ResponseEntity.status(227).body(this.estudianteService.consultarPorCedula(cedula));
    }

    // @GetMapping(path = "/{cedula}")
    // public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String
    // cedula) {
    // // return this.estudianteService.consultarPorCedula(cedula);
    // return
    // ResponseEntity.status(227).body(this.estudianteService.consultarPorCedula(cedula));
    // }

    // @GetMapping(path = "/status/{cedula}")
    // public ResponseEntity<Estudiante> consultarPorCedulaStatus(@PathVariable
    // String cedula) {
    // // return this.estudianteService.consultarPorCedula(cedula);
    // return
    // ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.consultarPorCedula(cedula));
    // }

    // @GetMapping()
    // public List<Estudiante> consultarTodos() {

    // return this.estudianteService.buscarTodos();
    // }

    // GETMAPPING SIN HATEOAS
    @GetMapping
    public ResponseEntity<List<Estudiante>> consultarTodosProv(@RequestParam String provincia) {

        // return this.estudianteService.buscarTodosProv(provincia);
        List<Estudiante> lista = this.estudianteService.buscarTodosProv(provincia);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("detalleMensaje", "Ciudadanos consultados exitosamente");
        cabeceras.add("valorAPI", "Incalculable");
        return new ResponseEntity<>(lista, cabeceras, 228);
    }

    @GetMapping(path = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstudianteTO>> consultarTodosHateoas() {
        List<EstudianteTO> lista = this.estudianteService.buscarTodosTO();

        for (EstudianteTO e : lista) {
            Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarPorEstudiante(e.getCedula()))
                    .withRel("materias");
            e.add(myLink);
        }
        return new ResponseEntity<>(lista, null, 200);
    }

    @GetMapping(path = "/{cedula}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula){
        List<MateriaTO> lista = this.materiaService.buscarPorCedulaEstudiante(cedula);
                for (MateriaTO e : lista) {
            Link myLink = linkTo(methodOn(MateriaControllerRestFul.class).consultarPorId(e.getId())).withRel("");
            e.add(myLink);
        }
        return new ResponseEntity<>(lista, null, 200);
    }

    // @PostMapping(consumes = "application/xml")
    // public void guardar(@RequestBody Estudiante estudiante) {
    // this.estudianteService.guardar(estudiante);
    // }

    @PostMapping(path = "/{cedula}", produces = "application/xml", consumes = "application/xml")
    public Estudiante guardar(@RequestBody Estudiante estudiante, @PathVariable String cedula) {
        estudiante.setCedula(cedula);
        this.estudianteService.guardar(estudiante);
        return this.estudianteService.consultarPorCedula(estudiante.getCedula());

    }

    @PutMapping(path = "/{identificador}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        String cedula = "1718496945";
        Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
        estu1.setCedula(estudiante.getCedula());
        this.estudianteService.actualizarParcial(estu1);
    }

    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id) {
        this.estudianteService.eliminar(id);
    }

}
