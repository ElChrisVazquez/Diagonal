package diagonal;

import java.util.Scanner;

public class Diagonal {

    private int filas, columnas, salida;
    private String entrada;
    private int[] matriz;
    private Scanner sc;

    public Diagonal() {
        sc = new Scanner(System.in);

        // Valida que sea matriz cuadrada
        do {
            // Valida si es número
            do {
                System.out.println("Ingrese el número de filas:");
                entrada = sc.next();
                if (!esNumero(entrada)) {
                    System.out.println("La entrada no es un número valido.");
                } else {
                    filas = Integer.parseInt(entrada);
                }
            } while (!esNumero(entrada));

            // Valida si es número
            do {
                System.out.println("Ingrese el número de columnas:");
                entrada = sc.next();
                if (!esNumero(entrada)) {
                    System.out.println("La entrada no es un número valido.");
                } else {
                    columnas = Integer.parseInt(entrada);
                }
            } while (!esNumero(entrada));
            if (filas != columnas) {
                System.out.println("La matriz no es cuadrada");
            }
        } while (filas != columnas || filas < 2 || columnas < 2);

        matriz = new int[filas * columnas];
        for (int i = 0; i < matriz.length; i++) {

            // Valida si es número
            do {
                System.out.println("Ingrese la posición " + (i + 1) + ":");
                entrada = sc.next();
                if (!esNumero(entrada)) {
                    System.out.println("La entrada no es un número valido.");
                } else {
                    matriz[i] = Integer.parseInt(entrada);
                }
            } while (!esNumero(entrada));

        }

        salida = diagonalDifference(matriz, filas);

        //Imprime salida
        System.out.println("Salida: " + salida);
    }

    // Función que calcula las diagonales
    public int diagonalDifference(int[] matriz, int filas) {
        int principal, secundaria, limite, contador;
        limite = matriz.length;
        principal = 0;
        contador = 0;
        for (int i = 0; i < filas; i++) {
            principal += matriz[contador];
            contador += filas + 1;
        }
        contador = filas - 1;
        secundaria = 0;
        for (int i = 0; i < filas; i++) {
            secundaria += matriz[contador];
            contador += filas - 1;
        }
        // Retorna en absoluto
        return Math.abs(principal - secundaria);
    }

    //Función valida número
    public boolean esNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Diagonal d = new Diagonal();
    }

}
