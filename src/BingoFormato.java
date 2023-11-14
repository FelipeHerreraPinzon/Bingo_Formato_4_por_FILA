import java.util.Random;

public class BingoFormato {

    public static void main(String[] args) {
        System.out.println("Cartones de Bingo con Formato 4 por fila:");
        System.out.println();

        for (int i = 0; i < 12; i += 4) {
            int[][] carton1 = generarCarton();
            int[][] carton2 = generarCarton();
            int[][] carton3 = generarCarton();
            int[][] carton4 = generarCarton();

            imprimirCartones(carton1, carton2, carton3, carton4);
            System.out.println(); // Salto de línea entre grupos de 4 cartones
        }
    }

    public static int[][] generarCarton() {
        int[][] carton = new int[5][5];
        Random random = new Random();

        // Rellenar el cartón con números aleatorios
        for (int i = 0; i < 5; i++) {
            int inicio = i * 15 + 1;
            int fin = inicio + 14;

            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    // El espacio central es un espacio libre
                    carton[i][j] = -1;
                } else {
                    int numero;
                    do {
                        numero = random.nextInt(fin - inicio + 1) + inicio;
                    } while (existeEnColumna(carton, j, numero));
                    carton[i][j] = numero;
                }
            }
        }

        return carton;
    }

    public static boolean existeEnColumna(int[][] carton, int columna, int numero) {
        for (int i = 0; i < 5; i++) {
            if (carton[i][columna] == numero) {
                return true;
            }
        }
        return false;
    }

    public static void imprimirCartones(int[][] carton1, int[][] carton2, int[][] carton3, int[][] carton4) {
        // System.out.println("*-----------------------*-----------------------*-----------------------*-----------------------*");
        System.out.println("\tB\tI\tN\tG\tO\t\tB\tI\tN\tG\tO\t\tB\tI\tN\tG\tO\t\tB\tI\tN\tG\tO");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numero1 = carton1[i][j];
                int numero2 = carton2[i][j];
                int numero3 = carton3[i][j];
                int numero4 = carton4[i][j];

                System.out.print("\t" +(numero1 == -1 ? "X" : numero1) );
            }

            System.out.print("\t\t"); // Espacio entre cartones

            for (int j = 0; j < 5; j++) {
                int numero2 = carton2[i][j];
                System.out.print((numero2 == -1 ? "X" : numero2) + "\t");
            }

            System.out.print("\t"); // Espacio entre cartones

            for (int j = 0; j < 5; j++) {
                int numero3 = carton3[i][j];
                System.out.print((numero3 == -1 ? "X" : numero3) + "\t");
            }

            System.out.print("\t"); // Espacio entre cartones

            for (int j = 0; j < 5; j++) {
                int numero4 = carton4[i][j];
                System.out.print((numero4 == -1 ? "X" : numero4) + "\t");
            }

            System.out.println();
        }
    }
}
