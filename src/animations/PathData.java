package animations;

public class PathData {

	public static final double[][] PATH_0S = {{-12, 0}, {0, 74}, {185, 0}};
	public static final double[][] PATH_0E = {{-185, 0}, {0, -74}, {12,0}};
	public static final double[][] PATH_1S = {{-56, 0}, {0, -96}, {-94, 0}, {0, 11}};
	public static final double[][] PATH_1E = {{0, -11}, {94, 0}, {0, 96}, {56, 0}};
	public static final double[][] PATH_2S = {{-143, 0}, {0, -116}, {-156, 0}, {0, -10}};
	public static final double[][] PATH_2E = {{0, 10}, {156, 0}, {0, 116}, {143, 0}};
	public static final double[][] PATH_3S = {{-58, 0}, {0, 104}, {-32, 0}};
	public static final double[][] PATH_3E = {{32, 0}, {0, -104}, {58, 0}};
	public static final double[][] PATH_4S = {{-233, 0}, {0, -17}};
	public static final double[][] PATH_4E = {{0, 17}, {233, 0}};
	public static final double[][] PATH_5S = {{56, 0}, {0, -65}, {56, 0}, {0, -5}};
	public static final double[][] PATH_5E = {{0, 5}, {-56, 0}, {0, 65}, {-56, 0}};
	public static final double[][] PATH_6S = {{0, 69}, {210, 0}, {0, -157}};
	public static final double[][] PATH_6E = {{0, 157}, {-210, 0}, {0, -69}};
	
	public static final SimSESprite[] PATH_0_ANIM_DATA = {new CharacterIdleFront(0), new CharacterIdleRight(0)};
	public static final SimSESprite[] PATH_1_ANIM_DATA = {new CharacterIdleFront(1), new CharacterIdleFront(1)};
	public static final SimSESprite[] PATH_2_ANIM_DATA = {new CharacterIdleFront(2), new CharacterIdleBack(2)};
	public static final SimSESprite[] PATH_3_ANIM_DATA = {new CharacterIdleFront(3), new CharacterIdleLeft(3)};
	public static final SimSESprite[] PATH_4_ANIM_DATA = {new CharacterIdleFront(4), new CharacterIdleBack(4)};
	public static final SimSESprite[] PATH_5_ANIM_DATA = {new CharacterIdleFront(5), new CharacterIdleBack(5)};
	public static final SimSESprite[] PATH_6_ANIM_DATA = {new CharacterIdleFront(6), new CharacterIdleBack(6)};
	
	public static double[][] getStartingPath(int pathNumber) {
		switch (pathNumber)
		{
		case 0: return PATH_0S;
		case 1: return PATH_1S;
		case 2: return PATH_2S;
		case 3: return PATH_3S;
		case 4: return PATH_4S;
		case 5: return PATH_5S;
		case 6: return PATH_6S;
		default: throw new IllegalArgumentException();
		}		
	}
	
	public static double[][] getEndingPath(int pathNumber) {
		switch (pathNumber)
		{
		case 0: return PATH_0E;
		case 1: return PATH_1E;
		case 2: return PATH_2E;
		case 3: return PATH_3E;
		case 4: return PATH_4E;
		case 5: return PATH_5E;
		case 6: return PATH_6E;
		default: throw new IllegalArgumentException();
		}		
	}
	
	public static SimSESprite[] getAnimationData(int animationNumber) {
		switch (animationNumber)
		{
		case 0: return PATH_0_ANIM_DATA;
		case 1: return PATH_1_ANIM_DATA;
		case 2: return PATH_2_ANIM_DATA;
		case 3: return PATH_3_ANIM_DATA;
		case 4: return PATH_4_ANIM_DATA;
		case 5: return PATH_5_ANIM_DATA;
		case 6: return PATH_6_ANIM_DATA;
		default: throw new IllegalArgumentException();
		}	
	}
	
	
}
