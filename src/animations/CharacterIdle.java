package animations;

public class CharacterIdle extends SimSESprite{
	
	public final static String URL = "sprites\\character1cus_walk.png";


	public CharacterIdle(int characterNum) {
		super(16, 1, 0, 8, 32, 32, getURL(characterNum));
		// TODO Auto-generated constructor stub
	}

}
