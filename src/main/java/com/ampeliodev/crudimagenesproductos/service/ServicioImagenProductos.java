package com.ampeliodev.crudimagenesproductos.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class ServicioImagenProductos {

    private final String directorioImagenesProductos = "C:/Users/ampel/AmpelioDevNet/Desarrollodeproyectos/intellij/crudImagenesProductos/src/main/resources/static/images/";

    public ServicioImagenProductos() throws IOException {
        Path path = Paths.get(directorioImagenesProductos);

        if(!Files.exists(path)){
            Files.createDirectories(path);
        }
    }

    public String guardarImagen(MultipartFile urlProducto) throws IOException{
        if (urlProducto.isEmpty()) {
            throw new IOException("No se ha recibido ningún archivo.");
        }
        String archivoImagen = System.currentTimeMillis() + "_" + urlProducto.getOriginalFilename();
        Path rutaArchivo = Paths.get(directorioImagenesProductos, archivoImagen);

        log.info("El nombre del archivo es: " + archivoImagen);
        log.info("La ruta del archivo es: " + rutaArchivo);

        Files.write(rutaArchivo, urlProducto.getBytes());

        return archivoImagen;
    }

}
