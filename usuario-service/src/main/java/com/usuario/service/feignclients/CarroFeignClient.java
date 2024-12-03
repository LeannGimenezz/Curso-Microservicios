package com.usuario.service.feignclients;

import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "carro-service",url = "http://localhost:8002")
public interface CarroFeignClient {

    @PostMapping("/carro")
    Carro save(@RequestBody Carro carro);

    @GetMapping("/carro/{usuarioId}")
    List<Carro> getCarro(@PathVariable Integer usuarioId);
}
