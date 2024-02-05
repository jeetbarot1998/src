package OCA_Dumps;

public class Q22 {
}

class ShoppingMart {
    public ShoppingMart() {
    }

    public static void makePayment(CardP c){ c.pay(); }

    public static void main(String[] args) {
        System.out.println("========= Programing to Interface and Lambda ===========");
        CardP dbCard = () -> {
                System.out.println("Paying using Debit card");
        };

        CardP cCard = () -> {
            System.out.println("Paying using credit card");
        };

        CardP gCard = () -> {
            System.out.println("Paying using Gift card");
        };

        makePayment(dbCard);
        makePayment(cCard);
        makePayment(gCard);

        CardP db = new CCard();
        makePayment(db);

    }

}


interface CardP{
    void pay();
}

class CCard implements CardP {
    @Override
    public void pay(){
        System.out.println("Paying using Credit card");
    }
}

class DCard implements CardP {
    @Override
    public void pay(){
        System.out.println("Paying using Debit card");
    }
}
class GCard implements CardP {
    @Override
    public void pay(){
        System.out.println("Paying using Gift card");
    }
}

class HCard implements CardP {
    @Override
    public void pay() {
        System.out.println("Paying using Holiday card");
    }
}

