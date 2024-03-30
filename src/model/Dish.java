package Model;

public class Dish{
    private String name;
    private int price;
    private String discription;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Dish(String name, int price, String discription, String image)
    {
        this.name = name;
        this.price = price;
        this.discription = discription;
        this.image = image;
    }

}
