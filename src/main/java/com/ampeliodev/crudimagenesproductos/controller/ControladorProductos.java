package com.ampeliodev.crudimagenesproductos.controller;

import com.ampeliodev.crudimagenesproductos.dto.DtoProductos;
import com.ampeliodev.crudimagenesproductos.service.IProductosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorProductos {

    @Autowired
    private IProductosService iProductosService;

    @PostMapping("/guardarproductos")
        public ResponseEntity<?> guardarProducto(@ModelAttribute DtoProductos dtoProductos,
                                                 @RequestPart("archivoImagen") MultipartFile archivoImagen) {
        try{


            log.info("El nombre del archivo recibido es: " +archivoImagen.getOriginalFilename());

            DtoProductos dtoProductosGuardados = iProductosService.guardarProductos(dtoProductos, archivoImagen);

            return ResponseEntity.ok(dtoProductosGuardados);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }

    @GetMapping("/listarProductosPorId")
    public ResponseEntity<?> listarProductosPorId() {
        try {

            List<DtoProductos> productoDto = iProductosService.listarProductos();
            return ResponseEntity.ok(productoDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al capturar los datos del producto" + e.getMessage());
        }
    }
}
