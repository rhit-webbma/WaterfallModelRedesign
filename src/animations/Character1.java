package animations;

import javafx.scene.shape.Path;

public class Character1 extends DisplayableCharacter{
	
	public Character1(Path pathToFollow, int height, int width) {
		super(pathToFollow, height, width);
	}

	@Override
	void initalizeAnimationList() {
		// TODO Auto-generated method stub
		animationList.add(new Character1Idle());
		animationList.add(new Character1WalkForward());
		animationList.add(new Character1WalkBack());
		animationList.add(new Character1WalkLeft());
		animationList.add(new Character1WalkRight());	
	}

}
