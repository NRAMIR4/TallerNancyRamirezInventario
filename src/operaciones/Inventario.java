package operaciones;

import menus.MenuInventario;
import utilidades.Validaciones;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.*;

public class Inventario {

//1-METODO PARA AGREGAR PRODUCTOS
    public static void agregarProducto() {
        Scanner scanner=new Scanner (System.in);
        System.out.println("Ingrese  la cantidad  de productos que ingresaran al inventario del sistema:   ");
        int cantidadInventario=scanner.nextInt();
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\"))){
                for (int i= 0; i<cantidadInventario; i++){
                System.out.println("Ingrese el ID del producto" +(i+1)+ ":");
                int idProducto= scanner.nextInt();
                System.out.println("Ingrese el nombre del producto" +(i+1)+ ":");
                String nombreProducto= scanner.next();
                System.out.println("Ingrese la categoria del producto" +(i+1)+ ":");
                String categoria= scanner.next();
                System.out.println("Ingrese el precio del producto" +(i+1)+ ":");
                double precio= scanner.nextDouble();
                System.out.println("Ingrese la cantidad de producto" +(i+1)+ ":");
                int cantidadDisponible= scanner.nextInt();
                writer.write(idProducto + ";" + nombreProducto + ";" + categoria + ";" + precio + ";" + cantidadDisponible + "\n");
            }
            System.out.println("SE HA CREADO E INGRESADO PRODUCTO(S) AL INVENTARIO-REVISE EL ARCHIVO - productos.csv");
        }catch (IOException e)
        {
            System.out.println("Error al crear el producto:  " + e.getMessage());
        }
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
            System.out.println("...idProducto...");
            for (String a : idProducto) {
                System.out.println(a);
            }
            System.out.println("...nombreProducto..");
            for (String a : nombreProducto) {
                System.out.println(a);
            }
            System.out.println("...categoria.....");
            for (String a : categoria) {
                System.out.println(a);
            }
            System.out.println("..precio.......");
            for (String a : precio) {
                System.out.println(a);
            }
            System.out.println("..cantidadDisponible..");
            for (String a : cantidadDisponible) {
                System.out.println(a);
            }
            System.out.println("...............");
            System.out.println("Para SALIR seleccione la opción 8");
        }

//2-METODO PARA ACTUALIZAR PRODUCTOS
    public static void actualizarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto que desea actualizar: ");
        int idProducto = scanner.nextInt();
        try {
            File archivo = new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\");
            Scanner scannerArchivo = new Scanner(archivo);
            StringBuilder contenido = new StringBuilder();
            boolean registroEncontrado = false;
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] campos = linea.split(";");
                if (Integer.parseInt(campos[0]) == idProducto) {
                    registroEncontrado = true;
                    System.out.println("Registro que se está actualizando:");
                    System.out.println(linea);
                    System.out.print("Ingrese el nuevo ID del producto: ");
                    int nuevoIdProducto = scanner.nextInt();
                    System.out.print("Ingrese el nuevo nombre del producto: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Ingrese la nueva categoría del producto: ");
                    String nuevaCategoria = scanner.next();
                    System.out.print("Ingrese el nuevo precio del producto: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Ingrese la nueva cantidad del producto: ");
                    int nuevaCantidad = scanner.nextInt();
                    campos[0] = String.valueOf(nuevoIdProducto);
                    campos[1] = nuevoNombre;
                    campos[2] = nuevaCategoria;
                    campos[3] = String.valueOf(nuevoPrecio);
                    campos[4] = String.valueOf(nuevaCantidad);
                    linea = String.join(";", campos);
                    System.out.println("Registro actualizado:");
                    System.out.println(linea);
                }
                contenido.append(linea).append("\n");
            }
            scannerArchivo.close();
            if (!registroEncontrado) {
                System.out.println("Registro no encontrado.");
            }
            FileWriter writer = new FileWriter(archivo);
            scannerArchivo.close();
            writer.write(contenido.toString());
            writer.close();
            System.out.println("PRODUCTO ACTUALIZADO EXITOSAMENTE.-REVISE EL ARCHIVO - productos.csv");
        } catch (IOException e) {
            System.out.println("Error al actualizar la lista en el archivo: " + e.getMessage());
        }
        System.out.println("..............................................");
        System.out.println("Para SALIR seleccione la opción 8");
    }
//3-METODO PARA ELIMINAR PRODUCTOS

    public static void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto que desea eliminar: ");
        int idProducto = scanner.nextInt();

        try {
            File archivo = new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\");
            Scanner scannerArchivo = new Scanner(archivo);

            StringBuilder contenido = new StringBuilder();
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] campos = linea.split(";");
                if (Integer.parseInt(campos[0]) != idProducto) {
                    contenido.append(linea).append("\n");
                }
            }
            scannerArchivo.close();
            FileWriter writer = new FileWriter(archivo);
            writer.write(contenido.toString());
            writer.close();

            System.out.println("PRODUCTO ELIMINADO CON EXITOSAMENTE DEL INVENTARIO.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
        System.out.println("Para SALIR seleccione la opción 8");

    }

