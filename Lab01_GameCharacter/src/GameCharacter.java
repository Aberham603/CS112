import java.util.Objects;
import java.util.Random;

public class GameCharacter
{
    /*Object-Oriented Programming
    1. Fields (instance variables) - properties/chaarcteristics of each object.
        All fields have private access modifier
        private - only the class itself has access to the data
    * */

    private String name;
    private int level;
    private int healthPoints;
    private int gold;
    private int magic;

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
        // this - current object
        Random rng = new Random();

        // upper bound 10: range of random numbers will be 0 to 9
        int randomNumber = rng.nextInt(10);

        // Calculate damage by multiplying the random number by "this" character's level.
        int damage = randomNumber * this.level;

        // Deduct the damage from the other character's health points.
        other.healthPoints -= damage;

        // However, do not allow health points to go below zero.
        if(other.healthPoints < 0)
        {
            other.healthPoints = 0;
        }
    }

    // rest only involves one object (this)
    public void rest()
    {
        //this - one object
        // Both health points and magic go up by a random amount
        Random rng = new Random();
        int randomNumber = rng.nextInt(10);

        this.healthPoints += (level*randomNumber);
        this.magic += (level*randomNumber);
    }

    // assist method which aids GameCharacter in combat
    public void assist(GameCharacter other)
    {
        Random rng = new Random();

        // Generate random number from 0 to 4;
        int randomNumber = rng.nextInt(5);
        //System.out.println(randomNumber); Prints number for testing purposes.

        switch (randomNumber)
        {
            // if 0, other character receives (level * 5) health points, while "this" character loses (level * 5) magic
            case 0:
                other.healthPoints += (level * 5);
                this.magic -= (level * 5);
                break;
            //If 1, other character receives (level * 5) magic points, while "this" character loses (level * 5) magic.
            case 1:
                other.magic += (level * 5);
                this.magic -= (level * 5);
                break;
            //If 2, other character receives (level * 5) gold, while "this" character loses (level * 5) gold.
            case 2:
                other.gold += (level * 5);
                this.gold -= (level * 5);
                break;
            //If 3, other character's level increases by 1 (add 100 to gold, health points and magic), while "this" character loses a level (decrease 100 from gold, health points and magic).
            case 3:
                other.level++;
                other.gold += 100;
                other.healthPoints += 100;
                other.magic += 100;
                this.level--;
                this.gold -= 100;
                this.healthPoints -= 100;
                this.magic -= 100;
                break;
            //If 4, both characters' health is restored to (level * 100)
            case 4:
                other.healthPoints += (level * 100);
                this.healthPoints += (level * 100);
                break;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameCharacter that = (GameCharacter) o;
        return level == that.level && healthPoints == that.healthPoints && gold == that.gold && magic == that.magic && Objects.equals(name, that.name);
    }

}
