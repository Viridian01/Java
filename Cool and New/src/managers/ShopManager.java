package managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import player.Player;
import weapons.Weapon;

public class ShopManager {

	public boolean inShop;
	public Scanner playerInput;
	public Player player;
	public Weapon wep;

	public String name;

	public ArrayList<Weapon> shopStock = new ArrayList<Weapon>();

	public ShopManager(String name)
	{
		this.name = name;
	}

	public void InitiateShop()
	{
		inShop = true;
		System.out.println("Hello, and welcome to: " + name + ". Is there anything I can interest you in?");
		while (inShop)
		{
			System.out.print("==> ");
			String playerCommand = playerInput.nextLine();

			if (playerCommand.equalsIgnoreCase("for sale"))
			{
				ListStock();
			}
			else if (playerCommand.equalsIgnoreCase("quit"))
			{
				inShop = false;
				System.out.println("Left the shop.");
			}
		}
	}

	void ListStock()
	{
		for (int i = 0; i < shopStock.size(); i++)
		{
			System.out.println(shopStock.get(i).name + " - " + shopStock.get(i).price);
		}
	}

	public void StockShop()
	{
		try 
		{
			String path = new File("itemdata/shops/" + name + ".txt").getPath();
			File file = new File(path);
			BufferedReader output = new BufferedReader(new FileReader(file));

			System.out.println("Found: " + file);

			String readLine = output.readLine();

			if (readLine != null)
			{
				System.out.println(path + ": Able to read lines.");
				while (readLine != null)
				{
					if (wep.wep(readLine).name.equals(readLine))
					{
						shopStock.add(wep.wep(readLine));
						System.out.println("Added: " + readLine + " to shop: " + name);
					}
					else
					{
						System.out.println("Couldn't add: " + readLine + " to shop: " + name);
					}
					readLine = output.readLine();
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
}