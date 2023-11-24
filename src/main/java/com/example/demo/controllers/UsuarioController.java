package com.example.demo.controllers;

import java.util.Optional;

import com.example.demo.models.ApiResponse;
import com.example.demo.models.UsuarioDTO;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> loginUser(@RequestBody UsuarioModel usuario) {
        if (!isValidEmail(usuario.getNumero())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Gson().toJson(
                            new ApiResponse("El formato del número no es válido.", HttpStatus.BAD_REQUEST.value())));
        }

        return usuarioService.loginUsuario(usuario);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsuarioModel usuario) {
        if (!isValidEmail(usuario.getNumero())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Gson().toJson(new ApiResponse("El formato del número no es válido.", HttpStatus.BAD_REQUEST.value())));
        }

        return usuarioService.registerUsuario(usuario);
    }

    private boolean isValidEmail(String email) {
        String dni = extractDNI(email);
        return usuarioService.isValidDNI(dni);
    }

    private String extractDNI(String email) {
        return email.substring(0, 8);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<UsuarioModel> usuarioOptional = this.usuarioService.obtenerPorId(id);
        return usuarioOptional.map(usuario -> ResponseEntity.ok(usuarioService.convertirAUsuarioDTO(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean eliminacionExitosa = this.usuarioService.eliminarUsuario(id);
        ApiResponse response = eliminacionExitosa
                ? new ApiResponse("Usuario eliminado con éxito", HttpStatus.OK.value())
                : new ApiResponse("No se pudo eliminar el usuario.", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(response.getStatus()).body(new Gson().toJson(response));
    }
}
