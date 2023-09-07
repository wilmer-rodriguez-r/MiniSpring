package org.example;

import org.example.anotaciones.Componente;
import org.example.anotaciones.GetMapping;
import org.example.anotaciones.Param;

@Componente
public class HelloServices {

    @GetMapping("/hello")
    public static String hello(String path) {
        String param = path.split("\\?")[1].split("=")[1];
        return "hola: " + param;
    }

    @GetMapping("/hellopost")
    public static String helloPost(String path) {
        String param = path.split("\\?")[1].split("=")[1];
        return "hola post: " + param;
    }

}
