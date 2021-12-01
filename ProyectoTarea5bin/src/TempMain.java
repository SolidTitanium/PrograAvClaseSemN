//Tarea 5 por Germán Eduardo Félix Spíndola
//Programación Avanzada

import java.util.ArrayList;
import java.util.Arrays;

public class TempMain {
    public static void main(String[] args){
        StringBuilder resultString = new StringBuilder();

        //Leer datos
        DataReader myReader = new DataReader("src/bigdata.txt"); //Path del documento
        ArrayList<String[]> entries = myReader.fetch();

        //Procesar datos
        DataAnalyser myAnalyser = new DataAnalyser(entries);
        ArrayList<ResultEntry> test = myAnalyser.evaluateEntries();

        //Crear String final
        for (ResultEntry rEntry : test){
            resultString.append(rEntry.userName).append(": ")
                    .append(Arrays.toString(rEntry.userResult)).append(" = ")
                    .append(rEntry.userLetters).append("\n");
        }

        System.out.println(resultString);
    }
}
