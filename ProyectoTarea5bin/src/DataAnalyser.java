import java.util.ArrayList;

public class DataAnalyser {
    ArrayList<String[]> entries;

    public DataAnalyser(ArrayList<String[]> data){
        entries = data;
    }

    //Devuelve un ArrayList de ResultEntries que contiene los resultados del archivo
    public ArrayList<ResultEntry> evaluateEntries(){
        ArrayList<ResultEntry> fileResults = new ArrayList<>();

        for (String[] entry : entries) {
            fileResults.add(evaluateUser(entry));
        }

        return fileResults;
    }

    //Evalúa las respuestas de un único usuario y devuelve un objeto ResultEntry
    private ResultEntry evaluateUser(String[] entry){
        String currAnswers = entry[1];
        int[] acc = {0, 0, 0, 0};
        int[] tacc = {10, 20, 20, 20};
        int[] result = {0, 0, 0 ,0};

        //Contador de 'B' y '-'
        for(int i=0; i<currAnswers.length(); i++){
            if(i%7 == 0){
                if(currAnswers.charAt(i) == 'B'){
                    acc[0]++;
                }
                else if(currAnswers.charAt(i) == '-'){
                    tacc[0]--;
                }
            }
            if((i%7 == 1) || (i%7 == 2)){
                if(currAnswers.charAt(i) == 'B'){
                    acc[1]++;
                }
                else if(currAnswers.charAt(i) == '-'){
                    tacc[1]--;
                }
            }
            if((i%7 == 3) || (i%7 == 4)){
                if(currAnswers.charAt(i) == 'B'){
                    acc[2]++;
                }
                else if(currAnswers.charAt(i) == '-'){
                    tacc[2]--;
                }
            }
            if((i%7 == 5) || (i%7 == 6)){
                if(currAnswers.charAt(i) == 'B'){
                    acc[3]++;
                }
                else if(currAnswers.charAt(i) == '-'){
                    tacc[3]--;
                }
            }
        }

        //Calificación final
        for(int i=0; i<4; i++){
            result[i] = (acc[i]*100)/(tacc[i]);
        }

        return new ResultEntry(entry[0], result);
    }
}
