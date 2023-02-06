package lesson23;

public class BankAccount {
    private int money;

    public BankAccount(int money) {
        this.money = money;
    }

    public synchronized void pay(int amount, String name) {
        if (money >= amount) {
            money -= amount;
            System.out.println(name + " gets " + amount + " bucks. Balance: " + money);
        } else {
            System.out.println("Sorry, " + name + ", not enough money: " + money);
        }
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "money=" + money +
                '}';
    }
}
