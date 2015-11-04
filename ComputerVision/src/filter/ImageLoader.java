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
	
	public int[][] imageToMatrix() throws IOException{
		
		BufferedImage bufferedImage = ImageIO.read(new File(filename));
		
		int height = bufferedImage.getHeight();
		int width = bufferedImage.getWidth();
				
				
		int[][] matrix = new int[height][width];
		
		
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = bufferedImage.getRGB(i, j);
			}
		}		
		
		return matrix;
		
	}
	
}
