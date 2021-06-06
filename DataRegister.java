package examples.mlr;

public class DataRegister {
    private double x;
    private double x2;
    private double z;

    public DataRegister(double x, double x2, double z) {
        this.x = x;
        this.x2 = x2;
        this.z = z;
    }

    public double getX1() {
        return this.x;
    }

    public void setX1(double x) {
        this.x = x;
    }

    public double getX2() {
        return this.x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY() {
        return this.z;
    }

    public void setY(double z) {
        this.z = z;
    }
}

