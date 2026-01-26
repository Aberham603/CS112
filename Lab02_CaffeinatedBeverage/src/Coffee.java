import java.text.NumberFormat;
import java.util.Objects;

public class Coffee extends CaffeinatedBeverage
{
    private int roastType;

    public Coffee(String name, int ounces, double price, int roastType)
    {
        super(name, ounces, price);
        this.roastType = roastType;
    }

    public int getRoastType()
    {
        return roastType;
    }

    public void setRoastType(int roastType)
    {
        this.roastType = roastType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coffee that = (Coffee) o;
        return ounces == that.ounces && Double.compare(price, that.price) == 0
                && Objects.equals(name, that.name) && roastType == that.roastType;
    }

    @Override
    public String toString() {
        // Pre-built format in Java for currency (with , separators);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        String roast;
        if (roastType == 1)
            roast = "light roast";
        else if(roastType == 2)
            roast = "medium roast";
        else
            roast = "dark roast";

        return "Coffee: " + name + ", " + ounces + " ounces, " +
                roast + ", " + currency.format(price);
        /*
        My attempt before watching the video.

        switch (roastType)
        {
            case 1:
                return "Coffee: " + name +
                        ", " + ounces +
                        "Blonde, " +
                        "$" + price;
            case 2:
                return "Coffee: " + name +
                        ", " + ounces +
                        "Colombian, " +
                        "$" + price;
            case 3:
                return "Coffee: " + name +
                        ", " + ounces +
                        "Kenyan, " +
                        currency.format(price);
        }
        return "";
         */
    }
}
