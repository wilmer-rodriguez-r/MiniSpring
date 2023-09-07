package org.example;

import java.lang.reflect.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        printMembers(String.class.getConstructors(), "Constructores");
        printMembers("hola".getClass().getDeclaredFields(), "Campos");
        printMembers("hola".getClass().getDeclaredMethods(), "Métodos");
    }
    private static void printMembers(Member[] mbrs, String s) {
        //Member clase padre de campo, constructor, método y clase.
        System.out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field)
                System.out.format(" %s%n", ((Field) mbr).toGenericString());
            else if (mbr instanceof Constructor)
                System.out.format(" %s%n", ((Constructor) mbr).toGenericString());
            else if (mbr instanceof Method)
                System.out.format(" %s%n", ((Method) mbr).toGenericString());
        }
        if (mbrs.length == 0)
            System.out.format(" -- No %s --%n", s);
        System.out.format("%n");
    }
}