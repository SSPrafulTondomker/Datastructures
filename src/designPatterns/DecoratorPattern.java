package designPatterns;

abstract class BasePizza {
    abstract int getPrice();
}

class MargaritaPizza extends BasePizza{
    MargaritaPizza() {

    }

    int getPrice() {
        return 100;
    }
}

class MexicanFarmHouse extends BasePizza {
    MexicanFarmHouse() {

    }
    int getPrice() {
        return 200;
    }
}

abstract class BaseTopping extends BasePizza {

}

class ExtraCheeseTopping extends BaseTopping {
    BasePizza basePizza;
    ExtraCheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    int getPrice() {
        return this.basePizza.getPrice() + 50;
    }
}

class ExtraMintsToppings extends BaseTopping {
    BasePizza basePizza;
    ExtraMintsToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    int getPrice() {
        return this.basePizza.getPrice() + 100;
    }
}


public class DecoratorPattern {

    public static void main(String[] aargs) {
        BasePizza mexicanFarmHouse = new MexicanFarmHouse();
        mexicanFarmHouse = new ExtraMintsToppings(new ExtraCheeseTopping(mexicanFarmHouse));
        System.out.println(mexicanFarmHouse.getPrice());
    }
}
