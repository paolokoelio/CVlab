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

		menuNoise = new JMenu("Noises");
		itemsNoise = new JMenuItem[3];
		itemsNoise[0] = new JMenuItem("Uniform");
		menuNoise.add(itemsNoise[0]);
		itemsNoise[1] = new JMenuItem("Salt & Pepper");
		menuNoise.add(itemsNoise[1]);
		itemsNoise[2] = new JMenuItem("Mixed Noise");
		menuNoise.add(itemsNoise[2]);

		menuFilter = new JMenu("Filters");
		itemsFilter = new JMenuItem[9];
		itemsFilter[0] = new JMenuItem("Box");
		menuFilter.add(itemsFilter[0]);
		itemsFilter[1] = new JMenuItem("Sharpening");
		menuFilter.add(itemsFilter[1]);
		itemsFilter[2] = new JMenuItem("Rank");
		menuFilter.add(itemsFilter[2]);
		itemsFilter[3] = new JMenuItem("Sobel Module");
		menuFilter.add(itemsFilter[3]);
		itemsFilter[4] = new JMenuItem("Sobel Phase");
		menuFilter.add(itemsFilter[4]);
		itemsFilter[5] = new JMenuItem("Kirsh");
		menuFilter.add(itemsFilter[5]);
		itemsFilter[6] = new JMenuItem("DoG");
		menuFilter.add(itemsFilter[6]);
		itemsFilter[7] = new JMenuItem("3/9");
		menuFilter.add(itemsFilter[7]);
		itemsFilter[8] = new JMenuItem("Nagao-Matsuyama");
		menuFilter.add(itemsFilter[8]);

		bar.add(menuFile);
		menuFile.add(open);
		menuFile.add(save);

		bar.add(menuNoise);
		menuNoise.add(itemsNoise[0]);
		menuNoise.add(itemsNoise[1]);
		menuNoise.add(itemsNoise[2]);

		bar.add(menuFilter);
		menuFilter.add(itemsFilter[0]);
		menuFilter.add(itemsFilter[1]);
		menuFilter.add(itemsFilter[2]);
		menuFilter.add(itemsFilter[3]);
		menuFilter.add(itemsFilter[4]);
		menuFilter.add(itemsFilter[5]);
		menuFilter.add(itemsFilter[6]);
		menuFilter.add(itemsFilter[7]);
		menuFilter.add(itemsFilter[8]);

	}

	public JMenu getMenuFile() {
		return menuFile;
	}

	public JMenu getMenuNoise() {
		return menuNoise;
	}

	public JMenu getMenuFilter() {
		return menuFilter;
	}

	public JMenuItem getOpen() {
		return open;
	}

	public JMenuItem getSave() {
		return save;
	}

	public JMenuItem[] getItemsNoise() {
		return itemsNoise;
	}

	public JMenuItem[] getItemsFilter() {
		return itemsFilter;
	}

	public JMenuBar getBar() {
		return bar;
	}

}