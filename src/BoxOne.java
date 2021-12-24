import java.util.ArrayList;
import java.util.List;

public class BoxOne implements Box {
    private List<Candy> candies = new ArrayList<>();

    @Override
    public void addCandy(Candy candy) {
        candies.add(candy);
    }

    @Override
    public void deleteCandy(int index) {
        candies.remove(index);
    }

    @Override
    public void deleteLastCandy() {
        candies.remove(candies.size() - 1);
    }

    @Override
    public void printWeightBox() {
        int sumWeight = 0;
        for (int i = 0; i < candies.size(); i++) {
            sumWeight += candies.get(i).getWeight();
        }
        System.out.println("Общий вес коробки:" + " " + sumWeight + "г");
    }

    @Override
    public void printPriceBox() {
        double sumPrice = 0;
        for (int i = 0; i < candies.size(); i++) {
            sumPrice += candies.get(i).getPrice();
        }
        System.out.println("Общая стоимость коробки:" + " " + sumPrice + "р");
    }

    @Override
    public void aboutCandy() {
        for (int i = 0; i < candies.size(); i++) {
            System.out.println("Информация:" + " " + candies.get(i).getAboutCandy());
        }
    }

    @Override
    public void deleteMinWeight(int minWeight) {
        if (candies == null || candies.isEmpty()) {
            return;
        }
        int sumaWeight = 0;
        for (int i = 0; i < candies.size(); i++) {
            sumaWeight += candies.get(i).getWeight();
        }
        while (sumaWeight > minWeight) {
            int index = 0;
            int min = candies.get(0).getWeight();
            for (int i = 0; i < candies.size(); i++) {
                if (min > candies.get(i).getWeight()) {
                    min = candies.get(i).getWeight();
                    index = i;
                }
            }
            sumaWeight = sumaWeight - candies.get(index).getWeight();
            candies.remove(index);
        }
    }

    @Override
    public void deleteMinPrice(double minPrice) {
        if (candies == null || candies.isEmpty()) {
            return;
        }
        double sumaPrice = 0;
        for (int i = 0; i < candies.size(); i++) {
            sumaPrice += candies.get(i).getPrice();
        }
        while (sumaPrice > minPrice) {
            int index = 0;
            double min = candies.get(0).getPrice();
            for (int i = 0; i < candies.size(); i++) {
                if (min > candies.get(i).getPrice()) {
                    min = candies.get(i).getPrice();
                    index = i;
                }
            }
            sumaPrice = sumaPrice - candies.get(index).getPrice();
            candies.remove(index);
        }
    }
}
