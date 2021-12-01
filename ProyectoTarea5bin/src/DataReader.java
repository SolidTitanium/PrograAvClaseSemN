import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DataReader {
    String filePath;

    public DataReader(String path){
        filePath = path;
    }

    /*
    * Método sin parámetros que lee el documento indicado (por constructor)
    * y devuelve un arreglo tal que cada entrada es una lista
    * de dos elementos, el nombre del usuario y sus respuestas.
    */
    public ArrayList<String[]> fetch(){

        ArrayList<String[]> entries = new ArrayList<>();
        ArrayList<String> dataLines = readData();
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        //Separando nombres de resultados
        for(int i=0; i<dataLines.size(); i++){
            if(i%2 == 0){
                users.add(dataLines.get(i));
            }
            else{
                answers.add(dataLines.get(i).toUpperCase(Locale.ROOT));
            }
        }

        //Construyendo el arreglo de entradas
        for(int i=0; i<users.size(); i++){
            String[] curr = {users.get(i), answers.get(i)};
            entries.add(curr);
        }

        return entries;
    }

    //Método de ayuda para leer el archivo
    private ArrayList<String> readData(){
        ArrayList<String> dataLines = new ArrayList<>();

        try {
            File dataFile = new File(filePath);
            Scanner myReader = new Scanner(dataFile);
            while (myReader.hasNextLine()) {
                dataLines.add(myReader.nextLine().strip());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error de path, no se encuentra el archivo");
            e.printStackTrace();
        }

        return dataLines;
    }
}
