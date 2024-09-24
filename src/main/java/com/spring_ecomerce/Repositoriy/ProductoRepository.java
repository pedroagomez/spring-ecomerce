package com.spring_ecomerce.Repositoriy;

import com.spring_ecomerce.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
