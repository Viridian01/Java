package enemies;

import java.util.Random;

import player.Player;

public class Enemy {

	public Enemy(String name, float maxHealth, float attackPower, int hitChance, int critChance, float critMult)
	{
		this.name = name;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.attackPower = attackPower;
		this.hitChance = hitChance;
		this.critChance = critChance;
		this.critMult = critMult;
	}

	public String name = "Default Enemy";

	public float health;
	public float maxHealth = 80F;

	public float attackPower = 10F;
	public int hitChance = 80;
	public int critChance = 5;
	public float critMult = 2F;

	public void tryAttack(Player target)
	{
		System.out.println(name + " tries to attack " + target.name);
		Random chanceGen = new Random();
		int returnedChance = chanceGen.nextInt(100 + 1);
		if (returnedChance <= critChance)
		{
			target.health -= attackPower * critMult;
			System.out.println(name + " does a critical attack!");
			System.out.println(name + " did " + (attackPower * critMult) + " damage to " + target.name);
		}
		else if (returnedChance <= hitChance)
		{
			target.health -= attackPower;
			System.out.println(name + " did " + attackPower + " damage to " + target.name);
		}
		else 
		{
			System.out.println(name + "'s attack missed!");
		}
	}
}
