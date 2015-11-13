package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {

	private JMenuBar bar;
	private JMenu menuFile, menuNoise, menuFilter;
	private JMenuItem open, save;
	private JMenuItem[] itemsNoise, itemsFilter;

	public MenuBar() {
		super();

		bar = new JMenuBar();

		menuFile = new JMenu("File");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");


		bar.add(menuFile);
		menuFile.add(open);
		menuFile.add(save);

	}

	public JMenu getMenuFile() {
		return menuFile;
	}

	

	public JMenuItem getOpen() {
		return open;
	}

	public JMenuItem getSave() {
		return save;
	}

	
	public JMenuBar getBar() {
		return bar;
	}

}