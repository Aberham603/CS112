import java.io.Serializable;
import java.util.Objects;

public abstract class PaleoFood implements Serializable
{
    protected String name;
    protected int calories, carbohydrates;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public void setCarbohydrates(int carbohydrates)
    {
        this.carbohydrates = carbohydrates;
    }

    public String getName()
    {
        return name;
    }

    public int getCalories()
    {
        return calories;
    }

    public int getCarbohydrates()
    {
        return carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PaleoFood paleoFood = (PaleoFood) o;
        return calories == paleoFood.calories && carbohydrates == paleoFood.carbohydrates && Objects.equals(name, paleoFood.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories, carbohydrates);
    }
}
