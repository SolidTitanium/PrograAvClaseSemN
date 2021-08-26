import java.util.*;
//import java.util.function.Function;

/*
* Main encargado del I/O, parseo, etc..
*/

public class Main {
    static int state = 0;
    static boolean exit = false;
    static String error_msg = "Algo salio mal, ¿Es esto una entrada válida?\nPrueba otra vez.\n";

    public static void main(String[] args){
        Scanner scan_input = new Scanner(System.in);
        String ans;
        while (!exit){
            switch (state) {
                //Menu
                case 0 -> {
                    System.out.println(
                            """
                                    Programa: Tarea 1
                                    por Germán E. Félix S.

                                    Contiene 3 métodos:
                                    1. Descripción.
                                    2. Descripción por pares.
                                    3. Escalera.
                                                                
                                    Escriba el número del método a seleccionar.
                                    Escriba "back" para volver o "exit" para salir.
                                    """
                    );
                    ans = scan_input.nextLine();
                    exec(ans);
                }
                //Primer método
                case 1 -> {
                    System.out.println(
                            """
                                    Método 1: Descripción.
                                    Recibe un arreglo de números (flotantes)
                                    y devuelve su máximo, mínimo y promedio.
                                    
                                    Introduzca los números, separados por un espacio.
                                    Escriba "back" para volver o "exit" para salir.
                                    """
                    );
                    //Verificación
                    ans = scan_input.nextLine();
                    float[] parsed_ans_1 = parse_ans_1(ans);
                    //Continuar si la verificación no es nula
                    if(parsed_ans_1 != null){
                        float[] res_1 = RequiredMethods.describe(parsed_ans_1);
                        System.out.printf("Máximo: %1.2f, Mínimo: %1.2f, Promedio: %1.2f\n",
                                res_1[0], res_1[1], res_1[2]);
                        System.out.println("Presione enter para continuar.");
                        scan_input.nextLine();
                        state = 0;
                    }
                }
                //Segundo método
                case 2 -> {
                    System.out.println(
                            """
                                    Método 2: Descripción por pares.
                                    Recibe un arreglo de números (enteros)
                                    y devuelve la suma y promedio de pares e
                                    impares por separado.
                                    
                                    Introduzca los números, separados por un espacio.
                                    Escriba "back" para volver o "exit" para salir.
                                    """
                    );
                    //Verificación
                    ans = scan_input.nextLine();
                    int[] parsed_ans_2 = parse_ans_2(ans);
                    //Continuar si la verificación no es nula
                    if(parsed_ans_2 != null){
                        float[] res_2 = RequiredMethods.parity_describe(parsed_ans_2);
                        System.out.printf("Suma par: %1.0f, Promedio par: %1.2f, " +
                                          "Suma impar: %1.0f Promedio impar: %1.2f\n",
                                res_2[0], res_2[1], res_2[2], res_2[3]);
                        System.out.println("Presione enter para continuar.");
                        scan_input.nextLine();
                        state = 0;
                    }
                }
                //Tercer método
                case 3 -> {
                    System.out.println(
                            """
                                    Método 3: Escalera.
                                    Recibe un solo número entero (positivo) y devuelve el patrón
                                    de "escalera".
                                    
                                    Introduzca el número.
                                    Escriba "back" para volver o "exit" para salir.
                                    """
                    );
                    //Verificación
                    ans = scan_input.nextLine();
                    int parsed_ans_3 = parse_ans_3(ans);
                    //Continuar si la verificación no es nula
                    if(parsed_ans_3 != -1){
                        String res_3 = RequiredMethods.n_stair(parsed_ans_3);
                        System.out.println(res_3);
                        System.out.println("Presione enter para continuar.");
                        scan_input.nextLine();
                        state = 0;
                    }
                }
            }
        }
    }

    /*
    * Este método está encargado de parsear la respuesta
    * y cambiar el estado del programa, recibe un String
    * y realiza los cambios necesarios.
    */
    static void exec(String ans) {
        int be_test = be_help(ans);
        if(be_test == 0){
            try {
                int parsed_ans = Integer.parseInt(ans);
                if (parsed_ans < 0 || parsed_ans > 3) {
                    System.out.println(error_msg);
                } else {
                    state = parsed_ans;
                }
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println(error_msg);
            }
        }
    }

    /*
    * Un método ayudante para manejar las entradas "back" y "exit"
    */
    static int be_help(String ans){
        if (ans.equals("back")) {
            if (state == 0) {
                System.out.println("Hmm, eso no hizo mucho.\n");
            }
            state = 0;
            return 1;
        } else if (ans.equals("exit")) {
            exit = true;
            return 2;
        }
        return 0;
    }

    /*
    * Este método verifica y prepara la entrada del usuario
    * para llamar al método 1, recibe un String y devuelve un
    * arreglo de flotantes.
    */
    static float[] parse_ans_1(String ans){

        //Comprobar si la entrada es "back" o "exit"
        if(be_help(ans) > 0){
            return null;
        }
        //Bloque principal
        else{
            try{
                //Separa el String de entrada, también se puede hacer por tokens.
                String[] parsed_ans_1_string = ans.split(" ");

                //Transforma el arreglo de Strings en flotantes
                float[] parsed_ans_1_float = new float[parsed_ans_1_string.length];
                for(int i=0; i<parsed_ans_1_string.length; i++) {
                    parsed_ans_1_float[i] = Float.parseFloat(parsed_ans_1_string[i]);
                }

                return parsed_ans_1_float;

                //Si sucede un error aborta la operación
            }catch(NumberFormatException | NullPointerException e){
                System.out.println(error_msg);
                return null;
            }
        }
    }

    /*
     * Este método verifica y prepara la entrada del usuario
     * para llamar al método 2, recibe un String y devuelve un
     * arreglo de enteros.
     */
    static int[] parse_ans_2(String ans){

        //Comprobar si la entrada es "back" o "exit"
        if(be_help(ans) > 0){
            return null;
        }
        //Bloque principal
        else{
            try{
                //Separa el String de entrada, también se puede hacer por tokens.
                String[] parsed_ans_2_string = ans.split(" ");

                //Transforma el arreglo de Strings en enteros
                int[] parsed_ans_2_int = new int[parsed_ans_2_string.length];
                for(int i=0; i<parsed_ans_2_string.length; i++) {
                    parsed_ans_2_int[i] = Integer.parseInt(parsed_ans_2_string[i]);
                }

                return parsed_ans_2_int;
                //Si sucede un error aborta la operación
            }catch(NumberFormatException | NullPointerException e){
                System.out.println(error_msg);
                return null;
            }
        }
    }

    /*
     * Este método verifica y prepara la entrada del usuario
     * para llamar al método 3, recibe un String y devuelve
     * un entero.
     */
    static int parse_ans_3(String ans){
        //Comprobar si la entrada es "back" o "exit"
        if(be_help(ans) > 0){
            return -1;
        }
        else{

            //Trasforma el String de entrada en entero
            try{
                return Integer.parseInt(ans);

                //Si sucede un error aborta la operación
            }catch(NumberFormatException | NullPointerException e){
                System.out.println(error_msg);
                return -1;
            }
        }
    }
}