package animations;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import simse.gui.MapData;

public abstract class DisplayableCharacter extends Group{
	
	private SimSESprite displayedCharacter;
	protected int velocity, height, width, characterNum;
	private double previousX, previousY;
	private PathTransition transition;
	private boolean starting;
	private CreatablePath pathToFollow;
	protected ArrayList<SimSESprite> animationList;
	
	public DisplayableCharacter(CreatablePath pathToFollow, int characterNum, int width, int height) {	
		this.velocity = 2;
		this.pathToFollow = pathToFollow;
		this.characterNum = characterNum;
		this.starting = false;
		this.height = height;
		this.width = width;
		this.directionCheck();
		animationList = new ArrayList<>();
		initalizeAnimationList(characterNum);
		displayedCharacter = pathToFollow.getStartingAnimation();
		displayedCharacter.setFitHeight(height);
		displayedCharacter.setFitWidth(width);
		this.getChildren().add(displayedCharacter);
		displayedCharacter.startAnim();
		
		this.beginPathing();
	}
	
	public DisplayableCharacter(int characterNum, int width, int height) {
		this.height = height;
		this.width = width;
		this.characterNum = characterNum;
		animationList = new ArrayList<>();
		initalizeAnimationList(characterNum);
		displayedCharacter = animationList.get(0);
		displayedCharacter.setFitHeight(height);
		displayedCharacter.setFitWidth(width);
		this.getChildren().add(displayedCharacter);
		displayedCharacter.startAnim();	
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
	
	public ImageView getStaticImage() {
		return this.displayedCharacter;
	}
	
	public void beginPathing() {
		this.transition = new PathTransition();
		Random rand = new Random();
		int duration = (int)Math.floor(Math.random()*(18-15)+14);
		
		transition.setNode(this);
		transition.setDuration(Duration.seconds(duration));
		transition.setPath(pathToFollow);
		transition.setCycleCount(1);
		
		transition.setOnFinished(e -> {
			int randomNumber = rand.nextInt(60)+10;
			Path newPath = null;
			
			if(starting) {
				double[][] pathDirections = PathData.getStartingPath(characterNum);
				newPath = new CreatablePath(
						MapData.getStartingMapLocation(characterNum)[0] + 5,
						MapData.getStartingMapLocation(characterNum)[1],
						pathDirections,
						PathData.getAnimationData(characterNum)[0],
						PathData.getAnimationData(characterNum)[1]
						);
				this.starting = false;
			} else {
				double[][] pathDirections = PathData.getEndingPath(characterNum);
				newPath = new CreatablePath(
						MapData.getEndingMapLocation(characterNum)[0] + 5,
						MapData.getEndingMapLocation(characterNum)[1],
						pathDirections,
						PathData.getAnimationData(characterNum)[0],
						PathData.getAnimationData(characterNum)[1]
						);
				this.starting = true;
			}
			
			transition.setPath(newPath);
			transition.setDelay(Duration.seconds(randomNumber));
			
				
//			Timeline delayTimer = new Timeline(
//	                new KeyFrame(Duration.seconds(randomNumber), 
//	                new EventHandler<ActionEvent>() {
//
//			   @Override
//			   public void handle(ActionEvent event) {
//				   System.out.println("Stopping");
//				   displayedCharacter.stopAnim();
//			   }
//			   }));
//			
//			delayTimer.setCycleCount(1);
//			
//			delayTimer.setOnFinished(delayEvent -> {
//			   displayedCharacter = animationList.get(0);
//	 		   displayedCharacter.startAnim();
//	 		   updateDisplayedCharacter();
//			});
//			
//			delayTimer.play();
			transition.play();
		});
		
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
		   
		   if(currentX == previousX && currentY == previousY) {
			   if(starting) {
				   displayedCharacter = pathToFollow.getEndingAnimation();
			   } else {
				   displayedCharacter = pathToFollow.getStartingAnimation();
			   }
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
	
	
	abstract void initalizeAnimationList(int characterNum);

}
