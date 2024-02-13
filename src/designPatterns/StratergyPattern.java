package designPatterns;

abstract class Animal{
    IFlyStratergy flyStratergy;
    public Animal(IFlyStratergy flyStratergy) {
        this.flyStratergy = flyStratergy;
    }

    void makeMeFly(){
        this.flyStratergy.makeMeFly();
    }
}


interface IFlyStratergy{
    void makeMeFly();
}

class CanFly implements IFlyStratergy {

    @Override
    public void makeMeFly(){
        System.out.println("I can fly!!!");
    }
}

class CantFly implements IFlyStratergy {

    @Override
    public void makeMeFly(){
        System.out.println("I can't fly!!!");
    }
}
class Bird extends Animal{
    Bird(IFlyStratergy flyStratergy){
        super(flyStratergy);
    }
}

class Dog extends Animal{
    Dog(IFlyStratergy flyStratergy){
        super(flyStratergy);
    }
}

public class StratergyPattern {
    public static void  main(String[] args) {
            IFlyStratergy canFlyStratergy = new CanFly();
            IFlyStratergy cantFlyStratergy = new CantFly();

            Animal bird = new Bird(canFlyStratergy);
            Animal dog = new Dog(cantFlyStratergy);

            bird.makeMeFly();
            dog.makeMeFly();
    }
}
