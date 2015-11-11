package control;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JOptionPaneMultipleInput {
	private String question;
	private String[] params;
	private JTextField[] fields;
	private JPanel myPanel = new JPanel();

	public JOptionPaneMultipleInput(String[] params, String question) {
		super();
		this.params = params;
		this.question = question;
		fields = new JTextField[params.length];

		for (int i = 0; i < params.length; i++) {
			myPanel.add(new JLabel(params[i]));
			fields[i] = new JTextField(5);
			myPanel.add(fields[i]);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		}
	}

	public String[] getResults() {
		int result = JOptionPane.showConfirmDialog(null, myPanel, question, JOptionPane.DEFAULT_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			String[] res = new String[params.length];
			for (int i = 0; i < res.length; i++) {
				res[i] = fields[i].getText();
			}
			return res;
		}
		return null;
	}
}