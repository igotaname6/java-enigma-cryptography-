package services;
import java.util.List;
import java.util.ArrayList;

public class AtbashCipher implements EnigmaService {

    private static List<Character> alphabet = createAlphabet();
    private static List<Character> reverseAlphabet = reverseAlphabet(alphabet);

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




}
