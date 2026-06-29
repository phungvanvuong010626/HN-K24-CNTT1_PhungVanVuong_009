package modding;

import java.util.ArrayList;
import java.util.List;

public class ModdingDemo {
    public static void main(String[] args) {
        // Create an order with default services
        List<ModService> services = new ArrayList<>();
        services.add(new ModService("LUBE_SWITCH", 90)); // 90 switches
        services.add(new ModService("TAPE_MOD", 1));
        services.add(new ModService("CASE_FOAM", 1));
        services.add(new ModService("SOLDERING", 90));

        KeyboardOrder order = new KeyboardOrder("ORD-001", "Keychron Q1 Pro", services);

        KeyboardModdingService moddingService = new KeyboardModdingService();

        // Calculate cost with default services
        System.out.println("--- CÁC DỊCH VỤ MẶC ĐỊNH ---");
        Quotation quotation1 = moddingService.calculateModdingCost(order);
        System.out.println("Kết quả báo giá 1: " + quotation1);
        System.out.println();

        // Now, let's register the new WIRE_BALANCING service dynamically
        // Notice we DO NOT change KeyboardModdingService.java!
        moddingService.registerStrategy("WIRE_BALANCING", new WireBalancingStrategy());

        // Create a new order that includes the new service
        List<ModService> servicesWithWireBalancing = new ArrayList<>(services);
        servicesWithWireBalancing.add(new ModService("WIRE_BALANCING", 4)); // 4 stabilizers

        KeyboardOrder order2 = new KeyboardOrder("ORD-002", "Keychron Q1 Pro with Wire Balancing", servicesWithWireBalancing);

        System.out.println("--- CÓ THÊM DỊCH VỤ MỚI (WIRE_BALANCING) ---");
        Quotation quotation2 = moddingService.calculateModdingCost(order2);
        System.out.println("Kết quả báo giá 2: " + quotation2);
    }
}
