package problema1;
//Diseñe un programa que permita al usuario ingresar una matriz entera de n x m. Haga una
//segunda matriz con la traspuesta de la matriz original. Imprima ambas matrices.

import java.io.BufferedReader;
import java.io.IOException;

public class Problema1 {
    private int[][] matriz;
    private int[][] matrizTraspuesta;
    private int filas,columnas;

    public Problema1(int n, int m){
        this.filas=n;
        this.columnas=m;
        this.matriz = new int[n][m];
        this.matrizTraspuesta = new int[m][n];
    }

    public void datosMatriz(BufferedReader reader){
        try {
            for (int i=0;i<filas;i++){
                for (int j=0;j<columnas;j++){
                    System.out.printf("\nIngrese el número en la posicion [%d][%d]: ",i,j);
                    matriz[i][j] = Integer.parseInt(reader.readLine());
                    matrizTraspuesta[j][i]=matriz[i][j];
                }
            }
        }
        catch (NumberFormatException e){
            System.err.println("Error: ingrese un dígito " + e.getMessage());
        }
        catch (RuntimeException e){
            System.err.println("Error: " + e.getMessage());
        }
        catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void imprimirMatriz(){
        System.out.println("Matriz original");
        for (int i=0;i<filas;i++){
            for (int j=0;j<columnas;j++){
                System.out.printf("%d\t", matriz[i][j]);;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matriz Traspuesta");
        for (int i=0;i<columnas;i++){
            for (int j=0;j<filas;j++){
                System.out.printf("%d\t", matrizTraspuesta[i][j]);;
            }
            System.out.println();
        }
    }
}
