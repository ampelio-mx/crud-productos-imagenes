package com.ampeliodev.crudimagenesproductos.dto;

import org.springframework.web.multipart.MultipartFile;

public class DtoProductos {

    private int idProducto;
    private String nombreProducto;
    private String imagenProductoString;

    public DtoProductos() {
    }

    public DtoProductos(int idProducto, String nombreProducto, String imagenProductoString) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.imagenProductoString = imagenProductoString;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getImagenProductoString() {
        return imagenProductoString;
    }

    public void setImagenProductoString(String imagenProductoString) {
        this.imagenProductoString = imagenProductoString;
    }
}
