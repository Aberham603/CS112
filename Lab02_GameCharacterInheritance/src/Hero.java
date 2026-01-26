import java.util.Objects;
import java.util.Random;

public class Hero extends GameCharacter
{
    public Hero(String name, int level)
    {
        super(name, level);
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

    public void perish()
    {
        System.out.println("All is lost, our hero has perished!");
    }
}
