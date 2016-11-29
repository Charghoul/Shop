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
			case 6: return new Image("/viewResources/Icons/shop.png");
			case 7: return new Image("/viewResources/Icons/hersteller.png");
			case 8: return new Image("/viewResources/Icons/konto1.png");
			case 9: return new Image("/viewResources/Icons/time.png");
			case 10: return new Image("/viewResources/Icons/clock.png");
			case 11: return new Image("/viewResources/Icons/lieferartmanager.png");
			case 12: return new Image("/viewResources/Icons/contact.png");
			case 13: return new Image("/viewResources/Icons/search.png");
		// TODO provide images for icon info numbers!
			default:
			return new Image("/viewResources/Icons/database.png");
		}

	}
}
