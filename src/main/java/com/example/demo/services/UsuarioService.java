package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> getUserById(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel createUser(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> updateUser(Long id, UsuarioModel updatedUser) {
        return usuarioRepository.findById(id)
                .map((UsuarioModel existingUser) -> {
                    existingUser.setDni(updatedUser.getDni());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPassword(updatedUser.getPassword());
                    UsuarioModel savedUser = usuarioRepository.save(existingUser);
                    return savedUser;
                });
    }

    public void deleteUser(Long id) {
        usuarioRepository.findById(id).ifPresent(usuarioRepository::delete);
    }
}
