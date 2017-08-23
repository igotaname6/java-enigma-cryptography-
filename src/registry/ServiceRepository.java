package registry;

import java.util.List;
import java.util.ArrayList;
import services.EnigmaService;

public class ServiceRepository implements ServiceProvider, ServiceRegistry {

    private List<EnigmaService> enigmasList;

    ServiceRepository() {
        this.enigmasList = new ArrayList();
    }

    public void register(EnigmaService service) {
        this.enigmasList.add(service);
    }

    public List<String> listAll() {
        List<String> enigmasNames = new ArrayList();

        for (EnigmaService enigma : enigmasList) {
            enigmasNames.add(enigma.getName());
        }
        return enigmasNames;
	}

    public EnigmaService getByName(String name) {

        for (EnigmaService enigma : enigmasList) {
            if (enigma.getName().equals(name)) {
                return enigma;
            }
        }
        return null;
    }
}
