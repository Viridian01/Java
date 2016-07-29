package managers;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class OutputManager extends OutputStream{

	public OutputManager(JTextArea textArea) 
	{
		this.textArea = textArea;
	}

	private JTextArea textArea;

	@Override
	public void write(int b) throws IOException
	{
		textArea.append(String.valueOf((char)b));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}
