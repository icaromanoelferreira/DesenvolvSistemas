package com.example.sistema.controller;

import com.example.sistema.model.UsuarioModel;
import com.example.sistema.repository.UsuarioRepository;
import com.example.sistema.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping  ("/usuarios")
public class UsuarioController{
@Autowired
private UsuarioService usuarioService;

@GetMapping
public List<UsuarioModel> listar (){
    return usuarioService.listarTodos();
}

@PostMapping
public ResponseEntity<UsuarioModel> salvar (@RequestBody UsuarioModel usuario) {
    // ENVIAR DADOS DO FRONT-END PARA USUARIOSERVICE VERIFICAR SE USUARIO JÁ EXISTE
    usuarioService.salvar(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
}

}


