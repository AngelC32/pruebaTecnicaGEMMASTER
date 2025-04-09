package com.pruebatecnica.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.crud.models.Categoria;
import com.pruebatecnica.crud.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    private CategoriaRepository repository;
    @Override
    public Optional<Categoria> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Categoria> findAll(){
        return (List<Categoria>) repository.findAll();
    }
}
