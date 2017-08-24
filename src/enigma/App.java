package enigma;

import registry.ServiceRepository;
import services.EnigmaService;
import services.Rot13Enigma;
import services.AtbashCipher;
import app.Module;
import app.TerminalTranslator;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
	}

	public static void TerminalArgsValidator(String[] args) throws Exception {
		int argsLength;

		argsLength = args.length;
		if (argsLength < 1) {
			throw new Exception("Wrong input");
		}
	}

	public static void TerminalArgsCipherValidator(String[] args) throws Exception {
		int argsLength;

		argsLength = args.length;
		if (argsLength < 2) {
			throw new Exception("Enter cipher name");
		}
	}

	public static void loadCiphers(ServiceRepository repo) {

		repo.register(new Rot13Enigma());
		repo.register(new AtbashCipher());
	}
	
	public static Boolean checkCipherOperation(String cipherModeString, ServiceRepository repo) throws Exception {

		Boolean encipher = null;
		ArrayList<String> ciphersList;

		if (cipherModeString.equals("-e")) {
			encipher = true;
		}
		else if (cipherModeString.equals("-d")) {
			encipher = false;
		}
		else if (cipherModeString.equals("-l")){
			ciphersList = repo.listAll();
			
			for (String cipher : ciphersList) {
				System.out.println(cipher);
			}
		}	
		else {
			throw new Exception("Wrong cipher operation (-e/-d/-l)");
		}
		return encipher;
	}
}

