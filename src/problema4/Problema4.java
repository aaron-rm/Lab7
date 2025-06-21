package problema4;
import java.util.Locale;

//Declare 2 vectores. Uno contendrá el nombre de los estudiantes y el otro la calificación
//final obtenida en el curso.  Ordene los dos vectores. Permita al usuario escoger si ordena
//por orden de notas de menor a mayor ambos vectores o por orden alfabético

public class Problema4 {
    private String[] nombres;
    private double[] notas;

    public Problema4(int cantidad) {
        nombres = new String[cantidad];
        notas = new double[cantidad];
    }
    public void cargarDatos(java.io.BufferedReader reader) throws java.io.IOException {
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre del estudiante #" + (i + 1) + ": ");
            nombres[i] = reader.readLine();

            while (true) {
                try {
                    System.out.print("Ingrese la nota final de " + nombres[i] + ": ");
                    notas[i] = Double.parseDouble(reader.readLine());
                    if (notas[i] < 0 || notas[i] > 20) {
                        throw new IllegalArgumentException("La nota debe estar entre 0 y 20.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Ingrese un número válido para la nota.");
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    public void ordenarPorNotaAscendente() {
        ordenarNotas(true);
    }
    public void ordenarPorNotaDescendente() {
        ordenarNotas(false);
    }
    public void ordenarPorNombreAscendente() {
        ordenarNombres(true);
    }
    public void ordenarPorNombreDescendente() {
        ordenarNombres(false);
    }
    private void ordenarNotas(boolean ascendente) {
        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = i + 1; j < notas.length; j++) {
                if ((ascendente && notas[i] > notas[j]) || (!ascendente && notas[i] < notas[j])) {
                    double tmpNota = notas[i];
                    notas[i] = notas[j];
                    notas[j] = tmpNota;

                    String tmpNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = tmpNombre;
                }
            }
        }
    }
    private void ordenarNombres(boolean ascendente) {
        for (int i = 0; i < nombres.length - 1; i++) {
            for (int j = i + 1; j < nombres.length; j++) {
                int comparacion = nombres[i].compareToIgnoreCase(nombres[j]);
                if ((ascendente && comparacion > 0) || (!ascendente && comparacion < 0)) {
                    String tmpNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = tmpNombre;

                    double tmpNota = notas[i];
                    notas[i] = notas[j];
                    notas[j] = tmpNota;
                }
            }
        }
    }
    public void imprimir() {
        System.out.println("\nListado de estudiantes:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + " - Nota: " + notas[i]);
        }
    }

    public void buscarPorNombre(String nombreBuscado) {
        boolean encontrado = false;
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Estudiante encontrado: " + nombres[i] + " - Nota: " + notas[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró al estudiante con nombre: " + nombreBuscado);
        }
    }
}
