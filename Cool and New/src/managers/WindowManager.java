package managers;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import player.Player;

public class WindowManager extends JFrame implements ActionListener{

	JTextField playerName;
	JButton submit;

	Player player;

	public WindowManager(String title, Player playerToUtilize)
	{
		super(title);
		this.player = playerToUtilize;

		this.init();
		this.setSize(650, 450);
		this.setVisible(true);
		this.AskForName();
	}
	
	//Character Info
	JTextField charName = new JTextField();
	JTextField charHealth = new JTextField();
	JTextField charWeapon = new JTextField();
	JTextField charAttackPower = new JTextField();
	JTextField charHitChance = new JTextField();
	JTextField charCritChance = new JTextField();
	JTextField charCritMult = new JTextField();
	
	
	void init()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Text Panel
		JTextArea textArea = new JTextArea();
		PrintStream printStream = new PrintStream(new OutputManager(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		textArea.setEditable(false);
		textArea.setBorder(BorderFactory.createTitledBorder("Adventure Log"));

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
		this.add(textArea);
		
//		//Character Info Panel
//		JPanel charInfoPanel = new JPanel(new GridLayout(7, 1));
//		
//		charName.setText(player.name);
//		charHealth.setText(player.health + "/" + player.maxHealth);
//		charWeapon.setText(player.equippedWeapon.name);
//		charAttackPower.setText(Float.toString(player.attackPower));
//		charHitChance.setText(Integer.toString(player.hitChance) + "%");
//		charCritChance.setText(Integer.toString(player.critChance) + "%");
//		charCritMult.setText(Float.toString(player.critMult) + "x");
//		charInfoPanel.add(charName);
//		charInfoPanel.add(charHealth);
//		charInfoPanel.add(charWeapon);
//		charInfoPanel.add(charAttackPower);
//		charInfoPanel.add(charHitChance);
//		charInfoPanel.add(charCritChance);
//		charInfoPanel.add(charCritMult);
//		c.anchor = GridBagConstraints.LINE_START;
//		c.gridx = 0;
//		c.gridy = 0;
//		
//		JLabel test = new JLabel("Check");
//		charInfoPanel.add(test);
//		this.add(charInfoPanel, c);
		System.out.println("Check.");
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == submit)
		{

		}
	}

	void AskForName() 
	{
		String inputName = JOptionPane.showInputDialog(this, "Player Name: ", "wut is ur name");
		if (inputName != null)
		{
			int response = JOptionPane.showConfirmDialog(this, "Is the name: " + inputName + " alright?", "your name suks lol", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION)
			{
				player.name = inputName;
				JOptionPane.showMessageDialog(this, "Your Player name is: " + player.name);
			}
			else if (response == JOptionPane.NO_OPTION)
			{
				dispose();
			}
		}
	}
	
	public void UpdatePlayerInfo()
	{
		
	}

}
