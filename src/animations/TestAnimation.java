package animations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import animations.Character1WalkForward;
import animations.Character1WalkLeft;
import animations.Character1WalkRight;
import animations.HorseAnimation;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestAnimation extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Horse :)");
                
//        ArrayList<SimSESprite> animationList = new ArrayList<>();
//        animationList.add(new Character1Idle());
//		animationList.add(new Character1WalkForward());
//		animationList.add(new Character1WalkBack());
//		animationList.add(new Character1WalkLeft());
//		animationList.add(new Character1WalkRight());
//		
//		displayedCharacter = animationList.get(0);
//		displayedCharacter.startAnim();
		
		DisplayableCharacter char1 = new Character1();
        
        
//        Character1WalkForward anim = new Character1WalkForward();
//        anim.setFitHeight(100);
//        anim.setFitWidth(100);
//        
//        anim.startAnim();
//        Group root = new Group(displayedCharacter);
//        root.getChildren().remove(character1);
//        character1.displayBack();
//        root.getChildren().add(character1.getDisplayedAnimation());
//        


//        character1.beginPathing();
        
        Scene scene = new Scene(char1, 595, 370);
        char1.requestFocus();
//        
//        scene.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.LEFT) {
//            	displayedCharacter = animationList.get(3);
//            	displayedCharacter.setX(displayedCharacter.getX() - 1);
//            }
//            if (e.getCode() == KeyCode.RIGHT) {
//            	displayedCharacter = animationList.get(4);
//            	displayedCharacter.setX(displayedCharacter.getX() + 1);
//            }
//            if (e.getCode() == KeyCode.UP) {
//            	displayedCharacter = animationList.get(2);
//            	displayedCharacter.setY(displayedCharacter.getY() - 1);
//            }
//            if (e.getCode() == KeyCode.DOWN) {
//            	displayedCharacter = animationList.get(1);
//            	displayedCharacter.setY(displayedCharacter.getY() + 1);
//            }
//    		displayedCharacter.startAnim();
//    		root.getChildren().setAll(displayedCharacter);
//        });
//        
//        scene.setOnKeyReleased(e -> {
//        	displayedCharacter = animationList.get(0);
//        	displayedCharacter.startAnim();
//        	root.getChildren().setAll(displayedCharacter);
//        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}