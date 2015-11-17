package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import cleanNoise.Average;
import cleanNoise.Median;
import cleanNoise.Nagao;
import filter.BoxFilter;
import filter.Compass;
import filter.DogFilter;
import filter.GaussianBlur;
import filter.KirshFilter;
import filter.PrewittFilter;
import filter.RankFilter;
import filter.SharpeningFilter;
import filter.SobelFilter;
import filter.SobelPhaseFilter;
import filter.ThreeOnNineFilter;
import model.Editor;
import noise.MixedNoise;
import noise.SaltAndPepper;
import noise.UniformNoise;

public class ButtonsController {


	private Editor editor;
	private ButtonPanel bottoni;
	private JTextArea history;
	
	
	public ButtonsController(Editor editor, ButtonPanel bottoni, JTextArea history) {
		super();
		this.editor = editor;
		this.bottoni = bottoni;
		this.history = history;
	}
	
	public void setListeners(){
		

		bottoni.getNoise()[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "k";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the k value");
				String[] res = in.getResults();
				editor.setNoise(new UniformNoise(Integer.parseInt(res[0])));
				editor.noise();;
				history.append("Applied Uniform Noise with k = " + res[0]
						+ "\n");
			}
		});

		bottoni.getNoise()[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "lower";
				p[1] = "upper";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the bounds of the noise");
				String[] res = in.getResults();
				editor.setNoise(new SaltAndPepper(Double.parseDouble((res[0])), Double.parseDouble((res[1]))));

				editor.noise();
				history.append("Applied Salt&Pepper Noise with lower = " + res[0]
						+ " and upper = " + res[1] + "\n");
			}
		});

		bottoni.getNoise()[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[3];
				p[0] = "lower";
				p[1] = "upper";
				p[2] = "k";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the bounds of the noise and the constant k");
				String[] res = in.getResults();
				editor.setNoise(new MixedNoise(Double.parseDouble((res[0])), Double.parseDouble((res[1])),Integer.parseInt((res[2]))));
				editor.noise();
				history.append("Applied Mixed Noise with lower = " + res[0]
						+ ", upper = " + res[1] + " and k = " + res[2] + "\n");
			}
		});

		bottoni.getFilters()[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new BoxFilter());
				editor.filter();
				history.append("Applied Box Filter\n");

			}
		});

		bottoni.getFilters()[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SharpeningFilter());
				editor.filter();
				history.append("Applied Sharpening Filter\n");
			}
		});

		bottoni.getFilters()[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "w";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the window width");
				String[] res = in.getResults();
				editor.setFilter(new RankFilter(Integer.parseInt((res[0]))));
				editor.filter();
				history.append("Applied Rank Filter with w = " + res[0] + "\n");
			}
		});

		bottoni.getFilters()[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SobelFilter(editor.getImage()));
				editor.filter();
				history.append("Applied Sobel Module Filter\n");
			}
		});

		bottoni.getFilters()[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new SobelPhaseFilter());
				editor.filter();
				history.append("Applied Sobel Phase Filter\n");
			}
		});

		bottoni.getFilters()[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editor.setFilter(new KirshFilter());
				editor.filter();
				history.append("Applied Kirsh Filter\n");
			}
		});

		bottoni.getFilters()[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "σ1";
				p[1] = "σ2";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the two variances");
				String[] res = in.getResults();
				editor.setFilter(new DogFilter(Double.parseDouble((res[0])),
						Double.parseDouble((res[1]))));
				editor.filter();
				history.append("Applied DoG Filter with σ1 = " + res[0]
						+ " and σ2 = " + res[1] + "\n");
			}
		});

		bottoni.getFilters()[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[2];
				p[0] = "p";
				p[1] = "tau";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert p and tau");
				String[] res = in.getResults();
				editor.setFilter(new ThreeOnNineFilter(Double.parseDouble(res[0]), Double.parseDouble(res[1])));
				editor.filter();
				history.append("Applied Three on Nine Filter with p = "
						+ res[0] + " and tau = " + res[1] + "\n");
			}
		});

		bottoni.getFilters()[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				String[] p = new String[1];
//				p[0] = "s";
//				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
//						"Insert the size of the nagao kernel (odd number)");
//				String[] res = in.getResults();
				editor.setFilter(new Nagao());
				editor.filter();
				history.append("Applied Nagao Filter\n");
			}
		});
		
		bottoni.getFilters()[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "σ";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the value of σ");
				String[] res = in.getResults();
				editor.setFilter(new GaussianBlur(Double.parseDouble(res[0])));
				editor.filter();
				history.append("Applied Gaussian Blur with σ = "
						+ res[0] + "\n");
			}
		});
		
		bottoni.getFilters()[10].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				editor.setFilter(new Compass(editor.getImage()));
				editor.filter();
				history.append("Applied Compass\n");
			}
		});
		
		bottoni.getFilters()[11].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				editor.setFilter(new Average(editor.getImage()));
				editor.filter();
				history.append("Applied Average Denoise\n");
			}
		});
		
		bottoni.getFilters()[12].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] p = new String[1];
				p[0] = "n";
				JOptionPaneMultipleInput in = new JOptionPaneMultipleInput(p,
						"Insert the value of n");
				String[] res = in.getResults();
				
				editor.setFilter(new Median(Integer.parseInt(res[0])));
				editor.filter();
				history.append("Applied Median Denoise\n");
			}
		});
		
		bottoni.getFilters()[13].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				editor.setFilter(new PrewittFilter());
				editor.filter();
				history.append("Applied Prewitt Filter\n");
			}
		});
		
		
	}
	
}
