import java.util.*;
//import java.util.stream.*;

/*
* Clase "final" que contiene los métodos de la tarea 1.
*
* También sirve como prueba de como "simular" una clase
* estática, declarando el constructor como privado
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
        //Stream no tiene una interfaz de flotantes, se deben de usar dobles.
        double[] args_as_double = new double[args.length];

        Arrays.sort(args);
        for(int i=0; i<args.length; i++) {args_as_double[i] = args[i];}
        float avg = (float) Arrays.stream(args_as_double).average().orElse(0);

        description[0] = args[args.length - 1];
        description[1] = args[0];
        description[2] = avg;

        return description;
    }

    /*
    * Segundo método de la tarea, recibe un arreglo de enteros
    * y devuelve la suma y el promedio de los números pares
    * e impares por separado, en la práctica devuelve un arreglo
    * de "floats" con cuatro entradas en el orden indicado.
    */
    static float[] parity_describe(int[] args) {

        int[] even = Arrays.stream(args).filter( (i) -> i%2 == 0 ).toArray();
        int[] odd = Arrays.stream(args).filter( (i) -> i%2 == 1 ).toArray();

        return new float[] {
                Arrays.stream(even).sum(),
                (float) Arrays.stream(even).average().orElse(0),
                Arrays.stream(odd).sum(),
                (float) Arrays.stream(odd).average().orElse(0)
        };
    }

    /*
    * Tercer método de la tarea, recibe un solo entero, devuelve
    * el siguiente patrón:
    *
    * 1
    * 2 2
    * 3 3 3
    * 4 4 4 4
    * ...
    * n n n n ...
    *
    * (el patrón tiene n^2 + n - 1 caracteres
    * (contando espacios y saltos de líneas))
    *
    * En la práctica devuelve un solo "string" que al ser impreso
    * tiene el efecto deseado.
    */
    static String n_stair(int n){

        StringBuilder stair = new StringBuilder(n*n + n);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++) {
                stair.append(i + 1).append(" ");
            }
            stair.deleteCharAt((i*i) + i - 1);
            stair.append("\n");
        }
        stair.deleteCharAt((n*n) + n - 1);

        return stair.toString();
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
    *
    * Este método es recursivo como una prueba, no creo que sea
    * muy eficiente.
    */
    static String recursive_n_stair(int n) {
        if (n == 1) {return Integer.toString(n);}
        else{
            StringBuilder my_str = new StringBuilder("\n");
            for(int i=0;i<n-1;i++){
                my_str.append(n).append(" ");
            }
            my_str.append(n);

            return recursive_n_stair(n-1) + my_str;
        }
    }
}
