package simse.gui.util;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public final class JavaFXHelpers {

	public static Background createBackgroundColor(Color color) {
		return new Background(new BackgroundFill(color, null, null));
	}
	
}
