package com.zera.fornecedores.services;


import com.zera.fornecedores.models.FornecedorModel;
import com.zera.fornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    public FornecedorRepository fornecedorRepository;

    public FornecedorModel criarFornecedor (FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);
    }

    public List<FornecedorModel> buscarTodosFornecedores(){
        return fornecedorRepository.findAll();
    }

    public FornecedorModel buscarPorId (Long id){
        return fornecedorRepository.findById(id).get();
    }

    public void deletar (Long id){
        fornecedorRepository.deleteById(id);
    }

    public FornecedorModel atualizarFornecedor (Long id, FornecedorModel fornecedorModel){
        FornecedorModel newFornecedor = fornecedorRepository.findById(id).get();
        newFornecedor.setNomeFantasia(fornecedorModel.getNomeFantasia());
        newFornecedor.setCnpj(fornecedorModel.getCnpj());
        newFornecedor.setContato(fornecedorModel.getContato());
        return fornecedorRepository.save(newFornecedor);
    }


}
