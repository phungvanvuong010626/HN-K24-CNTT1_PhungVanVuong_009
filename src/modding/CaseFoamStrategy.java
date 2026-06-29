package modding;

public class CaseFoamStrategy implements ModStrategy {
    @Override
    public double calculate(ModService service) {
        System.out.println("Đang cắt và lót Poron foam vào đáy case...");
        return 100000.0;
    }
}
