import java.text.NumberFormat;
import java.util.Objects;

public class EnergyDrink extends CaffeinatedBeverage
{
    private String flavor;

    public EnergyDrink(String name, int ounces, double price, String flavor)
    {
        super(name, ounces, price);
        this.flavor = flavor;
    }

    public String getFlavor()
    {
        return flavor;
    }

    public void setFlavor(String flavor)
    {
        this.flavor = flavor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EnergyDrink that = (EnergyDrink) o;
        return Objects.equals(flavor, that.flavor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flavor);
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "EnergyDrink:" +
                name + ", " +
                ounces + ", " +
                flavor + ", " +
                currency.format(price);
    }
}
