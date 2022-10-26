package simse.gui.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public final class JavaFXHelpers {

	public static Background createBackgroundColor(Color color) {
		return new Background(new BackgroundFill(color, null, null));
	}
	
	public static ImageView createImageView(String path) {
		ImageView img = null;
		try {
			img = new ImageView(new Image(new FileInputStream(path)));
		} catch (FileNotFoundException e) {
			System.out.println("Image not found at " + path);
		}
		return img;
	}
	
	public static Image createImage(String path) {
		Image img = null;
		try {
			img = new Image(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			System.out.println("Image not found at " + path);
		}
		return img;
	}
}
