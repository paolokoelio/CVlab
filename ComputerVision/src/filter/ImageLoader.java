package filter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	private String filename;

	public ImageLoader(String filename) {
		super();
		this.filename = filename;
	}

	public int[][] imageToMatrix() throws IOException {

		BufferedImage bufferedImage = ImageIO.read(new File(filename));

		int height = bufferedImage.getHeight();
		int width = bufferedImage.getWidth();

		System.out.println(height + " " + width);

		int[][] matrix = new int[height][width];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.println(j + " " + i);
				matrix[i][j] = bufferedImage.getRGB(j, i);
			}
		}

		return matrix;

	}

}
