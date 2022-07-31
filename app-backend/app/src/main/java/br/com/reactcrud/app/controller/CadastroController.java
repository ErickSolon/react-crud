package br.com.reactcrud.app.controller;

import br.com.reactcrud.app.model.dto.UsuarioDTO;
import br.com.reactcrud.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@RequiredArgsConstructor
public class CadastroController {
    private final UsuarioService usuarioService;

    @GetMapping(path = "/")
    public ResponseEntity<List<UsuarioDTO>> getUsuario() {
        List<UsuarioDTO> usuarioDTOList = usuarioService.findAll();
        return ResponseEntity.ok(usuarioDTOList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findUsuarioById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuarioById(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.updateUsuarioById(id, usuarioDTO));
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createUsuarioFisica(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.saveUsuario(usuarioDTO));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuarioById(@PathVariable Long id) {
        usuarioService.deleteUsuarioById(id);
    }
}
