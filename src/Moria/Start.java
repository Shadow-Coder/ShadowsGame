package Moria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JPanel implements ActionListener {
	
	protected JTextField textField;
	protected JTextArea textArea;
	protected JTextField textConsole;
	private final static String newline = "\n";
	private Engine e;
	
	private int fontSize = 14;
	
	public Start()
	{
		super(new GridBagLayout());
		
		textField = new JTextField(20);
		textField.setVisible(true);
		textField.addActionListener(this);
		
		Font font = new Font("Lucida Console", Font.PLAIN, fontSize);
		
		textArea = new JTextArea(5,20);
		textArea.setEditable(false);
		textArea.setFont(font);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(textField,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		this.add(scrollPane, c);
		
		textConsole = new JTextField(5);
		textConsole.setText("Starting Moria in Java!!!");
		this.add(textConsole, c);
		
		e = new Engine(20,10);
		this.printMap();
	}
	
	public static void main(String[] args)
	{		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				createAndShowGUI();
			}
		});
	}

	@Override
    public void actionPerformed(ActionEvent evt) 
	{
		String result = "";
		// THIS IS WHERE WE WILL CAPTURE USER INPUT AND PROCESS TURNS
		//
		
		// USER INPUT
		String input = this.textField.getText();
		
		if(input.equals("w"))
		{
			result = e.NextTurn("w");
		}
		
		this.textConsole.setText(result);
		
			
		
		
		this.printMap();		
    }
	
	private void printMap() 
	{
		textField.setText("");
        textArea.setText(e.GetStringMap());
        //textArea.append(text + newline);
        //textField.selectAll();
 
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	private static void createAndShowGUI()
	{
        //Create and set up the window.
        JFrame frame = new JFrame("Moria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new Start());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	

}
