package modding;

public class WireBalancingStrategy implements ModStrategy {
    @Override
    public double calculate(ModService service) {
        System.out.println("Đang cân wire và nắn thanh thép stabilizer...");
        return 15000.0 * service.getQuantity(); // 15.000đ cho mỗi stabilizer
    }
}
