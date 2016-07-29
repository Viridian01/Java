package weapons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Weapon {

	public Weapon()
	{

	}
	
	public Weapon(String name, float attackPower, int attackChanceBonus, int price, int critChanceBonus, float critMult)
	{
		this.name = name;
		this.attackPower = attackPower;
		this.attackChanceBonus = attackChanceBonus;
		this.price = price;
		this.critChanceBonus = critChanceBonus;
		this.critMult = critMult;
	}

	public String name = "Default Weapon";
	public float attackPower = 10F;
	public int attackChanceBonus;
	public int price;
	public int critChanceBonus;
	public float critMult;

	public ArrayList<Weapon> weaponList = new ArrayList<Weapon>();

	public void readStats()
	{
		System.out.println("+" + attackPower + " bonus to Attack.");
		System.out.println("+" + attackChanceBonus + "% bonus to Accuracy.");
		System.out.println("+" + critChanceBonus + "% bonus to Crit-Chance.");
		System.out.println(critMult + "x Crit-Multiplier.");
	}

	public void InitializeWeaponList()
	{
		try 
		{
			String path = new File("itemdata/WeaponList.txt").getPath();
			File file = new File(path);
			BufferedReader lengthReader = new BufferedReader(new FileReader(file));
			BufferedReader output = new BufferedReader(new FileReader(file));

			System.out.println("Found: " + file);

			int length = 0;
			//System.out.println(length);
			while (lengthReader.readLine() != null)
			{
				length++;
			}

			lengthReader.close();

			System.out.println(length);
			if (output.readLine() != null)
			{
				System.out.println(path + ": Able to read lines.");
				for(int i = 0; i < length/6; i++) 
				{
					String name = output.readLine();
					String attackPowerString = output.readLine();
					float attackPower = Float.parseFloat(attackPowerString);
					String attackChanceBonusString = output.readLine();
					int attackChanceBonus = Integer.parseInt(attackChanceBonusString);
					String priceString = output.readLine();
					int price = Integer.parseInt(priceString);
					String critChanceBonusString = output.readLine();
					int critChanceBonus = Integer.parseInt(critChanceBonusString);
					String critMultString = output.readLine();
					float critMult = Float.parseFloat(critMultString);
					weaponList.add(new Weapon(name, attackPower, attackChanceBonus, price, critChanceBonus, critMult));
					System.out.println("Added: " + name);
				}
			}
			else
			{
				System.out.println(path + ": Unable to read lines.");
			}
			output.close();
		}
		catch ( IOException e ) 
		{
			System.out.println( "File doesn't exist !" );
		}
	}

	public Weapon wep(String weaponToGet)
	{
		for (int i = 0; i <= weaponList.size(); i++)
		{
			if (weaponToGet.equalsIgnoreCase(weaponList.get(i).name))
			{
				return weaponList.get(i);
			}
		}
		Weapon dummy = new Weapon("Dummy", 0, 0, 0, 0, 0);
		return dummy;
	}
}
