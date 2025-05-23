package com.edutech.cursoapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "userapi")
public interface UsuarioClient {

    @GetMapping("/api/userapi/{id}")
    Map<String, Object> getUsuario(@PathVariable Long id);
}