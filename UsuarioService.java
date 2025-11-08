package com.example.sistema.service;

import com.example.sistema.model.UsuarioModel;
import com.example.sistema.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<UsuarioModel> listarTodos (){
        return usuarioRepository.findAll();
    }
    public UsuarioModel salvar (UsuarioModel usuario) {
        if (usuarioRepository.findByEmail (usuario.getEmail()).isPresent()) {
            throw new  IllegalArgumentException("Usuário já tem cadastro.");        }
        return usuarioRepository.save(usuario);
    }
    }
