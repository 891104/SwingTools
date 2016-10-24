package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Frame extends JFrame
{

	private JPanel buttonPanel;
	private JMenuBar menuBar;
	
	public Frame()
	{
		buttonPanel = new JPanel();
		menuBar = new JMenuBar();
		setSize(300,200);
		setTitle("Background color");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		add(buttonPanel,BorderLayout.SOUTH);
		setJMenuBar(menuBar);
		addMenu();
		//setBackground(Color.GRAY);
		
		makeButton("Yellow", Color.YELLOW);
		makeButton("Blue", Color.BLUE);
		makeButton("Red", Color.RED);
		
	}
	
	
	public void makeButton(String name, Color c)
	{
		JButton button = new JButton(name);
		buttonPanel.add(button);
		Actions action = new Actions(c);
		button.addActionListener(action);
	}
	
	public void addMenu()
	{
		JMenu menu = new JMenu("Menu glowne");
		menuBar.add(menu);
		
		JMenuItem item = new JMenuItem("Test");
		menu.add(item);
		JMenuItem close = new JMenuItem("Zamknij");
		close.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		menu.add(close);
	}
	
	
	class Actions implements ActionListener
	{

		private Color bgColor;
		
		public Actions(Color bgColor) {
			this.bgColor = bgColor;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			
			buttonPanel.setBackground(bgColor);
		}
		
	}
	
}
