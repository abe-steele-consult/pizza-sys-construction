import Models.*;

public class PizzaMain {

    public static void main(String[]args) {
        Chain chain = new Chain(3);
        CorpMenu corpMenu = new CorpMenu(chain, 1);
        chain.setCorpMenu(corpMenu);
    }
}
