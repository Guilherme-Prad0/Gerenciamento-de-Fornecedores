package com.zera.fornecedores.controllers;

import com.zera.fornecedores.models.FornecedorModel;
import com.zera.fornecedores.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> criarCliente(@RequestBody FornecedorModel fornecedorModel){
        FornecedorModel request = fornecedorService.criarFornecedor(fornecedorModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fornecedorModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> request = fornecedorService.buscarTodosFornecedores();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping
    public ResponseEntity<?> deletar (@PathVariable Long id){
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public FornecedorModel buscarPorId(@PathVariable Long id){
        return fornecedorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorModel> atualizarCliente(@PathVariable Long id, @RequestBody FornecedorModel clienteModel){
        FornecedorModel model = fornecedorService.atualizarFornecedor(id, clienteModel);
        return ResponseEntity.ok().body(model);
    }
}
