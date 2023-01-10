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
	
	private SimSESprite startingAnimation, endingAnimation;

	public CreatablePath(double x, double y, double[][] xyChanges, SimSESprite startingAnimation, SimSESprite endingAnimation) {
		
		this.startingAnimation = startingAnimation;
		this.endingAnimation = endingAnimation;
		
        this.getElements().add(new MoveTo(x, y));
		        
		for(int i = 0; i < xyChanges.length; i++) {
				x += xyChanges[i][0];
				y += xyChanges[i][1];
				this.getElements().add(new LineTo(x, y));
		}  
	}
	
	public SimSESprite getStartingAnimation() {
		return this.startingAnimation;
	}
	
	public SimSESprite getEndingAnimation() {
		return this.endingAnimation;
	}
	
}
