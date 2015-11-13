package control;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton[] filters;
	private JButton[] noise;
	
	public ButtonPanel() {
		super();
		
		noise = new JButton[3];
		noise[0] = new JButton("Uniform");
		noise[1] = new JButton("Salt & Pepper");
		noise[2] = new JButton("Mixed Noise");
		for (int i = 0; i < noise.length; i++) {
			noise[i].setFont(new Font("Courier", Font.BOLD, 12));
		}

		
		
		filters = new JButton[11];
		filters[0] = new JButton("Box");
		filters[1] = new JButton("Sharpening");
		filters[2] = new JButton("Rank");
		filters[3] = new JButton("Sobel Module");
		filters[4] = new JButton("Sobel Phase");
		filters[5] = new JButton("Kirsh");
		filters[6] = new JButton("DoG");
		filters[7] = new JButton("3/9");
		filters[8] = new JButton("Nagao-Matsuyama");
		filters[9] = new JButton("Gaussian Blur");
		filters[10] = new JButton("Compass");

		for (int i = 0; i < filters.length; i++) {
			filters[i].setFont(new Font("Courier", Font.ITALIC, 12));
		}

		setLayout(new GridLayout(8,2));
		add(noise[0]);
		add(filters[0]);
		add(noise[1]);
		add(filters[1]);
		add(noise[2]);
		add(filters[2]);
		add(filters[3]);
		add(filters[4]);
		add(filters[5]);
		add(filters[6]);
		add(filters[7]);
		add(filters[8]);
		add(filters[9]);
		add(filters[10]);
	}

	public JButton[] getFilters() {
		return filters;
	}

	public JButton[] getNoise() {
		return noise;
	}
	
}
