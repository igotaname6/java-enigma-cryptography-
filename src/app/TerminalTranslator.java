package app;

import registry.ServiceProvider;
import services.EnigmaService;
import java.util.Scanner;


public class TerminalTranslator implements Module{
    private Boolean inEncipherMode;
    private String cipherName;
    private EnigmaService service;
    private String key;


    public TerminalTranslator(Boolean inEncipherMode, String cipherName, String key){
        this.inEncipherMode = inEncipherMode;
        this.cipherName = cipherName;
        this.service = null;
        this.key = key;
    }

    public void initialize(ServiceProvider provider){
        EnigmaService service;
        this.service = provider.getByName(cipherName);
        if (this.service.isKeyRequired()){
            this.service.setKey(this.key);
        }
    }
    public String getName(){
        if (this.service == null){
            return "None";
        } else {
            return this.service.getName();
        }
    }
    public void start(){
        Scanner sysInput;
        String line;
        String cipherOutput;


        sysInput = new Scanner(System.in);
        while (sysInput.hasNextLine()){
            line = sysInput.nextLine();
            if (this.inEncipherMode){
                cipherOutput = service.encipher(line);
            } else {
                cipherOutput = service.decipher(line);
            }
            System.out.println(cipherOutput);
        }
    }
}
