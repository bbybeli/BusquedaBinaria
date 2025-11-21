import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class files {

    // Contar número de líneas en un archivo
    public int countFileLines(String fileName) {
        int numLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\archivos\\" + fileName)))) {
            while (br.readLine() != null) numLines++;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return numLines;
    }

    // Lee archivo de números y los convierte en arreglo int[]
    public int[] fileToIntArray(String fileName) {
        int[] array = null;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\archivos\\" + fileName)))) {
            array = new int[countFileLines(fileName)];
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                array[i++] = Integer.parseInt(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return array;
    }

    // Lee archivo con texto y lo convierte en String[]
    public String[] fileToStringArray(String fileName) {
        String[] array = null;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\archivos\\" + fileName)))) {
            array = new String[countFileLines(fileName)];
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                array[i++] = linea;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return array;
    }
}
