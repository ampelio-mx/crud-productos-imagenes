package com.ampeliodev.crudimagenesproductos.repository;

import com.ampeliodev.crudimagenesproductos.domain.EntidadProductos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoProductos extends JpaRepository <EntidadProductos, Integer> {
}
