package test;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.MenuController;
import filter.Utils;
import model.Editor;
import view.Board;
import view.MenuBar;

public class UITest {

	public static void main(String[] args) {

		Editor editor = new Editor();

		JFrame frame = Utils.createFrame("Image Filtrator", 700, 1200);
		frame.setLayout(new BorderLayout());

		Board board = new Board(editor);
		frame.add(board, BorderLayout.WEST);

		JTextArea hist = new JTextArea();
		hist.setEditable(false);
		JScrollPane scroll = new JScrollPane(hist);
		frame.add(scroll, BorderLayout.SOUTH);

		MenuBar bar = new MenuBar();
		frame.setJMenuBar(bar.getBar());

		MenuController menuContr = new MenuController(editor, bar, hist);
		menuContr.setListeners();

		frame.getContentPane().add(board);
		frame.setVisible(true);
	}

}