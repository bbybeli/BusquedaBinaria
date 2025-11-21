import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BusquedaBinaria {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[] leerArregloDesdeArchivo(String nombreArchivo) {
        files fileManager = new files();
        return fileManager.fileToIntArray(nombreArchivo);
    }

    public static int busquedaBinaria(int[] arreglo, int elemento) {
        int inicio = 0, fin = arreglo.length - 1, iter = 1;

        System.out.println("\nIniciando búsqueda binaria del elemento " + elemento);

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            System.out.println("\nIteración " + iter++);
            System.out.println("  Rango: [" + inicio + ", " + fin + "]");
            System.out.println("  Medio: " + medio + " → Valor: " + arreglo[medio]);

            if (arreglo[medio] == elemento) {
                System.out.println("  ¡Elemento encontrado en el índice " + medio + "!");
                return medio;
            }

            if (arreglo[medio] < elemento) {
                System.out.println("  " + elemento + " > " + arreglo[medio] + " → Buscar derecha");
                inicio = medio + 1;
            } else {
                System.out.println("  " + elemento + " < " + arreglo[medio] + " → Buscar izquierda");
                fin = medio - 1;
            }
        }

        System.out.println("\nElemento no encontrado.");
        return -1;
    }

    public static void ordenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++)
            for (int j = 0; j < arreglo.length - i - 1; j++)
                if (arreglo[j] > arreglo[j + 1]) {
                    int tmp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = tmp;
                }
    }

    public static boolean estaOrdenado(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1]) return false;
        return true;
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("Arreglo: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("=== BÚSQUEDA BINARIA CON PERSISTENCIA ===\n");

        System.out.print("Ingrese el nombre del archivo con los números: ");
        String archivo = br.readLine();

        int[] arreglo = leerArregloDesdeArchivo(archivo);
        if (arreglo == null || arreglo.length == 0) {
            System.out.println("Error: No se pudieron leer los datos.");
            return;
        }

        System.out.println("\nArreglo leído:");
        imprimirArreglo(arreglo);

        if (!estaOrdenado(arreglo)) {
            System.out.println("\nEl arreglo no está ordenado. Ordenándolo...");
            ordenarArreglo(arreglo);
            imprimirArreglo(arreglo);
        } else {
            System.out.println("El arreglo ya está ordenado.");
        }

        System.out.print("\nIngrese el elemento a buscar: ");
        int elemento = Integer.parseInt(br.readLine());

        int resultado = busquedaBinaria(arreglo, elemento);

        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println(
            resultado != -1 ?
            "Elemento " + elemento + " encontrado en la posición " + resultado :
            "Elemento " + elemento + " no se encuentra en el arreglo."
        );

        br.close();
    }
}
