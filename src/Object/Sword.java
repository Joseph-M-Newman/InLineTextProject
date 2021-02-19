package Object;

public class Sword {
    String name;
    int TotalCount;
    double damage;

    public Sword(String name, int totalamount, int damage){
        this.name = name;
        this.TotalCount = totalamount;
        this.damage = damage;

    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }
}
