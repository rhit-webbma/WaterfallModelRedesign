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

	public Path1() {        
        this.getElements().add(new MoveTo(281, 70));
        this.getElements().add(new LineTo(281, 160));
        this.getElements().add(new LineTo(217, 160));
        this.getElements().add(new LineTo(217, 106));
        this.getElements().add(new LineTo(179, 106));
        this.getElements().add(new LineTo(179, 55));
        this.getElements().add(new LineTo(179, 70));
        this.getElements().add(new LineTo(281, 70));      
	}
	
}
