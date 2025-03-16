package com.ampeliodev.crudimagenesproductos.service;

import com.ampeliodev.crudimagenesproductos.domain.EntidadProductos;
import com.ampeliodev.crudimagenesproductos.dto.DtoProductos;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IProductosService {

    public List<DtoProductos> listarProductos();

    public DtoProductos guardarProductos(DtoProductos dtoProducto, MultipartFile archivoImagen) throws IOException;

    public void eliminarProducto(EntidadProductos producto);

    public EntidadProductos encontrarProducto(EntidadProductos producto);

}
