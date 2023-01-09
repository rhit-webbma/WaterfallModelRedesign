/**
 * 
 */
package animations;

import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * @author localmgr
 *
 */
public class CreatablePath extends Path {

	public CreatablePath(double x, double y, double[][] xyChanges) {
		
//		int xPos = x;
//		int yPos = y;
		
        this.getElements().add(new MoveTo(x, y));
		        
		for(int i = 0; i < xyChanges.length; i++) {
				x += xyChanges[i][0];
				y += xyChanges[i][1];
				this.getElements().add(new LineTo(x, y));
		}
		
//		this.getElements().add(new ClosePath());
	
//        y += 41;
//        this.getElements().add(new LineTo(x, y));
//        x += 299;
//        this.getElements().add(new LineTo(x, y));    
	}
	
}
