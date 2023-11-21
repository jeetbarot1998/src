package SJCP.chap_1;

// interface
public interface Bounceable {
    public static final int A = 5;
//    void bounce(); // No modifiers

    void setBounceFactor(int bf);
//    Valid

//    void bounce();
//    public void bounce();
//    abstract void bounce();
//    public abstract void bounce();
//    abstract public void bounce();

//    Invalid
//    final void bounce(); // final and abstract can never be used together, and abstract is implied
//    static void bounce(); // interfaces define instance methods
//    private void bounce(); // interface methods are always public
//    protected void bounce();

}


class B{
    public static void main(String[] args) {
        System.out.println(Bounceable.A);
    }
}

interface Foo {
    int BAR = 42;
    void go();
}
class Zap implements Foo {
    public void go() {
//        BAR = 27; => Cannot change the value of a constant
        System.out.println(BAR);
    }
}