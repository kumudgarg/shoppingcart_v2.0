public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getName() {
        return product.getName();
    }

    public void increaseQuantity(int extraQuantity) {
        this.quantity += extraQuantity;
    }

    public double getPrice() {
        return (product.getPrice() * quantity) - getDiscount();
    }

    public double getDiscount() {
        double discount = 0;
        if (product.getOffer() != null) {
            int buyQuantity = product.getOffer().getBuyQuantity();
            int freeQuantity = product.getOffer().getFreeQuantity();

            int freeItems = (quantity / (buyQuantity + freeQuantity)) * freeQuantity;
            discount = freeItems * product.getPrice();
        }
        return discount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
