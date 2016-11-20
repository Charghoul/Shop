package viewClient;

import javafx.scene.image.Image;

public class IconManager {
	
	private IconManager(){}

	public static Image getImage(int iconInfo) {
		switch (iconInfo) {
			case 1: return new Image("/viewResources/Icons/database.png");
			case 2: return new Image("/viewResources/Icons/folder-24.png");

		// TODO provide images for icon info numbers!
			default:
			return new Image("/viewResources/Icons/database.png");
		}

	}
}
