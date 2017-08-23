public class Rot13Enigma {

    public Rot13Enigma() {
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
}

