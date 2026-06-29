package modding;

public class SolderingStrategy implements ModStrategy {
    @Override
    public double calculate(ModService service) {
        System.out.println("Đang hàn switch trực tiếp lên mạch mạch hàn (Solder PCB)...");
        return 5000.0 * service.getQuantity();
    }
}
