package services;

import java.util.HashMap;
import java.util.ArrayList;


public class VigenereCipher implements EnigmaService{
    private static String name = "Vinegere Cipher";
    private static Boolean isKeyRequired = true;
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

        for(int i = asciiA ; i < asciiZ; i++) {
            char ASCIIletter = (char) i;
            alphabet.add(ASCIIletter);
        }
        tableau = new HashMap<String, Character>();
        for(char firstLetter = 'A'; letter <= 'Z'; firstLetter++){
            index = 0;
            for(char secondLetter = 'A'; letter <= 'Z'; firstLetter++){
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
}
