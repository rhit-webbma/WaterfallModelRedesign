/* File generated by: simse.codegenerator.guigenerator.MapDataGenerator */
// MapData works as a structure (having only fields).  It contains all the keys for any particular image, as well as
// the ImagImageViewociated with that key. Currently some keys are not in use i.e. have no image associated with them
package simse.gui;

import com.sun.javafx.tk.Toolkit;

import javafx.scene.image.Image;
import simse.gui.util.JavaFXHelpers;

public class MapData {
	static final int TILE_SIZE = 50; // size of 1 tile
	static final int X_MAPSIZE = 16; // number of tiles along X axis for map
	static final int Y_MAPSIZE = 10; // number of tiles along Y axis for map

	static final int TRANSPARENT = -1;
	static final int TILE_GRID = 0;
	static final int TILE_DARK = -2;
	static final int USER_SELECTED = -11;
	static final int TILE_FLOOR = -3;

	static final int TILE_CHAIRT = 101; // chair, face north
	static final int TILE_CHAIRB = 102; // face east
	static final int TILE_CHAIRL = 103;
	static final int TILE_CHAIRR = 104;

	static final int TILE_TRASHCANE = 2;
	static final int TILE_TRASHCANF = 3;

	static final int TILE_COMPUTER = 4;
	static final int TILE_PAPERS = 5;

	static final int TILE_STABLE_TL = 401; // square table
	static final int TILE_STABLE_TM = 402;
	static final int TILE_STABLE_TR = 403;
	static final int TILE_STABLE_ML = 404;
	static final int TILE_STABLE_MM = 405;
	static final int TILE_STABLE_MR = 406;
	static final int TILE_STABLE_BL = 407;
	static final int TILE_STABLE_BM = 408;
	static final int TILE_STABLE_BR = 409;

	static final int TILE_RTABLE1 = 411; // round table
	static final int TILE_RTABLE2 = 412;
	static final int TILE_RTABLE3 = 413;
	static final int TILE_RTABLE4 = 414;
	static final int TILE_RTABLE5 = 415;
	static final int TILE_RTABLE6 = 416;
	static final int TILE_RTABLE7 = 417;
	static final int TILE_RTABLE8 = 418;
	static final int TILE_RTABLE9 = 419;

	static final int TILE_DOOR = 5; // door

	static final int TILE_WALL_T = 601; // wall
	static final int TILE_WALL_B = 602;
	static final int TILE_WALL_L = 603;
	static final int TILE_WALL_R = 604;
	static final int TILE_WALL_TL = 605;
	static final int TILE_WALL_TR = 606;
	static final int TILE_WALL_BL = 607;
	static final int TILE_WALL_BR = 608;

	static final int TILE_DOOR_TO = 611;
	static final int TILE_DOOR_TC = 612;
	static final int TILE_DOOR_LO = 613;
	static final int TILE_DOOR_LC = 614;
	static final int TILE_DOOR_RO = 615;
	static final int TILE_DOOR_RC = 616;

	static final String dir = "src/simse/gui/images/";
	static final Image transparent = JavaFXHelpers.createImage(dir + "transparent.gif");
	static final Image grid = JavaFXHelpers.createImage(dir + "grid.gif");
	static final Image floor = JavaFXHelpers.createImage(dir + "floor.gif");
	static final Image chairT = JavaFXHelpers.createImage(dir + "chairT.gif");
	static final Image chairB = JavaFXHelpers.createImage(dir + "chairB.gif");
	static final Image chairL = JavaFXHelpers.createImage(dir + "chairL.gif");
	static final Image chairR = JavaFXHelpers.createImage(dir + "chairR.gif");
	static final Image computer = JavaFXHelpers.createImage(dir + "computer.gif");
 
//	static final Image dark = JavaFXHelpers.createImage(dir + "dark.gif");
	static final Image trashcanE = JavaFXHelpers.createImage(dir + "trashcan_e.gif");
	static final Image trashcanF = JavaFXHelpers.createImage(dir + "trashcan_f.gif");
	static final Image papers = JavaFXHelpers.createImage(dir + "papers.gif");

