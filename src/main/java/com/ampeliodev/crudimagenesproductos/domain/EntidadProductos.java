package com.ampeliodev.crudimagenesproductos.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@Table(name="productos")
public class EntidadProductos implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private int idEntidad;
    @Column(name="nombre_producto")
    private String nombreEntidad;
    @Column(name="url_producto")
    private String imagenProductoString;

}
