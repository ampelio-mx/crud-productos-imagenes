package com.ampeliodev.crudimagenesproductos.service;

import com.ampeliodev.crudimagenesproductos.domain.EntidadProductos;
import com.ampeliodev.crudimagenesproductos.dto.DtoProductos;
import com.ampeliodev.crudimagenesproductos.repository.IDaoProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductosServicesImplement implements IProductosService{

    @Autowired
    private IDaoProductos daoProductos;

    @Autowired
    private ServicioImagenProductos servicioImagenProductos;

    @Override
    @Transactional(readOnly = true)
    public List<DtoProductos> listarProductos(){

        return daoProductos.findAll()
                .stream()
                .map(producto -> new DtoProductos(
                producto.getIdEntidad(),
                producto.getNombreEntidad(),
                producto.getImagenProductoString()
            )).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DtoProductos guardarProductos(DtoProductos dtoProductos, MultipartFile archivoImagen) throws IOException {

        EntidadProductos entidadProducto = new EntidadProductos();
        entidadProducto.setNombreEntidad(dtoProductos.getNombreProducto());
        String nombreproducto = entidadProducto.getNombreEntidad();

        String urlImagen = servicioImagenProductos.guardarImagen(archivoImagen);
        entidadProducto.setImagenProductoString(urlImagen);

        log.info("Nombre del producto: " + nombreproducto + "imagen: " + urlImagen);

        daoProductos.save(entidadProducto);
        return dtoProductos;
    }

    @Override
    @Transactional
    public void eliminarProducto(EntidadProductos producto){
        daoProductos.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public EntidadProductos encontrarProducto(EntidadProductos producto){
        return daoProductos.findById(producto.getIdEntidad()).orElse(null);
    }
}