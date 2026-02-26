import java.io.Serializable;
import java.util.Objects;

public class Produce extends PaleoFood implements Serializable
{
    private boolean organic; // True = Organic Produce, False = Non-Organic

    public Produce(String name, int calories, int carbohydrates, boolean organic)
    {
        this.name = name;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.organic = organic;
    }

    public void setOrganic(boolean organic)
    {
        this.organic = organic;
    }

    public boolean isOrganic()
    {
        return organic;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Produce produce = (Produce) o;
        return organic == produce.organic;
    }

    @Override
    public String toString()
    {
        String organic = (isOrganic()) ? "Organic Produce" : "Produce";

        return organic + ": " + name + ", " + calories + ", " + carbohydrates +
                "g carbs";
    }
}
