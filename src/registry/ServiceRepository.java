package registry;

import java.util.List;
import java.util.ArrayList;
import services.EnigmaService;

public class ServiceRepository implements ServiceProvider, ServiceRegistry {

    private static List<EnigmaService> enigmasList = new ArrayList();

    public void register(EnigmaService service) {
        enigmasList.add(service);
    }


}
