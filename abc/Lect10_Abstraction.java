package abc;
public class Lect10_Abstraction {
}

// by default the methods are public or default and abstract in nature.
interface Vehicle{
    public void start();
    public void accelerate();
    public abstract void stop();
//    private void xyz(); => Gives an error as private members makes no sense as it wont be visible for child

}

interface Machine{
    public void rotate();
}

class ship implements Vehicle, Machine{


    @Override
    public void start() {

    }

    @Override
    public void accelerate() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void rotate() {

    }

    public static void main(String[] args) {
        t u = new t();
    }
}
