package primenumbers;

import java.util.Scanner;
import java.util.*;

public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        //numero primos
        int limite;
        int firstprime =0;

        System.out.print("Enter a number: ");
        limite = leer.nextInt();
        ArrayList numeros = new ArrayList();
        int suma = 0;
        for (int i = 1; i <= limite; i++) {
            int auxiliar = limite % i;

            if (auxiliar == 0) {
                suma = suma + 1;

                if (suma == 2 && i != limite) {
                    firstprime = i;
                }
            }

        }
        if (suma == 2) {
            System.out.println(limite + " is a prime");
            System.out.print("Primes that do not divide " + limite + " : ");
            for (int x = 1; x <= limite; x++) {
                if (esPrimo(x)) {
                    numeros.add(x);
                }
            }
            //Eliminando el ultimo elemento del arreglo
            int index = numeros.size() - 1;
            numeros.remove(index);
            System.out.print(numeros);

        } else {
            System.out.println(limite + " is not a prime.");
            for (int x = 1; x <= limite; x++) {
                if (esPrimo(x)) {
                    numeros.add(x);
                }
            }
            System.out.print("Primes that do not divide " + limite + ": ");
            //Quitando los elementos que no interesan de la lista
            for(int i = 0; i< numeros.size(); i++){
                if(firstprime == 2){
                    numeros.clear();
                }
                else if((int)numeros.get(i) >= firstprime){
                    numeros.remove(i);
                    i = 0; 
                }
                else {
                }
            }
            System.out.print(numeros);
            System.out.println("");
            System.out.print("First prime that divides " + limite + ": " + firstprime);

        }
    }

    public static boolean esPrimo(int numero) {
        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            // Si es divisible por cualquiera de estos números, no
            // es primo
            if (numero % x == 0) {
                return false;
            }
        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo
        return true;
    }

}
