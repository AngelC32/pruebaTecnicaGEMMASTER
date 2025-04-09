package com.pruebatecnica.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.crud.models.Producto;
import com.pruebatecnica.crud.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private ProductoRepository repository;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll(){
        return (List<Producto>) repository.findAll();
    }

    @Override
    @Transactional
    public Producto create(Producto producto){
        return repository.save(producto);
    }

    @Override
    @Transactional
    public Optional<Producto> delete(Long id) {
        Optional<Producto> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productoDb->{
            repository.delete(productoDb);
        });
        return productoOptional;
        
    }

    @Override
    @Transactional
    public Optional<Producto> update (Long id, Producto producto){
            Optional<Producto> productoOptional = repository.findById(id);
            if(productoOptional.isPresent()){
                Producto productoDb = productoOptional.orElseThrow();
                productoDb.setNombre(producto.getNombre());
                productoDb.setPrecio(producto.getPrecio());
                productoDb.setStock(producto.getStock());
                productoDb.setCategoria(producto.getCategoria());
                return Optional.of(repository.save(productoDb));
            }
            return Optional.empty();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    
}
