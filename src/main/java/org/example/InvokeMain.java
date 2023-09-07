package org.example;

import java.lang.reflect.*;
import java.util.Arrays;

public class InvokeMain {
    //Puede o no recibir parametros, o una lista
    public static void main(String... args) {
        try {
            //Primer parametro la clase que quiere ejecutar.
            Class<?> c = Class.forName(args[0]);
            //Arreglo de los tipos de los argumentos.
            Class[] argTypes = new Class[]{String[].class};
            //Llamar el método "main" de la clase
            Method main = c.getDeclaredMethod("main", argTypes);
            //Pasar parametros desde el segundo
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
            System.out.format("invoking %s.main()%n", c.getName());
            //Ejecutar el método
            main.invoke(null, (Object) mainArgs);
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException x) {
            x.printStackTrace();
        }
    }
}


//Anotaciones
//@HttpServer
//@Componente
//@GetMapping
//Programador
//HelloServices