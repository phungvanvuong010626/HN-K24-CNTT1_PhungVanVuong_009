package modding;

public class TapeModStrategy implements ModStrategy {
    @Override
    public double calculate(ModService service) {
        System.out.println("Đang dán 3 lớp Tempest Tape Mod vào PCB...");
        return 50000.0;
    }
}
