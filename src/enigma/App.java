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
	
}

