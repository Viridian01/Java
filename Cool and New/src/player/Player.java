package player;

import java.util.Random;

import enemies.Enemy;
import weapons.Weapon;

public class Player 
{
	public Player()
	{
		health = maxHealth;
	}
	public String name = "Default Name";

	public float maxHealth = 100F;
	public float health;

	public Weapon equippedWeapon;
	public float attackPower = 5F;
	public int hitChance = 80;
	public int critChance = 10;
	public float critMult = 2F;

	public void equipWeapon(Weapon weaponToEquip)
	{
		equippedWeapon = weaponToEquip;
		attackPower += weaponToEquip.attackPower;
		hitChance += weaponToEquip.attackChanceBonus;
		critChance += weaponToEquip.critChanceBonus;
		critMult = weaponToEquip.critMult;

		System.out.println("You equipped: " + weaponToEquip.name);
		weaponToEquip.readStats();
	}

	public void tryAttack(Enemy target)
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
