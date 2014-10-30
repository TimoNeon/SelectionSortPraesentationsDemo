package app;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DemoFrame {
	public static final Dimension FRAME_SIZE = new Dimension(800, 600);
	
	JFrame _frame;
	JMenuBar _menuBar;
	JMenu _fileMenu;
	JMenuItem _newItem;
	
	DrawPane _drawer;
	
	public DemoFrame() {
		_frame = new JFrame("Selectionsort Präsentations Demo");
		_drawer = new DrawPane();
		_menuBar = new JMenuBar();
		_fileMenu = new JMenu("File");
		_newItem = new JMenuItem("new..");
		
		_fileMenu.add(_newItem);
		_menuBar.add(_fileMenu);
		
		_frame.setSize(FRAME_SIZE);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setLocationRelativeTo(null);
		_frame.setJMenuBar(_menuBar);
		_frame.add(_drawer);
		
		_frame.setVisible(true);
	}
	
	private class DrawPane extends JPanel{
		private int x, y, width, height;
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			refreshBound();
			
			g.fillRect(x, y, width, height);
		}
		
		private void refreshBound(){
			x=getX();
			y=getY();
			width=getWidth();
			height=getHeight();
		}
	}
}
