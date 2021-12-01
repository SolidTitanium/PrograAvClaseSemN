import java.util.ArrayList;
import java.util.Arrays;

public class TempMain {
    public static void main(String[] args){
        StringBuilder resultString = new StringBuilder();

        //Leer datos
        DataReader myReader = new DataReader("D:\\OtherMyScripts\\ProgramaciónAvanzada\\repo\\PrograAvClaseSemN\\ProyectoTarea5bin\\res\\personality.txt");
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
