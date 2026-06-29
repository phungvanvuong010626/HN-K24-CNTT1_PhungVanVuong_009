package modding;

import java.util.List;

public class KeyboardOrder {
    private String id;
    private String kitName;
    private List<ModService> services;

    public KeyboardOrder(String id, String kitName, List<ModService> services) {
        this.id = id;
        this.kitName = kitName;
        this.services = services;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKitName() {
        return kitName;
    }

    public void setKitName(String kitName) {
        this.kitName = kitName;
    }

    public List<ModService> getServices() {
        return services;
    }

    public void setServices(List<ModService> services) {
        this.services = services;
    }
}
