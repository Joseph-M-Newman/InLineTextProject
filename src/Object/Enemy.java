package Object;

public class Enemy {
    double health;
    double baseMelee;
    double baseDefense;
    double baseMage;

    public Enemy(){
        this.health = 10;
        this.baseMelee = 3;
        this.baseMage = 1;
        this.baseDefense = 1;
    }

    public Enemy(double health, double baseMelee, double baseDefense, double baseMage) {
        this.health = health;
        this.baseMelee = baseMelee;
        this.baseDefense = baseDefense;
        this.baseMage = baseMage;
    }
    //----------- getters and setters -----------
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getBaseMelee() {
        return baseMelee;
    }

    public void setBaseMelee(double baseMelee) {
        this.baseMelee = baseMelee;
    }

    public double getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(double baseDefense) {
        this.baseDefense = baseDefense;
    }

    public double getBaseMage() {
        return baseMage;
    }

    public void setBaseMage(double baseMage) {
        this.baseMage = baseMage;
    }
    //----------- getters and setters -----------

    //dmg calcuations
    public void takeDamage(double damage){
        this.health -= damage;
    }

    public void AttackTarget(Enemy e){

    }
}
