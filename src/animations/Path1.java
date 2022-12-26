/**
 * 
 */
package animations;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * @author localmgr
 *
 */
public class Path1 extends Path {
	
	private int x, y;

	public Path1(int x, int y) {
		
//		int xPos = x;
//		int yPos = y;
		
        this.getElements().add(new MoveTo(x, y));
        y += 90;
        this.getElements().add(new LineTo(x, y));
        x -= 64;
        this.getElements().add(new LineTo(x, y));
        y -= 54;
        this.getElements().add(new LineTo(x, y));
        x -= 38;
        this.getElements().add(new LineTo(x, y));
        y -= 51;
        this.getElements().add(new LineTo(x, y));
        y += 15;
        this.getElements().add(new LineTo(x, y));
        x += 102;
        this.getElements().add(new LineTo(x, y));    
	}
	
}
