import java.io.Serializable;
import java.util.Objects;

public class Meat extends PaleoFood implements Serializable
{
    private int type; // 1 represents animal meat, 2 means seafood
    private int cookingTemp; // Farenheit,

    public Meat(String name, int calories, int type, int cookingTemp)
    {
        this.name = name;
        this.calories = calories;
        this.type = type;
        this.cookingTemp = cookingTemp;
        this.carbohydrates = 0; // Meat has 0 carbs
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public void setCookingTemp(int cookingTemp)
    {
        this.cookingTemp = cookingTemp;
    }

    public int getType()
    {
        return type;
    }

    public int getCookingTemp()
    {
        return cookingTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meat meat = (Meat) o;
        return type == meat.type && cookingTemp == meat.cookingTemp;
    }

    @Override
    public String toString()
    {
        String meatType;

        if(type == 1) // For meat
            meatType = "Meat";
        else // For seafood
        {
            meatType = "Seafood";
            cookingTemp = 0;
        }

        return meatType + ": " + name + ", " + calories + " calories, " + carbohydrates +
                "g carbs, " + cookingTemp + " degrees F";
    }
}
