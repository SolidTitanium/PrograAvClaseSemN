import java.util.*;
import java.util.stream.*;

/*
* Clase final que contiene los métodos de la tarea 1.
*
* También sirve como prueba de como "simular" una clase
* estática evitando herencias de la clase con la palabra
* clave "final", declarando el constructor como privado
* para evitar instancias y declarando todos sus métodos
* como estáticos.
*/

final class RequiredMethods {

    //No se permiten instancias de clase.
    private RequiredMethods() {}

    /*
    * Primer método de la tarea, recibe un arreglo de "floats"
    * (números en representación de punto flotante) y devuelve
    * su máximo, mínimo y el promedio, en ese orden, en forma
    * de un arreglo de "floats".
    */
    static float[] describe(float[] args) {

        float[] description = new float[3];
        double[] args_as_double = new double[args.length];

        Arrays.sort(args);
        for(int i=0; i<args.length; i++) {args_as_double[i] = (double) args[i];}
        double avg = Arrays.stream(args_as_double).average().orElse(0);

        description[0] = args[args.length - 1];
        description[1] = args[0];
        description[2] = (float) avg;

        return description;
    }

    /*
    * Segundo método de la tarea, recibe un arreglo de enteros
    * y devuelve la suma y el promedio de los números pares
    * e impares por separado, en la práctica devuelve un arreglo
    * de "floats" con cuatro entradas en el orden indicado.
    */
    static float[] parity_describe(int[] args) {

        int even_count = 0;
        int[] even_hold
        for(int i=0; i<args.length; i++) {
            if(args[i]%2 == 0) {even_count += 1;}
        }
        int odd_count = args.length - even_count;
        int[] even = new int[even_count];
        int[] odd = new int[odd_count];
    }

    /*
    * Tercer método de la tarea, recibe un solo entero, devuelve
    * el siguiente patrón:
    *
    * 1
    * 2 2
    * 3 3 3
    * ...
    * n n n n ...
    *
    * En la práctica devuelve un solo "string" que al ser impreso
    * tiene el efecto deseado.
    */
    static String n_stair(int n) {return null;}
}
