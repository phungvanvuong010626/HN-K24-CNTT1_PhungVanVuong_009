package checkout;

public class OrderRequest {
    private String userId;
    private double totalAmount;

    public OrderRequest(String userId, double totalAmount) {
        this.userId = userId;
        this.totalAmount = totalAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
