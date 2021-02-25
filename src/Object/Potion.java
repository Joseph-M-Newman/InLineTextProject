package Object;

public class Potion {
    double hpToGive;
    double amount;
    int type = 0;

    public Potion(double hpToGive, double amount, int type) {
        this.hpToGive = hpToGive;
        this.amount = amount;
        this.type = type;
        if(type == 1){
            hpToGive += 10;
        }
    }

    public double getHpToGive() {
        return hpToGive;
    }

    public void setHpToGive(double hpToGive) {
        this.hpToGive = hpToGive;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
