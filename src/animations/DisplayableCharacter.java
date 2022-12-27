package animations;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class DisplayableCharacter extends Group{
	
	private SimSESprite displayedCharacter;
	protected int velocity, height, width;
	private double previousX, previousY;
	private PathTransition transition;
	private Path pathToFollow;
	protected ArrayList<SimSESprite> animationList;
	
	public DisplayableCharacter(Path pathToFollow, int width, int height) {	
		this.velocity = 2;
		this.pathToFollow = pathToFollow;
		this.height = height;
		this.width = width;
		this.directionCheck();
		animationList = new ArrayList<>();
		initalizeAnimationList();
		displayedCharacter = animationList.get(0);
		displayedCharacter.setFitHeight(height);
		displayedCharacter.setFitWidth(width);
		this.getChildren().add(displayedCharacter);
		displayedCharacter.startAnim();
		
		this.beginPathing();
	}
	
	public void updateAnimationListLocation(double x, double y) {
		for(SimSESprite sprite : animationList) {
			sprite.setX(x);
			sprite.setY(y);
		}
	}
	
	public void updateDisplayedCharacter() {
		displayedCharacter.setFitHeight(height);
		displayedCharacter.setFitWidth(width);
		this.getChildren().setAll(displayedCharacter);
	}
	
	public void beginPathing() {
		this.transition = new PathTransition();
		transition.setNode(this);
		transition.setDuration(Duration.seconds(16));
		transition.setPath(pathToFollow);
		transition.setCycleCount(PathTransition.INDEFINITE);
		transition.play();
	}
	
	public void directionCheck(){
		
		Timeline directionTimer = new Timeline(
                new KeyFrame(Duration.seconds(0.1), 
                new EventHandler<ActionEvent>() {

	   @Override
	   public void handle(ActionEvent event) {
		   
           Point2D pointOfSprite = displayedCharacter.localToParent(getTranslateX(), getTranslateY());

		   
		   double currentX = pointOfSprite.getX();
		   double currentY = pointOfSprite.getY();
		   
		   //Right Anim
		   if(currentX > previousX && currentY == previousY) {
			   displayedCharacter = animationList.get(4);
		   }
		   
		   //Left Anim
		   if(currentX < previousX && currentY == previousY) {
			   displayedCharacter = animationList.get(3);
		   }
		   
		   //Down Anim
		   if(currentX == previousX && currentY > previousY) {
			   displayedCharacter = animationList.get(1);
		   }
		   
		   //Up Anim
		   if(currentX == previousX && currentY < previousY) {
			   displayedCharacter = animationList.get(2);
		   }
		   
		   pointOfSprite = displayedCharacter.localToParent(getTranslateX(), getTranslateY());
		   previousX = pointOfSprite.getX();
		   previousY = pointOfSprite.getY();
		   		   
 		   displayedCharacter.startAnim();
 		   updateDisplayedCharacter();	   
		   
		   
	   }
		}));
		directionTimer.setCycleCount(Timeline.INDEFINITE);
		directionTimer.play();
	}
	
	
	abstract void initalizeAnimationList();

}
