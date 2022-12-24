package animations;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public abstract class DisplayableCharacter extends Group{
	
	private SimSESprite displayedCharacter;
	protected int velocity;
	protected ArrayList<SimSESprite> animationList;
	
	public DisplayableCharacter() {
		this.velocity = 2;
		animationList = new ArrayList<>();
		initalizeAnimationList();
		displayedCharacter = animationList.get(0);
		this.getChildren().add(displayedCharacter);
		displayedCharacter.startAnim();
        this.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
            	displayedCharacter = animationList.get(3);
            	displayedCharacter.setX(displayedCharacter.getX() - velocity);
            }
            if (e.getCode() == KeyCode.RIGHT) {
            	displayedCharacter = animationList.get(4);
            	displayedCharacter.setX(displayedCharacter.getX() + velocity);
            }
            if (e.getCode() == KeyCode.UP) {
            	displayedCharacter = animationList.get(2);
            	displayedCharacter.setY(displayedCharacter.getY() - velocity);
            }
            if (e.getCode() == KeyCode.DOWN) {
            	displayedCharacter = animationList.get(1);
            	displayedCharacter.setY(displayedCharacter.getY() + velocity);
            }
            this.updateAnimationListLocation(displayedCharacter.getX(), displayedCharacter.getY());
    		displayedCharacter.startAnim();
    		this.getChildren().setAll(displayedCharacter);
        });
		this.setFocusTraversable(true);
	}
	
	public void updateAnimationListLocation(double x, double y) {
		for(SimSESprite sprite : animationList) {
			sprite.setX(x);
			sprite.setY(y);
		}
	}
	
	
	abstract void initalizeAnimationList();

}
