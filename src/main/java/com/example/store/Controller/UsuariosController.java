package com.example.store.Controller;

import com.example.store.Models.usuarios.DadosCadastroUsuarios;
import com.example.store.Models.usuarios.DadosDetalhamentoUsuarios;
import com.example.store.Models.usuarios.DadosListagemUsuarios;
import com.example.store.Models.usuarios.Usuarios;
import com.example.store.Repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuarios dadosCadastroUsuarios, UriComponentsBuilder uriComponentsBuilder) {
        var usuarios = new Usuarios(dadosCadastroUsuarios);

        if (usuarioRepository.existsByCpf(usuarios.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF JÁ EXISTE");
        }

        usuarioRepository.save(usuarios);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuarios.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuarios(usuarios));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarios>> findAll(@PageableDefault(value = 5) Pageable pageable) {
        var page = usuarioRepository.findAll(pageable).map(DadosListagemUsuarios::new);
        return ResponseEntity.ok(page);
    }
}
