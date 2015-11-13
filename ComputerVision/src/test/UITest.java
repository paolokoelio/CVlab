package test;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.ButtonPanel;
import control.ButtonsController;
import control.MenuController;
import filter.Utils;
import model.Editor;
import view.Board;
import view.MenuBar;

public class UITest {

	public static void main(String[] args) {

		Editor editor = new Editor();

		JFrame frame = Utils.createFrame("Image Filtrator", 700, 1200);
//		frame.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.add(panel);
		
		ButtonPanel butt = new ButtonPanel();
		panel.add(butt, BorderLayout.WEST);
		
		Board board = new Board(editor);
		panel.add(board, BorderLayout.CENTER);

		JTextArea hist = new JTextArea();
		hist.setEditable(false);
		JScrollPane scroll = new JScrollPane(hist);
		scroll.setPreferredSize(new Dimension(1200, 100));
		frame.add(scroll, BorderLayout.PAGE_END);

		MenuBar bar = new MenuBar();
		frame.setJMenuBar(bar.getBar());

		MenuController menuContr = new MenuController(editor, bar, hist);
		menuContr.setListeners();
		

		ButtonsController buttContr = new ButtonsController(editor, butt, hist);
		buttContr.setListeners();
		


		frame.getContentPane().add(panel);
		frame.setVisible(true);

	}

}