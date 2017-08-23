package app;



public class TerminalTranslator implements Module{
    private inEncipherMode;
    private cipherName;
    private service;



    public TerminalTranslator(Boolean inEncipherMode, String cipherName){
        this.isEncipherMode = inEncipherMode;
        this.cipherName = cipherName;
        tihs.service = null;
    }

    public void initialize(ServiceProvider provider){
        EnigmaService service;
        this.service = provider.getByName(cipherName);
    }
}
