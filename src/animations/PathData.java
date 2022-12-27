package animations;

public class PathData {

	public static final double[][] PATH_0 = {{0, 90}, {-64, 0}, {0, -54}, {-38, 0}, {0, -51}, {0, 15}};
	public static final double[][] PATH_1 = {{-264, 0}, {0, -130}, {0, 130}, {264, 0}};
	public static final double[][] PATH_2 = {{0, 75}, {-299, 0}, {299, 0}, {0, -75}};
	public static final double[][] PATH_3 = {{0, 39}, {-95, 0}, {0, -145}, {0, 145}, {95, 0}, {0, -39}};
	public static final double[][] PATH_4 = {{-103, 0}, {0, -118}, {200, 0}, {-200, 0}, {0, 118}, {103, 0}};
	public static final double[][] PATH_5 = {{0, 39}, {-149, 0}, {0, 170}, {0, -170}, {149, 0}, {0, -39}};
	public static final double[][] PATH_6 = {{0, -128}, {202, 0}, {-202, 0}, {0, 128}};
	
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
