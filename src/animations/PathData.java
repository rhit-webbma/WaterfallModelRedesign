package animations;

public class PathData {

	public static final double[][] PATH_0 = {{-12, 0}, {0, 74}, {185, 0}, {-185, 0}, {0, -74}, {12,0}};
	public static final double[][] PATH_1 = {{-56, 0}, {0, -96}, {-94, 0}, {0, 11}, {0, -11}, {94, 0}, {0, 96}, {56, 0}};
	public static final double[][] PATH_2 = {{-143, 0}, {0, -116}, {-156, 0}, {0, -10}, {0, 10}, {156, 0}, {0, 116}, {143, 0}};
	public static final double[][] PATH_3 = {{-58, 0}, {0, 104}, {-32, 0}, {32, 0}, {0, -104}, {58, 0}};
	public static final double[][] PATH_4 = {{-233, 0}, {0, -17}, {0, 17}, {233, 0}};
	public static final double[][] PATH_5 = {{56, 0}, {0, -65}, {56, 0}, {0, -5}, {0, 5}, {-56, 0}, {0, 65}, {-56, 0}};
	public static final double[][] PATH_6 = {{0, 69}, {210, 0}, {0, -157}, {0, 157}, {-210, 0}, {0, -69}};
	
	public static double[][] getPath(int pathNumber) {
		switch (pathNumber)
		{
		case 0: return PATH_0;
		case 1: return PATH_1;
		case 2: return PATH_2;
		case 3: return PATH_3;
		case 4: return PATH_4;
		case 5: return PATH_5;
		case 6: return PATH_6;
		default: throw new IllegalArgumentException();
		}

				
	}
	
	
}
