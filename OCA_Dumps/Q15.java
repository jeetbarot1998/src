package OCA_Dumps;

public class Q15 {
    private int x = 0 , y = 0;

    public Q15(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setState(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }
}

class TestClass15{
    public static void main(String[] args) {
        Q15 d = new Q15(1,1);
        System.out.println(d);
        d.setState(2,2);
        System.out.println(d);

    }
}