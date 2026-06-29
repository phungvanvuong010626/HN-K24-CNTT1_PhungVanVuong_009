package modding;

import java.util.HashMap;
import java.util.Map;

public class KeyboardModdingService {
    private final Map<String, ModStrategy> strategies = new HashMap<>();

    public KeyboardModdingService() {
        // Register default strategies
        strategies.put("LUBE_SWITCH", new LubeSwitchStrategy());
        strategies.put("TAPE_MOD", new TapeModStrategy());
        strategies.put("CASE_FOAM", new CaseFoamStrategy());
        strategies.put("SOLDERING", new SolderingStrategy());
    }

    /**
     * Register a new modding strategy.
     * This allows adding new services (e.g., WIRE_BALANCING) without modifying the core service.
     */
    public void registerStrategy(String type, ModStrategy strategy) {
        strategies.put(type, strategy);
    }

    public Quotation calculateModdingCost(KeyboardOrder order) {
        double total = 0;
        
        System.out.println("Bắt đầu tính toán chi phí custom cho kit: " + order.getKitName());

        for (ModService mod : order.getServices()) {
            String type = mod.getType();
            ModStrategy strategy = strategies.get(type);
            
            if (strategy == null) {
                throw new RuntimeException("Dịch vụ mod này chưa được xưởng hỗ trợ: " + type);
            }
            
            double cost = strategy.calculate(mod);
            total += cost;
        }

        return new Quotation(order.getId(), total, "DRAFT");
    }
}
