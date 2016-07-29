import java.util.Scanner;

import enemies.Enemy;
import managers.FrameManager;
import managers.ShopManager;
import managers.StrifeManager;
import player.Player;
import weapons.Weapon;

public class CoolNew {

	public static void main(String[] args) 
	{
		StrifeManager strife = new StrifeManager();
		ShopManager shop = new ShopManager("Debug Shop");
		Player player = new Player();
		Weapon wep = new Weapon();
		Enemy shaleImp = new Enemy("Shale Imp", 80F, 10F, 80, 5, 2F);
		
		//Initialization of Weapon Library
		System.out.println("Looting Armory...");
		wep.InitializeWeaponList();
		
		//Stock Shops
		System.out.println("Stocking Shops...");
		shop.wep = wep;
		shop.StockShop();
		
		
		//Interface Creation
		FrameManager win = new FrameManager("Main", player);
		
		boolean playingGame = true;
		
		Scanner playerInput = new Scanner(System.in);
		String playerCommand;

		strife.currentTurnHolder = player.name;
		strife.playerInput = playerInput;
		strife.playingGame = playingGame;
		strife.player = player;
		strife.win = win;
		
		shop.playerInput = playerInput;

		win.strife = strife;
		
		//Debug Start

		//Starting Parameters
		
		strife.currentEnemy = shaleImp;

		System.out.println("A " + shaleImp.name + " wants to Strife!\n");
		System.out.println("STRIFE!\n");
		
		player.equipWeapon(wep.wep("Sickle"));
		
		strife.InitiateStrife();

		//Running the game
		
		while(playingGame)
		{
			System.out.print("\n==> ");
			playerCommand = playerInput.nextLine();
			if (playerCommand.equalsIgnoreCase("view shop"))
			{
				shop.InitiateShop();
				System.out.println("Went to Shop.");
			}
			else if (playerCommand.equalsIgnoreCase("quit"))
			{
				playerInput.close();
				playingGame = false;
			}
		}

	}

}
