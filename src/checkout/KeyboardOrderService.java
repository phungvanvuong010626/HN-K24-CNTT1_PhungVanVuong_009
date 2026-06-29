package checkout;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;

@Service
public class KeyboardOrderService {
    private final OrderRepository orderRepository;

    public KeyboardOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Thực hiện chốt đơn hàng.
     * 
     * KHẮC PHỤC LỖI: Thêm `rollbackFor = Exception.class` (hoặc `rollbackFor = IOException.class`)
     * để bắt buộc Spring Framework thực hiện Rollback giao dịch khi xảy ra Checked Exception (như IOException).
     * Mặc định, Spring chỉ rollback cho Unchecked Exception (RuntimeException và Error).
     */
    @Transactional(rollbackFor = {IOException.class, Exception.class})
    public OrderConfirmation placeOrder(OrderRequest request) throws IOException {
        System.out.println("Bắt đầu xử lý đơn hàng phím cơ cho user: " + request.getUserId());
        
        Order newOrder = new Order(request.getUserId(), request.getTotalAmount(), "PENDING");
        
        // Bước 1: Lưu đơn hàng vào Database MySQL
        orderRepository.save(newOrder);

        // Bước 2: Giả lập tiến trình sinh file hóa đơn PDF và lưu xuống ổ đĩa
        // Hàm này ném ra IOException. Nhờ cấu hình rollbackFor ở trên, giao dịch sẽ được rollback,
        // đơn hàng vừa lưu ở Bước 1 sẽ bị xóa khỏi database, tránh tình trạng rác dữ liệu.
        generateInvoicePdf(newOrder);

        return new OrderConfirmation(newOrder.getId(), "SUCCESS");
    }

    private void generateInvoicePdf(Order order) throws IOException {
        throw new IOException("Không thể ghi file hóa đơn PDF vào hệ thống lưu trữ");
    }
}
