import java.util.Objects;
import java.util.Random;

public class GameCharacter
{
    /*Object-Oriented Programming
    1. Fields (instance variables) - properties/chaarcteristics of each object.
        All fields have private access modifier
        private - only the class itself has access to the data
    * */

    protected String name;
    protected int level;
    protected int healthPoints;
    protected int gold;
    protected int magic;

    /* Methods - Actions/Behaviors of Each Object
        Automatically generate constructor, getters/setters, toString
     */

    public GameCharacter(String name, int level)
    {
        this.name = name;
        this.level = level;
        this.healthPoints = 100 * level;
        this.gold = 100 * level;
        this.magic = 100 * level;
    }

    public String getName()
    {
        return name;
    }

    public int getLevel()
    {
        return level;
    }

    public int getHealthPoints()
    {
        return healthPoints;
    }

    public int getGold()
    {
        return gold;
    }

    public int getMagic()
    {
        return magic;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // toString - converts our object into a String for display

    @Override
    public String toString() {
        return "GameCharacter{" +
                "Name='" + name + '\'' +
                ", Level=" + level +
                ", Health Points=" + healthPoints +
                ", Gold=" + gold +
                ", Magic=" + magic +
                '}';
    }

    // Attack method: one GameCharacter attacks other GameCharacter
    public void attack(GameCharacter other)
    {
        System.out.println(getName() + " does not attack. I am peaceful!");
    }

    // rest only involves one object (this)
    public void rest()
    {
        System.out.println(getName() + " never rests!");
    }

    // assist method which aids GameCharacter in combat
    public void assist(GameCharacter other)
    {
        System.out.println(getName() + " cannot assist.");

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameCharacter that = (GameCharacter) o;
        return level == that.level && healthPoints == that.healthPoints && gold == that.gold && magic == that.magic && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, healthPoints, gold, magic);
    }
}