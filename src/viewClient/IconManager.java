package viewClient;

import javafx.scene.image.Image;

public class IconManager {
	
	private IconManager(){}

	public static Image getImage(int iconInfo) {
		switch (iconInfo) {
			case 1: return new Image("/viewResources/Icons/file.png");
			case 2: return new Image("/viewResources/Icons/folder.png");
			case 3: return new Image("/viewResources/Icons/bag_color.png");
			case 4: return new Image("/viewResources/Icons/Bestellung_transit.png");
			case 5: return new Image("/viewResources/Icons/Bestellung_finished.png");
			case 6: return new Image("/viewResources/Icons/shop_color.png");
			case 7: return new Image("/viewResources/Icons/hersteller.png");
		// TODO provide images for icon info numbers!
			default:
			return new Image("/viewResources/Icons/database.png");
		}

	}
}
