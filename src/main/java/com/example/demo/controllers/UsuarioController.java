package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ApiResponse;
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
        String numero = usuario.getNumero();
        String password = usuario.getPassword();

        UsuarioModel usuarioExistente = usuarioService.findByNumero(numero);

        if (usuarioExistente == null) {
            ApiResponse response = new ApiResponse("Datos incorrectos.", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Gson().toJson(response));
        }

        if (!usuarioExistente.getPassword().equals(password)) {
            ApiResponse response = new ApiResponse("Datos incorrectos.",
                    HttpStatus.UNAUTHORIZED.value());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Gson().toJson(response));
        }

        ApiResponse response = new ApiResponse("Inicio de sesión exitoso", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(response));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsuarioModel usuario) {
        if (!isValidEmail(usuario.getNumero())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El formato del número no es válido.");
        }

        if (usuarioService.findByNumero(usuario.getNumero()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número ya está en uso.");
        }

        usuarioService.guardarUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito.");
    }

    private boolean isValidEmail(String email) {
        return true;
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            ApiResponse response = new ApiResponse("Usuario eliminado con éxito", HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(response));
        } else {
            ApiResponse response = new ApiResponse("No se pudo eliminar el usuario.", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Gson().toJson(response));
        }
    }
}
