package services;

public class VingenereCipher implements EnigmaService{
    private static String name = "Vinegere Cipher"
    private static Boolean isKeyRequired = true;

    private String key;

    public VingenereCipher(){
        this.key = null;
    }
}
