public abstract class Candy {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    private String aboutCandy;

    public void setAboutCandy(String aboutCandy) {
        this.aboutCandy = aboutCandy;
    }

    public String getAboutCandy() {
        return aboutCandy;
    }
}
