package OCP.Design_Patterns;

public class Strategy {
}

interface FlyBehavior {
    public void fly();
}

class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can’t fly");
    }
}

interface QuackBehavior {
    public void quack();
}
class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}
class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}


abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public Duck() {
    }
    public Duck(FlyBehavior fb, QuackBehavior qb) {
        this.flyBehavior = fb;
        this.quackBehavior = qb;
    }

    public abstract void display();
    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }
    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}

class MallardDuck extends Duck{

    MallardDuck(){

    }
    MallardDuck(FlyBehavior fb, QuackBehavior qb){
        super(fb,qb);
    }
    @Override
    public void display() {
        System.out.println("I amm displaying...");
    }
}


class MiniDuckSimulator {
    public static void main(String[] args) {
        QuackBehavior qb = new Squeak();
        FlyBehavior fb = new FlyWithWings();
        Duck mallard = new MallardDuck(fb, qb);
        mallard.performQuack();
        mallard.performFly();
    }
}
