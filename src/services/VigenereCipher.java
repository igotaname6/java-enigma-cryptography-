

import java.util.HashMap;
import java.util.ArrayList;


public class VigenereCipher{

    private static String name = "Vinegere Cipher";
    private static Boolean isKeyRequiredBool = true;
    private static HashMap tableau = getCipherTableau();

    private String key;

    public VigenereCipher(){
        this.key = null;
    }

    private static HashMap<String, Character> getCipherTableau(){
        String key;
        HashMap<String, Character> tableau;
        ArrayList<Character> alphabet;
        char letter;
        int asciiA;
        int asciiZ;
        int index;
        char letterToMove;
        char[] keyArray;

        alphabet = new ArrayList<Character>();
        asciiA = 65;
        asciiZ = 90;

        for(int i = asciiA ; i <= asciiZ; i++) {
            char ASCIIletter = (char) i;
            alphabet.add(ASCIIletter);
        }
        tableau = new HashMap<String, Character>();
        for(char firstLetter = 'A'; firstLetter <= 'Z'; firstLetter++){
            index = 0;
            for(char secondLetter = 'A'; secondLetter <= 'Z'; secondLetter++){
                char[] keyAray = {firstLetter, secondLetter};
                key = new String(keyAray);
                tableau.put(key, alphabet.get(index));
                index++;
            }
            letterToMove = alphabet.remove(0);
            alphabet.add(letterToMove);
        }
        return tableau;
    }
    public String encipher(String text){

    }
    public String decipher(String text){
        return "";
    }
    public String getName(){
        return name;
    }
    public boolean isKeyRequired(){
        return isKeyRequiredBool;
    }
    public void setKey(String key){
        this.key = key;
    }
}
