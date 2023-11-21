package Chap2;

public class Lect2_13_polymorphism {
}

class ShoppingMart{

    private Card myCard;

    public ShoppingMart(){}

    public ShoppingMart(Card myCard){
        this.myCard = myCard;
    }

//    Method over-loaded.
    public void pay(CCard card){
        card.pay();
    }
    public void pay(DCard card){
        card.pay();
    }
    public void pay(GCard card){
        card.pay();
    }

//    We are polymorphism and abstraction. Programing to Interface.
    public void makePayment(Card c){
        c.pay();
    }

    public static void main(String[] args) {
        ShoppingMart sm = new ShoppingMart();
        CCard card = new CCard();
        sm.pay(card);
        DCard dcard = new DCard();
        sm.pay(dcard);
        GCard gcard = new GCard();
        sm.pay(gcard);
//      ==================

        System.out.println("========= Programing to Interface ===========");
        Card ccard = new CCard();
        Card dbcard = new DCard();
        Card gfcard = new GCard();
        Card hcard = new HCard();

        sm.makePayment(ccard);
        sm.makePayment(dbcard);
        sm.makePayment(gfcard);
        sm.makePayment(hcard);
    }
}


class DemoPayment{
    public static void main(String[] args) {
        System.out.println("========= DemoPayment ===========");
        ShoppingMart sm = new ShoppingMart();
        Card hcard = new HCard();
        ShoppingMart sm2 = new ShoppingMart(hcard);
        sm2.makePayment(hcard);
    }
}

interface Card{
    void pay();
}

class CCard implements Card{
    @Override
    public void pay(){
        System.out.println("Paying using Credit card");
    }
}

class DCard implements Card{
    @Override
    public void pay(){
        System.out.println("Paying using Debit card");
    }
}
class GCard implements Card{
    @Override
    public void pay(){
        System.out.println("Paying using Gift card");
    }
}

class HCard implements Card{
    @Override
    public void pay() {
        System.out.println("Paying using Holiday card");
    }
}


//=================

class TestShape{
    public static void main(String[] args) {
        TestShape ts = new TestShape();
        PlayerPiece pp = new PlayerPiece();
        GameShape gs = new GameShape();
        TilePiece tp = new TilePiece();
        ts.doShape(pp);
        ts.doShape(tp);
        ts.doShape(gs);
    }

    public void doShape(GameShape gs){
        gs.displayShape();
    }

}


class GameShape{
    public void displayShape(){
        System.out.println("Display shapes from parent GameShape");
    }
}
class PlayerPiece extends GameShape{
    public void movePiece(){
        System.out.println("Moving Piece");
    }
    @Override
    public void displayShape(){
        System.out.println("Display shapes from PlayerPiece");
    }
}
class TilePiece extends GameShape{
    public void getAdjacent(){
        System.out.println("Getting Adjacent");
    }
    @Override
    public void displayShape(){
        System.out.println("Display shapes from TilePiece");
    }
}

// =================

class Animal22{

    private String name;

    Animal22(String name){
        this.name = name;
    }

    Animal22(){
        this(makeRandomName());
    }

    public String getName() {
        return name;
    }

    private static String makeRandomName(){
        int random = (int) (Math.random() * 5);
        String name = new String[] {"A", "B", "C", "D", "E"} [random];
        return name;
    }

    public static void main(String[] args) {
        Animal22 an = new Animal22();
        Animal22 an2 = new Animal22("OJK");
        System.out.println(an.getName());
        System.out.println(an2.getName());
    }
}



