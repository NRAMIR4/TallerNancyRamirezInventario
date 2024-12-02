package utilidades;
import java.util.Scanner;
public class Validaciones {

    public static void opcionValida(Scanner scanner) {
        while (!scanner.hasNextInt()){
            System.out.print("Por favor ingrese un número valido");
            scanner.next();//Limpia la entrada incorrecta
            System.out.print("Ingrese su opción  :  ");
        }
    }
}
