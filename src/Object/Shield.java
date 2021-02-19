package Object;

public class Shield {
    String name;
    double blockDmg;
    int totalCount;
    public Shield(String name, double blockDmg, int totalCount){
        this.name = name;
        this.blockDmg = blockDmg;
        this.totalCount = totalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBlockDmg(double blockDmg) {
        this.blockDmg = blockDmg;
    }

    public double getBlockDmg() {
        return blockDmg;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
