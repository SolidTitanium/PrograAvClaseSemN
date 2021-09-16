import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    //Aquí se indica el camino (local) al archivo.
    static String pointsPath = "src/points.txt";
    //Utilizar animación o dibujar rápido.
    static boolean ANIM = true;
    static long DELAY = 150;

    public static void main(String[] args){
        ArrayList<String[]> parsedLines = readAndParse(pointsPath);

        DrawingPanel panel = new DrawingPanel(600, 410);
        DrawEngine eng = new DrawEngine(panel);

        if(ANIM){
            for(String[] point : parsedLines){
                eng.easyDraw(point);
                try{
                    Thread.sleep(DELAY);
                }
                catch(InterruptedException e){
                    System.out.println("Algo salio mal en la animación.");
                }
            }
        }
        else{
            for(String[] point : parsedLines){
                eng.easyDraw(point);
            }
        }
    }

    /*
    * Función de ayuda para leer y parsear el archivo de entrada,
    * recibe el camino al archivo y devuelve un ArrayList<String[]>
    * creo que se puede cambiar a una lista normal de largo 100.
    */
    static ArrayList<String[]> readAndParse(String path){
        ArrayList<String[]> parsedLines = new ArrayList<>(100);

        try {
            File pointsFile = new File(path);
            Scanner myReader = new Scanner(pointsFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                parsedLines.add(data.split(" "));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error de path, no se encuentra el archivo \"puntos.txt\" en \"src\".");
            e.printStackTrace();
        }

        return parsedLines;
    }
}