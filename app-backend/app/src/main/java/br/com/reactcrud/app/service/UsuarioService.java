package br.com.reactcrud.app.service;

import br.com.reactcrud.app.exception.UserNotFoundException;
import br.com.reactcrud.app.model.Usuario;
import br.com.reactcrud.app.model.dto.UsuarioDTO;
import br.com.reactcrud.app.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(Usuario::toDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public UsuarioDTO findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(UserNotFoundException::new).toDTO();
    }

    public UsuarioDTO updateUsuarioById(Long id, UsuarioDTO usuarioDTO) {
        findUsuarioById(id);
        usuarioDTO.id = id;
        return usuarioRepository.save(usuarioDTO.toEntity()).toDTO();
    }

    public void deleteUsuarioById(Long id) {
        findUsuarioById(id);
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        return usuarioRepository.save(usuarioDTO.toEntity()).toDTO();
    }
}
