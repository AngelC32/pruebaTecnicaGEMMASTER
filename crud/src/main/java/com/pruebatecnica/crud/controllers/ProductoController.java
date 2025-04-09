package com.pruebatecnica.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pruebatecnica.crud.models.Categoria;
import com.pruebatecnica.crud.models.Producto;
import com.pruebatecnica.crud.services.ICategoriaService;
import com.pruebatecnica.crud.services.IProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    private IProductoService service;
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", service.findAll());
        return "listar"; 
    }
    

    @GetMapping("/nuevo")
    public String mostrarFormularioCrearProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.findAll()); 
        return "formulario";
    }

    @PostMapping("/nuevo")
    public String crearProducto(@ModelAttribute Producto producto) {
        
       Categoria categoria = categoriaService.findById(producto.getCategoria().getId()).orElseThrow();
        producto.setCategoria(categoria);
        service.create(producto);
        return "redirect:/productos";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = service.findById(id).orElseThrow();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.findAll());
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarProducto(@PathVariable("id") Long id, @ModelAttribute Producto producto) {
        Categoria categoria = categoriaService.findById(producto.getCategoria().getId()).orElseThrow();
        producto.setCategoria(categoria);
        service.update(id,producto); 
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/productos";
    }
}
