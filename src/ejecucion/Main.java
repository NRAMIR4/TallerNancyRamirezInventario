package ejecucion;

import menus.MenuInventario;
import menus.SubMenuInventario;
import utilidades.LeerArchivo;
import utilidades.Validaciones;
import java.util.Scanner;
import operaciones.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scannerMenuInventario = new Scanner(System.in);
        Scanner scannerAgregarProducto = new Scanner(System.in);
        Scanner scannerActualizarProducto = new Scanner(System.in);
        Scanner scannerEliminarProducto = new Scanner(System.in);
        Scanner scannerBuscar = new Scanner(System.in);
        Scanner scannerReporte = new Scanner(System.in);
        Scanner scannerCantidadProductoporCategoria = new Scanner(System.in);
        Scanner scannerCalcularValorMayor = new Scanner(System.in);
        int opcion = 0;

        do {
            MenuInventario.menuInventario();//Clase y el metodo;
            Validaciones.opcionValida(scannerMenuInventario);
            opcion = scannerMenuInventario.nextInt();
            switch (opcion) {
                case 1:
                    Inventario.agregarProducto();
                    Validaciones.opcionValida(scannerAgregarProducto);
                    int opcionUno = scannerAgregarProducto.nextInt();
                    switch (opcionUno) {
                        case 1:
                            Inventario.agregarProducto();
                            Validaciones.opcionValida(scannerAgregarProducto);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("*****************************************");
                            System.out.println("   INGRESE NUEVAMENTE UNA OPCIÓN         ");
                            System.out.println("*****************************************");
                            break;
                    }
                    break;
                case 2:
                    Inventario.actualizarProducto();
                    Validaciones.opcionValida(scannerActualizarProducto);
                    int opcionDos = scannerActualizarProducto.nextInt();
                    switch (opcionDos) {
                        case 2:
                            Inventario.actualizarProducto();
                            Validaciones.opcionValida(scannerActualizarProducto);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("*****************************************");
                            System.out.println("   INGRESE NUEVAMENTE UNA OPCIÓN         ");
                            System.out.println("*****************************************");
                            break;
                    }
                    break;
                case 3:
                    Inventario.eliminarProducto();
                    Validaciones.opcionValida(scannerEliminarProducto);
                    int opcionTres = scannerEliminarProducto.nextInt();
                    switch (opcionTres) {
                        case 3:
                            Inventario.eliminarProducto();
                            Validaciones.opcionValida(scannerEliminarProducto);
                            break;
                        case 8:
                            break;
                        default:
                        System.out.println("*****************************************");
                        System.out.println("   INGRESE NUEVAMENTE UNA OPCIÓN         ");
                        System.out.println("*****************************************");
                        break;
                    }
                    break;
                case 4:
                    SubMenuInventario.buscar();
                    Validaciones.opcionValida(scannerBuscar);
                    int opcionCuatro = scannerBuscar.nextInt();
                    switch (opcionCuatro) {
                        case 41:
                            Inventario.buscarCategoria();
                            break;
                        case 42:
                            Inventario.buscarProductoId();
                            break;
                        case 43:
                            Inventario.buscarProductoNombre();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("*****************************************");
                            System.out.println("   INGRESE NUEVAMENTE UNA OPCIÓN         ");
                            System.out.println("*****************************************");
                            break;
                    }
                    break;
                case 5:
                    Inventario.reporte();
                    Validaciones.opcionValida(scannerReporte);
                    int opcionCinco = scannerReporte.nextInt();
                    switch (opcionCinco) {
                        case 1:
                            Inventario.reporte();
                            Validaciones.opcionValida(scannerReporte);
                            break;
                        case 0:
                            break;
                        default:
                        System.out.println("*****************************************");
                        System.out.println("   INGRESE NUEVAMENTE UNA OPCIÓN         ");
                        System.out.println("*****************************************");
                        break;
                    }
                    break;
                case 6:
                    Inventario.cantidadProductoCategoria();
                    Validaciones.opcionValida(scannerCantidadProductoporCategoria);
                    int opcionSeis = scannerCantidadProductoporCategoria.nextInt();
                    switch (opcionSeis) {
                        case 1:
                            Inventario.cantidadProductoCategoria();
                            Validaciones.opcionValida(scannerCantidadProductoporCategoria);
                            break;
                        case 0:
                            break;
                        default:
                        System.out.println("*****************************************");
                        System.out.println("   INGRESE NUEVAMENTE UNA OPCIÓN         ");
                        System.out.println("*****************************************");
                        break;
                    }
                    break;
                case 7:
                    Inventario.calcularValorMayor();
                    Validaciones.opcionValida(scannerCalcularValorMayor);
                    int opcionSiete = scannerCalcularValorMayor.nextInt();
                    switch (opcionSiete) {
                        case 1:
                            Inventario.calcularValorMayor();
                            Validaciones.opcionValida(scannerCalcularValorMayor);
                            break;
                        case 0:
                            break;
                        default:
                        System.out.println("*****************************************");
                        System.out.println("   INGRESE NUEVAMENTE UNA OPCIÓN         ");
                        System.out.println("*****************************************");
                        break;
                    }
                    break;
                case 8:
                    break;

            }
            if (opcion != 8) {
                System.out.println("PRESIONE ENTER PARA CONTINUAR...");
                scanner.nextLine(); // Espera a que el usuario presione Enter
                for (int i = 0; i < 7; i++) {
                    System.out.println("  ");
                }
            }
        } while (opcion != 8);//  si ya no se cumple  la condicion se detiene  por eso se coloca cero
        System.out.println("  ****************************************** ");
        System.out.println("  *   USTED HA SALIDO DEL MENÚ INVENTARIO  * ");
        System.out.println("  *        GRACIAS POR SU VISITA           * ");
        System.out.println("  ****************************************** ");
    }
}