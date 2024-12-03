package com.carro.service.controladores;

import com.carro.service.entidades.Carro;
import com.carro.service.servicio.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroService.getAll();
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{carroId}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable Integer carroId){
        Carro carro = carroService.getCarroById(carroId);
        if (carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
        Carro carro1 = carroService.save(carro);
        if (carro1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro1);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarroPorUsuarioId(@PathVariable Integer usuarioId){
        List<Carro> carros = carroService.byUsuarioId(usuarioId);
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
}
