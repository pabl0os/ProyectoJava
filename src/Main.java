

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion;
        double cantidad = 0.0;
        Control control = new Control();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    """
                            ******************************************************\s
                            1) Dolar =>> Peso boliviano
                            2) Peso boliviano =>> Dolar
                            3) Real brasileño =>> Dolar
                            4) Dolar =>> Real brasileño
                            5) Peso chileno =>> Dolar
                            6) Dolar =>> Peso chileno
                            7) Salir\s
                            ******************************************************"""
            );
            opcion = scanner.nextInt();
            if (opcion < 7 && opcion > 0){
            System.out.println("ingrese el valor que desea convertir");
            cantidad = scanner.nextDouble();
            }
            switch (opcion) {
                case 1:
                    control.converter("USD", "BOB", cantidad);
                    break;
                case 2:
                    control.converter("BOB", "USD", cantidad);
                    break;
                case 3:
                    control.converter("BRL", "USD", cantidad);
                    break;
                case 4:
                    control.converter("USD", "BRL", cantidad);
                    break;
                case 5:
                    control.converter("CLP", "USD", cantidad);
                    break;
                case 6:
                    control.converter("USD", "CLP", cantidad);
                    break;
                case 7:
                    System.out.println("programa finalizado");
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }

        } while (opcion != 7);
    }
}
