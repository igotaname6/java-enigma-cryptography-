package app;



public class TerminalTranslator implements Module{
    private inEncipherMode;
    private cipherName;


    public TerminalTranslator(Boolean inEncipherMode, String cipherName){
        this.isEncipherMode = inEncipherMode;
        this.cipherName = cipherName;
    }

}
