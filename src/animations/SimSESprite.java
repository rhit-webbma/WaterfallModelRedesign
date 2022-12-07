package animations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

abstract class SimSESprite extends ImageView{

	Animation spriteAnimation;
	private int speed;
	
	public SimSESprite(
			int spriteSheetColumns,
			int spriteSheetCount,
			int offsetX,
			int offsetY,
			int width,
			int height,
			String url) {
		this.speed = 1000;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(url);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Image image = new Image(inputStream);
        
//        spriteImage = new ImageView();
        this.setImage(image);
        this.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        spriteAnimation = new SpriteAnimation(
        		this,
                Duration.millis(speed),
                spriteSheetCount, spriteSheetColumns,
                offsetX, offsetY,
                width, height
        );
	}
	
	
	public void startAnim() {
        spriteAnimation.setCycleCount(Animation.INDEFINITE);
        spriteAnimation.play();
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setHeight(double value) {
		this.setFitHeight(value);
	}
	
	public void setWidth(double value) {
		this.setFitWidth(value);
	}
}