	static final Image wallT = JavaFXHelpers.createImage(dir + "wall/wall_t.gif");
	static final Image wallB = JavaFXHelpers.createImage(dir + "wall/wall_b.gif");
	static final Image wallL = JavaFXHelpers.createImage(dir + "wall/wall_l.gif");
	static final Image wallR = JavaFXHelpers.createImage(dir + "wall/wall_r.gif");
	static final Image wallTL = JavaFXHelpers.createImage(dir + "wall/wall_tl.gif");
	static final Image wallTR = JavaFXHelpers.createImage(dir + "wall/wall_tr.gif");
	static final Image wallBL = JavaFXHelpers.createImage(dir + "wall/wall_bl.gif");
	static final Image wallBR = JavaFXHelpers.createImage(dir + "wall/wall_br.gif");

	static final Image doorTO = JavaFXHelpers.createImage(dir + "wall/door_to.gif");
	static final Image doorTC = JavaFXHelpers.createImage(dir + "wall/door_tc.gif");
	static final Image doorLO = JavaFXHelpers.createImage(dir + "wall/door_lo.gif");
	static final Image doorLC = JavaFXHelpers.createImage(dir + "wall/door_lc.gif");
	static final Image doorRO = JavaFXHelpers.createImage(dir + "wall/door_ro.gif");
	static final Image doorRC = JavaFXHelpers.createImage(dir + "wall/door_rc.gif");

	static final Image sTableTL = JavaFXHelpers.createImage(dir + "table/sTable_tl.gif");
	static final Image sTableTM = JavaFXHelpers.createImage(dir + "table/sTable_tm.gif");
	static final Image sTableTR = JavaFXHelpers.createImage(dir + "table/sTable_tr.gif");
	static final Image sTableBL = JavaFXHelpers.createImage(dir + "table/sTable_bl.gif");
	static final Image sTableBM = JavaFXHelpers.createImage(dir + "table/sTable_bm.gif");
	static final Image sTableBR = JavaFXHelpers.createImage(dir + "table/sTable_br.gif");

	static final Image speechTL = JavaFXHelpers.createImage(dir + "speechTL.gif");
	static final Image speechTR = JavaFXHelpers.createImage(dir + "speechTR.gif");
	static final Image speechBL = JavaFXHelpers.createImage(dir + "speechBL.gif");
	static final Image speechBR = JavaFXHelpers.createImage(dir + "speechBR.gif");

	static final Image error = JavaFXHelpers.createImage(dir + "error.gif");

	public static Image getImage(String file) {
		return JavaFXHelpers.createImage(file);
	}

	public static ImageView getImage(int key) {
		switch (key) {
		case TRANSPARENT:
			return transparent;
		case TILE_GRID:
			return grid;

		case TILE_FLOOR:
			return floor;
		case TILE_COMPUTER:
			return computer;
		case TILE_CHAIRT:
			return chairT;
		case TILE_CHAIRB:
			return chairB;
		case TILE_CHAIRL:
			return chairL;
		case TILE_CHAIRR:
			return chairR;

		case TILE_TRASHCANE:
			return trashcanE;
		case TILE_TRASHCANF:
			return trashcanF;
		case TILE_PAPERS:
			return papers;

		case TILE_DOOR_TO:
			return doorTO;
		case TILE_DOOR_TC:
			return doorTC;
		case TILE_DOOR_LO:
			return doorLO;
		case TILE_DOOR_LC:
			return doorLC;
		case TILE_DOOR_RO:
			return doorRO;
		case TILE_DOOR_RC:
			return doorRC;

		case TILE_WALL_TL:
			return wallTL;
		case TILE_WALL_T:
			return wallT;
		case TILE_WALL_TR:
			return wallTR;

		case TILE_WALL_L:
			return wallL;
		case TILE_WALL_R:
			return wallR;

		case TILE_WALL_BL:
			return wallBL;
		case TILE_WALL_B:
			return wallB;
		case TILE_WALL_BR:
			return wallBR;

		case TILE_STABLE_TL:
			return sTableTL;
		case TILE_STABLE_TM:
			return sTableTM;
		case TILE_STABLE_TR:
			return sTableTR;

		case TILE_STABLE_BL:
			return sTableBL;
		case TILE_STABLE_BM:
			return sTableBM;
		case TILE_STABLE_BR:
			return sTableBR;

		default:
			return error;
		}
	}
}