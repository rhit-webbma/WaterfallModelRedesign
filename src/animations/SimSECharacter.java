package animations;

import javafx.scene.shape.Path;

public class SimSECharacter extends DisplayableCharacter{
	
	public SimSECharacter(Path pathToFollow, int characterNum, int height, int width) {
		super(pathToFollow, characterNum, height, width);
	}

	@Override
	void initalizeAnimationList(int characterNum) {
		// TODO Auto-generated method stub
		animationList.add(new CharacterIdle(characterNum));
		animationList.add(new CharacterWalkForward(characterNum));
		animationList.add(new CharacterWalkBack(characterNum));
		animationList.add(new CharacterWalkLeft(characterNum));
		animationList.add(new CharacterWalkRight(characterNum));	
	}

}
