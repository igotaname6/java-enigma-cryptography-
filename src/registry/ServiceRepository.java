package registry;

import java.util.List;
import java.util.ArrayList;
import services.EnigmaService;

public class ServiceRepository implements ServiceProvider, ServiceRegistry {

    private List<EnigmaService> enigmasList;

    public ServiceRepository() {
        this.enigmasList = new ArrayList<EnigmaService>();
    }

    public void register(EnigmaService service) {
        this.enigmasList.add(service);
    }

    public ArrayList<String> listAll() {
        ArrayList<String> enigmasNames;

        enigmasNames = new ArrayList<String>();

        for (EnigmaService enigma : this.enigmasList) {
            enigmasNames.add(enigma.getName());
        }
        return enigmasNames;
	}

    public EnigmaService getByName(String name) {

        for (EnigmaService enigma : this.enigmasList) {
            if (enigma.getName().equals(name)) {
                return enigma;
            }
        }
        return null;
    }
}
