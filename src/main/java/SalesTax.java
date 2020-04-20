public class SalesTax {

    private final double SALES_TAX_RATE = 2.0;

    public double getSalesTax(double price){
        double salesTax = (price * SALES_TAX_RATE) / 100;
        return salesTax;
    }
}
