package animations;

public class CharacterWalkForward extends SimSESprite{
	
	public final static String URL = "sprites\\character1cus_walk.png";


	public CharacterWalkForward(int characterNum) {
		super(16, 8, 0, 8, 32, 32, getURL(characterNum));
		// TODO Auto-generated constructor stub
	}

}
