package animations;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Character1Antimated implements EventHandler<MouseEvent>{
	
	private ArrayList<SimSESprite> animationList;
	private SimSESprite displayedAnimation;
	private int pathUnit;
	
	public Character1Antimated() {
		this.pathUnit = 0;
		this.initalizeAnimationSuite();
		this.displayedAnimation = new Character1WalkForward();
	}
	
	public void initalizeAnimationSuite() {
		this.animationList = new ArrayList<>();
		animationList.add(new Character1WalkForward());
		animationList.add(new Character1WalkBack());
		animationList.add(new Character1WalkLeft());
		animationList.add(new Character1WalkRight());
	}
	
	public void displayForward() {
		this.displayedAnimation = animationList.get(0);
		this.beginAnimation();
	}
	
	public void displayBack() {
		this.displayedAnimation = animationList.get(1);
		this.beginAnimation();
	}
	
	public void displayLeft() {
		this.displayedAnimation = animationList.get(2);
		this.beginAnimation();
	}
	
	public void displayRight() {
		this.displayedAnimation = animationList.get(3);
		this.beginAnimation();
	}
	
	public ImageView getDisplayedAnimation() {
		return this.displayedAnimation;
	}
	
	public void beginAnimation() {
		this.displayedAnimation.startAnim();
	}
	
	public void beginPathing() {
		Runnable helloRunnable = new Runnable() {
		    public void run() {
		    	System.out.println("Switch");
		        switch(pathUnit) {
		        case 0: 
		        	displayBack();
		        	pathUnit++;
		        	break;
		        case 1:
		        	displayLeft();
		        	pathUnit++;
		        	break;
		        case 2:
		        	displayRight();
		        	pathUnit++;
		        	break;
		        case 3:
		        	displayForward();
		        	pathUnit = 0;
		        	break;
		        }
		    }
		};

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	


}
