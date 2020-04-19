public class ShoppingCart {

    private boolean flag = false;


    public boolean getAddedToCart(Product product) {
        return flag = true;
    }

    public double getTotalPrice(int quantity) {
        if(flag)
            return quantity * 0.99;
        return 0.0;
    }
}
