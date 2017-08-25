package services;

import java.util.HashMap;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Set;


public class VigenereCipher implements EnigmaService{

    private static String name = "VigenereCipher";
    private static Boolean isKeyRequiredBool = true;
    private static HashMap<String, Character> tableau = getCipherTableau();

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
        char[] textCharArray;
        char[] keyCharArray;
        char encryptedLetter;
        StringBuilder encryptedText;
        int keyIndex;

        textCharArray = text.toUpperCase().toCharArray();
        keyCharArray = this.key.toUpperCase().toCharArray();
        encryptedText = new StringBuilder();

        keyIndex  = 0;
        for(int index = 0; index < textCharArray.length; index++){
            if (textCharArray[index] == ' '){
                encryptedText.append(' ');
                continue;
            }
            encryptedLetter = encrypteOneChar(index, keyIndex, textCharArray, keyCharArray);
            encryptedText.append(encryptedLetter);
            keyIndex++;
            if (keyIndex == keyCharArray.length){
                keyIndex = 0;
            }
        }
        return encryptedText.toString();
    }
    private static Character encrypteOneChar(int index, int keyIndex, char[] textCharArray, char[] keyCharArray){
        char letterToEncrypt;
        char letterKey;
        String tableauKey;

        letterToEncrypt = textCharArray[index];
        letterKey = keyCharArray[keyIndex];
        tableauKey = String.valueOf(letterToEncrypt).concat(String.valueOf(letterKey));
        tableauKey = tableauKey.toUpperCase();

        return tableau.get(tableauKey);
    }

    public String decipher(String text){
        Set<String> tableauKeysSet;
        char[] textCharArray;
        char[] keyCharArray;
        StringBuilder decryptedText;
        int keyIndex;

        textCharArray = text.toUpperCase().toCharArray();
        keyCharArray = this.key.toUpperCase().toCharArray();
        decryptedText = new StringBuilder();
        tableauKeysSet = tableau.keySet();

        keyIndex  = 0;
        for(char letterToDecrypt : textCharArray){
            if (letterToDecrypt == ' '){
                decryptedText.append(' ');
                continue;
            }
            for(String tableauKey : tableauKeysSet){
                if (tableauKey.charAt(0) == keyCharArray[keyIndex]){
                    if(tableau.get(tableauKey) == letterToDecrypt){
                        decryptedText.append(tableauKey.charAt(1));
                    }
                }
            }
            keyIndex++;
            if (keyIndex == keyCharArray.length){
                keyIndex = 0;
            }
        }
        return decryptedText.toString();
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
