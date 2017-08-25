package services;

public class Rot13Enigma implements EnigmaService {

    private static String name = "Rot13";
    private String key;

    public Rot13Enigma() {
        this.key = null;
    }
    public String encipher(String text){

        StringBuilder encrypted_text;

        encrypted_text = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            if       (sign >= 'a' && sign <= 'm') sign += 13;
			else if  (sign >= 'A' && sign <= 'M') sign += 13;
			else if  (sign >= 'n' && sign <= 'z') sign -= 13;
			else if  (sign >= 'N' && sign <= 'Z') sign -= 13;
            encrypted_text.append(sign);
        }
        return encrypted_text.toString();
    }

    public String decipher(String text){
        return encipher(text);
    }
        
    public String getName(){
        return name;
    } 
        
    public boolean isKeyRequired(){
        if (this.key == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public void setKey(String key) {
        this.key = key;
    }

}

