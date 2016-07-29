package managers;

import java.util.Scanner;

import enemies.Enemy;
import player.Player;

public class StrifeManager {

	public boolean inStrife;
	public String currentTurnHolder;
	public Scanner playerInput;
	public boolean playingGame;
	public Player player;
	public Enemy currentEnemy;
	public FrameManager win;

	public void InitiateStrife()
	{
		inStrife = true;
		while (inStrife)
		{
			win.UpdateChar();

			//Player's Commands
			if (currentTurnHolder.equals(player.name))
			{
				//System.out.println("Player HP: (" + player.health + "/" + player.maxHealth + ")");
				//System.out.println("Enemy HP: (" + currentEnemy.health + "/" + currentEnemy.maxHealth + ")");
				
				win.aggrieveButton.setEnabled(true);
				
//				System.out.print("==> ");
//				String playerCommand = playerInput.next();
//
//				if (playerCommand.equalsIgnoreCase("attack"))
//				{
//					player.tryAttack(currentEnemy);
//					currentTurnHolder = currentEnemy.name;
//				}
//				else if (playerCommand.equalsIgnoreCase("quit"))
//				{
//					playerInput.close();
//					playingGame = false;
//				}
			}

			//Enemy's Commands
			else if (currentTurnHolder.equals(currentEnemy.name) && inStrife)
			{
				win.aggrieveButton.setEnabled(false);
				currentEnemy.tryAttack(player);
				currentTurnHolder = player.name;
			}
			if (currentEnemy.health <= 0)
			{
				System.out.println("You won against: " + currentEnemy.name + ".");
				inStrife = false;
			}
		}
	}

}
