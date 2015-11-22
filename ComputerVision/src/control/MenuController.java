package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import filter.Utils;
import model.Editor;
import view.MenuBar;

public class MenuController {

	private Editor editor;
	private MenuBar bar;
	private JTextArea history;

	public MenuController(Editor editor, MenuBar bar, JTextArea history) {
		super();
		this.editor = editor;
		this.bar = bar;
		this.history = history;
	}

	public void setListeners() {

		bar.getOpen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = Utils.selectOpenFile(bar.getBar());
				if (!file.equals("")) {
					editor.openImage(file);
					history.append("Opened image " + file + "\n");
				}
			}
		});

		bar.getSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = Utils.selectSaveFile(bar.getBar());
				if (!file.equals("")) {
					editor.saveImage(file);
					history.append("Saved image " + file + "\n");
				}
			}
		});
		
	}

}