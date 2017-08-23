package app;

import java.io.Scanner;


public class TerminalTranslator implements Module{
    private inEncipherMode;
    private cipherName;
    private service;
    private key;


    public TerminalTranslator(Boolean inEncipherMode, String cipherName, String key){
        this.isEncipherMode = inEncipherMode;
        this.cipherName = cipherName;
        tihs.service = null;
        this.key = key;
    }

    public void initialize(ServiceProvider provider){
        EnigmaService service;
        this.service = provider.getByName(cipherName);
        if (this.service.isKeyRequired()){
            this.service.setKey(this.key)
        }
    }
    public String getName(){
        if (this.service == null){
            return "None"
        } else {
            return this.service.getName();
        }
    }
}
