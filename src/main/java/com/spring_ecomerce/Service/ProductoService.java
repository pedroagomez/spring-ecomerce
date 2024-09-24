package com.spring_ecomerce.Service;

import com.spring_ecomerce.Model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

     Producto save(Producto producto);
     Optional<Producto> get(Integer id);
     void update(Producto producto);
     void delete(Integer id);
     List<Producto> findAll();

}
