public class ProductAndPrice {
    private final String name;
    private final Double price;
    public ProductAndPrice(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
}
