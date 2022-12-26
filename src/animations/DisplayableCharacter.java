package animations;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public abstract class DisplayableCharacter extends Group{
	
	private SimSESprite displayedCharacter;
	protected int velocity;
	private double previousX, previousY;
	private PathTransition transition;
	protected ArrayList<SimSESprite> animationList;
	
	public DisplayableCharacter() {	
		this.velocity = 2;

		this.directionCheck();
		animationList = new ArrayList<>();
		initalizeAnimationList();
		displayedCharacter = animationList.get(0);
		this.getChildren().add(displayedCharacter);
		displayedCharacter.startAnim();
		
		this.beginPathing();
		
//        this.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.LEFT) {
//            	displayedCharacter = animationList.get(3);
//            	displayedCharacter.setX(displayedCharacter.getX() - velocity);
//            }
//            if (e.getCode() == KeyCode.RIGHT) {
//            	displayedCharacter = animationList.get(4);
//            	displayedCharacter.setX(displayedCharacter.getX() + velocity);
//            }
//            if (e.getCode() == KeyCode.UP) {
//            	displayedCharacter = animationList.get(2);
//            	displayedCharacter.setY(displayedCharacter.getY() - velocity);
//            }
//            if (e.getCode() == KeyCode.DOWN) {
//            	displayedCharacter = animationList.get(1);
//            	displayedCharacter.setY(displayedCharacter.getY() + velocity);
//            }
//            this.updateAnimationListLocation(displayedCharacter.getX(), displayedCharacter.getY());
//    		displayedCharacter.startAnim();
//    		this.getChildren().setAll(displayedCharacter);
//        });
	}
	
	public void updateAnimationListLocation(double x, double y) {
		for(SimSESprite sprite : animationList) {
			sprite.setX(x);
			sprite.setY(y);
		}
	}
	
	public void updateDisplayedCharacter() {
		this.getChildren().setAll(displayedCharacter);
	}
	
	public void beginPathing() {
//		Polyline newLine = new Polyline();
//		newLine.getPoints().addAll(new Double[] {
//				0.0, 0.0,
//				100.0, 0.0,
//				500.0, 0.0,
//				0.0, 0.0
//		});
		
        Path path = new Path();
        path.getElements().add(new MoveTo(50.0, 50.0));
        path.getElements().add(new LineTo(200.0, 50.0));
        path.getElements().add(new LineTo(200.0, 200.0));
        path.getElements().add(new LineTo(50.0, 200.0));
        path.getElements().add(new LineTo(50.0, 50.0));
		
		this.transition = new PathTransition();
		transition.setNode(this);
		transition.setDuration(Duration.seconds(10));
		transition.setPath(path);
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
//
		   pointOfSprite = displayedCharacter.localToParent(getTranslateX(), getTranslateY());
		   previousX = pointOfSprite.getX();
		   previousY = pointOfSprite.getY();
		   		   
//		   updateAnimationListLocation(translateX, translateY);
 		   displayedCharacter.startAnim();
 		   updateDisplayedCharacter();
//		   
		   
		   
	   }
		}));
		directionTimer.setCycleCount(Timeline.INDEFINITE);
		directionTimer.play();
	}
	
	
	abstract void initalizeAnimationList();

}
