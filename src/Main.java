import problema1.*;
import problema2.*;
import problema3.*;
import problema4.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        int opcion=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                System.out.printf("\n\tMenú\n");
                System.out.println("1- Problema 1");
                System.out.println("2- Problema 2");
                System.out.println("3- Problema 3");
                System.out.println("4- Problema 4");
                System.out.println("Cualquier otro número para salir");
                System.out.print("Ingrese una opción: ");
                opcion = Integer.parseInt(reader.readLine());

                switch (opcion){
                    case 1:{
                        System.out.print("Ingrese número de filas: ");
                        int n = Integer.parseInt(reader.readLine());
                        System.out.print("Ingrese número de columnas: ");
                        int m = Integer.parseInt(reader.readLine());
                        Problema1 matriz = new Problema1(n,m);

                        matriz.datosMatriz(reader);
                        matriz.imprimirMatriz();

                        break;
                    }
                    case 2:{
                        break;
                    }
                    case 3:{
                        break;
                    }
                    case 4:{
                        break;
                    }
                    default:{
                        break;
                    }
                }
                break;
            }
            catch (NumberFormatException e){
                System.err.println("Error, ingrese un digito: "+ e.getMessage());
                continue;
            }
            catch (RuntimeException e){
                System.err.println("Error: "+ e.getMessage());
                continue;
            }
            catch (IOException e){
                System.err.println("Error: "+ e.getMessage());
                continue;
            }
        }
    }
}
