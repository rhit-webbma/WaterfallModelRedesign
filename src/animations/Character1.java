package animations;

public class Character1 extends DisplayableCharacter{
	
	public Character1() {
		super();
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
