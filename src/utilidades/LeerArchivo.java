package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerArchivo {
    public static void LeerArchivo() {

        String ruta = "C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\";
        ArrayList<String> idProducto = new ArrayList<>();
        ArrayList<String> nombreProducto = new ArrayList<>();
        ArrayList<String> categoria = new ArrayList<>();
        ArrayList<String> precio = new ArrayList<>();
        ArrayList<String> cantidadDisponible = new ArrayList<>();

        // 2.Construir una variable para agregar la ruta donde  se encuentra el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String Linea;
            while ((Linea = br.readLine()) != null) {
                String[] archivo = Linea.split(";");

                idProducto.add(archivo[0]);
                nombreProducto.add(archivo[1]);
                categoria.add(archivo[2]);
                precio.add(archivo[3]);
                cantidadDisponible.add(archivo[4]);
            }
        } catch (IOException e) {
        }
        for (String a : idProducto) {
            System.out.println(a);
        }
        System.out.println("...............");
        for (String a : nombreProducto) {
            System.out.println(a);
        }
        System.out.println("...............");
        for (String a : categoria) {
            System.out.println(a);
        }
        System.out.println("...............");
        for (String a : precio) {
            System.out.println(a);
        }
        System.out.println("...............");
        for (String a : cantidadDisponible) {
            System.out.println(a);
        }
        System.out.println("...............");
    }
}









