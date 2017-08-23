package services;
import java.util.List;
import java.util.ArrayList;

public class AtbashCipher implements EnigmaService {

    private static List<Character> alphabet = createAlphabet();
    private static List<Character> reverseAlphabet = reverseAlphabet(alphabet);

}
