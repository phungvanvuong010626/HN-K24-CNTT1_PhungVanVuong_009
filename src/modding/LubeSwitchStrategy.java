package modding;

public class LubeSwitchStrategy implements ModStrategy {
    @Override
    public double calculate(ModService service) {
        System.out.println("Đang apply mỡ bôi trơn Krytox 205g0 cho switch...");
        return 3000.0 * service.getQuantity(); // 3.000đ cho mỗi switch
    }
}
