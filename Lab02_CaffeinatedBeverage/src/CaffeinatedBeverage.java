import java.util.Objects;

public abstract class CaffeinatedBeverage
{
    protected String name;
    protected int ounces;
    protected double price;

    public CaffeinatedBeverage(String name, int ounces, double price)
    {
        this.name = name;
        this.ounces = ounces;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return ounces == that.ounces && Double.compare(price, that.price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ounces, price);
    }
}
