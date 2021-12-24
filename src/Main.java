public class Main {
    public static void main(String[] args) {
        BoxOne boxOne = new BoxOne();
        Sweets sweets = new Sweets("Ласточка", 12, 32.3, "Конфета");
        Lollipop lollipop = new Lollipop("Чупа-чупс", 2, 23.4, "Леденец");
        Candybar candybar = new Candybar("Mars", 37, 44.5, "Шоколадный Батончик");
        boxOne.addCandy(sweets);
        boxOne.addCandy(lollipop);
        boxOne.addCandy(candybar);

        boxOne.printPriceBox();
        boxOne.printWeightBox();
        boxOne.aboutCandy();
    }
}
