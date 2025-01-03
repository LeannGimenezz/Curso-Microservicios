package com.usuario.service.feignclients;

import com.usuario.service.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "moto-service",url = "http://localhost:8003")
public interface MotoFeignClient {

    @PostMapping("/moto")
    Moto save(@RequestBody Moto moto);

    @GetMapping("/motos/{usuarioId}")
    List<Moto> getMotos(@PathVariable Integer usuarioId);
}
