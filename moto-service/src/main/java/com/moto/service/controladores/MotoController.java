package com.moto.service.controladores;

import com.moto.service.entidades.Moto;
import com.moto.service.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos(){
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{carroId}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable Integer carroId){
        Moto moto = motoService.getMotoById(carroId);
        if (moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
        Moto moto1 = motoService.save(moto);
        if (moto1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto1);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotoPorUsuarioId(@PathVariable Integer usuarioId){
        List<Moto> motos = motoService.byUsuarioId(usuarioId);
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
