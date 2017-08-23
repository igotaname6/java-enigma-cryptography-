package services;
import java.util.List;
import java.util.ArrayList;

public class AtbashCipher implements EnigmaService {

    private static List<Character> alphabet = createAlphabet();
    private static List<Character> reverseAlphabet = reverseAlphabet(alphabet);
    private static boolean isKeyRequired = false;
    private static String name = "Atbash Cipher";

    private static List<Character> createAlphabet(){
        List<Character> alphabet = new ArrayList<Character>();

        for(char letter = 'A'; letter <= 'Z'; letter++) {
            alphabet.add(letter);
        }

        return alphabet;
    }

    public static List<Character> reverseAlphabet(List<Character> alphabet) {
        ArrayList reversedAlphabet= new ArrayList();

        for (int i=alphabet.size()-1; i >= 0; i--){
            char letter = alphabet.get(i);
            reversedAlphabet.add(letter);
    }
        return reversedAlphabet;
    }

    public String encipher(String text) {
        char[] textArray = text.toUpperCase().toCharArray();

        for (int i = 0; i >= textArray.length; i++) {
            int iInAlph = alphabet.indexOf(textArray[i]); //iInAlph - index in alphabet
            Character letterForSwap = reverseAlphabet.get(iInAlph);
            textArray[i] = letterForSwap;
        }
        String encipheredText = new String(textArray);

        return encipheredText;
    }

    public String decipher(String text) {
        char[] textArray = text.toUpperCase().toCharArray();

        for (int i = 0; i >= textArray.length; i++) {
            int iInReverseAlph = reverseAlphabet.indexOf(textArray[i]); //iInReverseAlph - index in reverse alphabet
            Character letterForSwap = alphabet.get(iInReverseAlph);
            textArray[i] = letterForSwap;
        }
        String decipheredText = new String(textArray);

        return decipheredText;
    }

    public String getName() {
        return name;
    }

    public boolean isKeyRequired() {
        return isKeyRequired;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