//4-METODO PARA BUSCAR
//4.1 METODO PARA BUSCAR POR  CATEGORIA
    public static void buscarCategoria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la categoría que desea buscar paquetes-dulces-dulces-aseo-gaseosas: ");
        String categoria = scanner.nextLine();
        try {
            File archivo = new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\");
            Scanner scannerArchivo = new Scanner(archivo);
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] campos = linea.split(";");
                if (campos[2].equals(categoria)) {
                    System.out.println("IDProducto: " + campos[0]);
                    System.out.println("Nombre: " + campos[1]);
                    System.out.println("Categoría: " + campos[2]);
                    System.out.println("Precio: " + campos[3]);
                    System.out.println("Cantidad: " + campos[4]);
                }
            }
            scannerArchivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
        System.out.println("Para SALIR seleccione la opción 8");
    }
//4.2 METODO PARA BUSCAR POR IDPRODUCTO
    public static void buscarProductoId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID que desea buscar: ");
        String idProducto = scanner.nextLine();
        try {
            File archivo = new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\");
            Scanner scannerArchivo = new Scanner(archivo);
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] campos = linea.split(";");
                if (campos[0].equals(idProducto)) {
                    System.out.println("IDProducto: " + campos[0]);
                    System.out.println("Nombre: " + campos[1]);
                    System.out.println("Categoría: " + campos[2]);
                    System.out.println("Precio: " + campos[3]);
                    System.out.println("Cantidad: " + campos[4]);
                }
            }
            scannerArchivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }

    }
//4.3 METODO PARA BUSCAR POR NOMBRE
    public static void buscarProductoNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nombre de producto que desea buscar: ");
        String nombreProducto = scanner.nextLine();
        try {
            File archivo = new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\");
            Scanner scannerArchivo = new Scanner(archivo);
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] campos = linea.split(";");
                if (campos[1].equals(nombreProducto)) {
                    System.out.println("IDProducto: " + campos[0]);
                    System.out.println("Nombre: " + campos[1]);
                    System.out.println("Categoría: " + campos[2]);
                    System.out.println("Precio: " + campos[3]);
                    System.out.println("Cantidad: " + campos[4]);
                }
            }
            scannerArchivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
            }
//5-GENERAR REPORTES DE PRODUCTOS
public static void reporte() {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\reporte_inventario.txt\\\\"))) {
        writer.write("*****************************************************************\n");
        writer.write("************************REPORTE DE INVENTARIO********************\n");
        writer.write("*****************************************************************\n");
        writer.write("IDproducto\tNombreProducto\tCategoria\tPrecio\tCantidadDisponible\n");
        writer.write("*****************************************************************\n");

        Scanner scanner= new Scanner (new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\"));
        double valorTotal =0;
        while(scanner.hasNextLine()){
            String linea = scanner.nextLine();
            String[] campos = linea.split(";");
            int idProducto=Integer.parseInt(campos[0]);
            String nombreProducto=(campos[1]);
            String categoria=(campos[2]);
            double precio=Double.parseDouble(campos[3]);
            int cantidadDisponible=Integer.parseInt(campos[4]);

            double valorProducto = precio * cantidadDisponible;

            valorTotal += valorProducto;

            writer.write(idProducto + "\t" + nombreProducto + "\t" + categoria + "\t" + precio + "\t" + cantidadDisponible + "\n");
        }
        scanner.close();
        writer.write("\nValorTotal del Inventario: "+ valorTotal);
    } catch (IOException e) {
        System.out.println("Error al crear el informe: " + e.getMessage());
    }
    System.out.println("REPORTE GENERADO REVISAR ARCHIVO reporte_inventario.txt ");
    System.out.println("Para SALIR seleccione la opción 8");
}

//6-METODO CALCULAR CANTIDAD DE PRODUCTOS POR CATEGORIA
    public static void cantidadProductoCategoria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la categoría que desea consultar: ");
        String categoria = scanner.nextLine();
        try {
            File archivo = new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\");
            Scanner scannerArchivo = new Scanner(archivo);
            int cantidad = 0;
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] campos = linea.split(";");
                if (campos[2].equals(categoria)) {
                    cantidad++;
                    System.out.println(linea);
                }
            }
            scannerArchivo.close();
            System.out.println("La cantidad de productos en la categoría " + categoria + " es: " + cantidad);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        System.out.println("Para SALIR seleccione la opción 8");
    }
//7-METODO CALCULAR EL PRODUCTO DE MAYOR VALOR -PRODUCTO MAS CARO
    public static void calcularValorMayor() {
        Scanner scanner = new Scanner(System.in);
        try {
            File archivo = new File("C:\\Fundamentos de programacion\\\\TallerNancyRamirezInventario\\\\productos.csv\\\\");
            Scanner scannerArchivo = new Scanner(archivo);
            double mayorPrecio = 0;
            String productoMasCostoso = "";
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] campos = linea.split(";");
                double precio = Double.parseDouble(campos[3]);
                if (precio > mayorPrecio) {
                    mayorPrecio = precio;
                    productoMasCostoso = linea;
                }
            }
            scannerArchivo.close();
            System.out.println("El producto más costoso es:");
            System.out.println(productoMasCostoso);
            System.out.println("Con un precio de: " + mayorPrecio);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        System.out.println("Para SALIR seleccione la opción 8");
    }
}
