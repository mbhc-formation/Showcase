package tn.mbhc.tudev.telldontaskkata.useCase.requests;

public class ItemSellRequest {
    private int quantity;
    private String productName;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }
}
