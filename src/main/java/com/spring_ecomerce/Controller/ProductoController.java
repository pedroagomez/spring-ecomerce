package com.spring_ecomerce.Controller;

import com.spring_ecomerce.Model.Producto;
import com.spring_ecomerce.Model.Usuario;
import com.spring_ecomerce.Service.ProductoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller
@RequestMapping("/productos")

public class ProductoController {


    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;


    @GetMapping("/create")
    public String create()
    {
        return "productos/create";
    }

    @GetMapping
    public String show (Model model)
    {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @PostMapping("/save")
    public String save(Producto producto)
    {
        LOGGER.info("Este es el objeto producto {}", producto);

        Usuario usuario = new Usuario(1,"","","","","","","");
        producto.setUsuario(usuario);
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model)
    {
        Producto producto = new Producto();
        Optional<Producto>optionalProducto= productoService.get(id);
        producto=optionalProducto.get();
        LOGGER.info("Producto buscado {}", producto);
        model.addAttribute("producto", producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto)
    {
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        productoService.delete(id);
        return "redirect:/productos";
    }
}
