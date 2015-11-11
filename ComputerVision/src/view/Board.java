package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import filter.Utils;
import model.Editor;

public class Board extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Editor editor;

	public Board(Editor editor) {
		this.editor = editor;
		editor.addObserver(this);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics a) {
		super.paintComponent(a);

		BufferedImage img = Utils.matrixToBuffered(editor.getImage());
		JLayeredPane EverythingButPlayer = new JLayeredPane();
		a.drawImage(img, this.getWidth() / 2 - img.getWidth() / 2, this.getHeight() / 2 - img.getHeight() / 2,
				EverythingButPlayer);
		// System.out.println(img.getRGB(0 , 0));
	}

	@Override
	public void update(Observable o, Object a) {
		repaint();
	}

}