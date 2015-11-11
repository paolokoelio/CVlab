package model;


import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

import filter.IFilter;
import filter.ImageLoader;
import filter.Utils;
import noise.INoise;

public class Editor extends Observable {
	public static final int INITIAL_SIZE = 1;
	public static final int INITIAL_COLOR = 255;

	private int[][] image;
	private IFilter filter;
	private INoise noise;

	private void update() {
		setChanged();
		notifyObservers();
	}

	public Editor() {
		super();
		image = new int[INITIAL_SIZE][INITIAL_SIZE];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				image[i][j] = Integer.MAX_VALUE;
			}
		}
		update();
	}

	public void openImage(String fileName) {
		ImageLoader matrix = new ImageLoader(fileName);
		try {
			image = matrix.imageToMatrix();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		update();
	}

	public void saveImage(String filename) {
		File outputfile = new File(filename);
		try {
			ImageIO.write(Utils.matrixToBuffered(image), "jpg", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setFilter(IFilter filter) {
		this.filter = filter;
	}
	
	public void setNoise(INoise noise) {
		this.noise = noise;
	}

	public void filter() {
		image = filter.addFilter(image);
		update();
	}

	public void noise(){
		image = noise.addNoise(image);
		update();
	}
	
	public int[][] getImage() {
		return image;
	}

}
