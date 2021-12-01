public class ResultEntry {
    String userName;
    int[] userResult;
    String userLetters;
    String[] letters = {"E", "I", "S", "N", "T", "F", "J", "P"};

    public ResultEntry(String name, int[] result){
        userName = name;
        userResult = result;
        userLetters = lettersFromResult(result);
    }

    //Método de ayuda para calcular las siglas
    private String lettersFromResult(int[] result){
        String tempLetters = "";

        for(int i=0; i<4; i++){
            if(result[i]<50) {
                tempLetters = tempLetters.concat(letters[i * 2]);
            }
            else if(result[i]>50){
                tempLetters = tempLetters.concat(letters[(i * 2) + 1]);
            }
            else{
                tempLetters = tempLetters.concat("X");
            }
        }

        return tempLetters;
    }
}
