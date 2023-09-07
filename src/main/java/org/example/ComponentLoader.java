package org.example;

import org.example.anotaciones.Componente;
import org.example.anotaciones.GetMapping;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ComponentLoader {

    public static Map<String, Method> servicios = new HashMap<>();

    public static void cargarClases(String[] args) {
        Reflections reflections = new Reflections(args[0]);
        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
        System.out.println(allClasses);
        for (Class<?> c: allClasses) {
            System.out.println(c.getName());
        }
    }
    public static void cargarComponentes(String[] args) throws ClassNotFoundException {
        for(String arg: args) {
            Class<?> c = Class.forName(arg);
            if (c.isAnnotationPresent(Componente.class)) {
                Method[] metodos = c.getDeclaredMethods();
                for (Method method: metodos) {
                    if (method.isAnnotationPresent(GetMapping.class)) {
                        //Extraer el valor del parámetro
                        String ruta = method.getAnnotation(GetMapping.class).value();
                        //Extraer el nombre del método
                        String nombre = method.getName();
                        System.out.println("El método solicitado es: " + nombre);
                        //Crear la lista de tipos del método
                        //Obtener el método
                        //Agregar el método a la tabla de llave valor
                        servicios.put(ruta, method);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        //cargarComponentes(args);
        //System.out.println(ejecutar("/hello", "?name=pedro&last_name=perez"));
        //System.out.println("/helloPost");
        cargarClases(new String[]{"org.example"});
    }

    public static String ejecutar(String ruta, String query) throws InvocationTargetException, IllegalAccessException {
        return (String) servicios.get(ruta).invoke(null, query);
    }
}
