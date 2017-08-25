package enigma;

import registry.ServiceRepository;
import services.EnigmaService;
import services.Rot13Enigma;
import services.AtbashCipher;
import services.VigenereCipher;
import app.Module;
import app.TerminalTranslator;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		Boolean encipher, showCiphers;
		String encipherMethod;
		String cipherModeString;
		String key;
		ServiceRepository repo;
		TerminalTranslator terminalTranslator;

		key = null;
		repo = new ServiceRepository();
		loadCiphers(repo);

		try{
			TerminalArgsValidator(args);
			cipherModeString = args[0];
			encipher = checkCipherOperation(cipherModeString, repo);

			if (encipher != null) {
				TerminalArgsCipherValidator(args);
				encipherMethod = args[1];
				key = isKeyPresent(args, encipherMethod, repo);
				terminalTranslator = new TerminalTranslator(encipher, encipherMethod, key);
				terminalTranslator.initialize(repo);
				terminalTranslator.start();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
        repo.register(new VigenereCipher());
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

	public static String isKeyPresent(String[] args, String encipherMethod, ServiceRepository repo) throws Exception {

		String key = null;
		EnigmaService enigma;
		int KEY_INDEX = 3;

		enigma = repo.getByName(encipherMethod);

		if (enigma == null) {
			throw new Exception("Wrong cipher name");
		}

		if (enigma.isKeyRequired()) {
			if (args.length >= KEY_INDEX ) {
				key = args[KEY_INDEX];
			}
			else {
   				throw new Exception("Keyword not found");
			}
		}
		return key;
	}
}
