import com.google.gson.Gson;

public class Product {

    private String name;
    private double price;
    private BuyXGetYOffer offer;

    public Product(String name, double price, BuyXGetYOffer buyXGetYOffer) {
        this.name = name;
        this.price = price;
        this.offer = buyXGetYOffer;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.offer = null;
    }

    public String getName() throws NullProductNameException {
        if(name == null){
            throw new NullProductNameException("product name should not be null");
        }
        return name;
    }

    public double getPrice() {
        return price;
    }

    public BuyXGetYOffer getOffer() {
        return offer;
    }

}
