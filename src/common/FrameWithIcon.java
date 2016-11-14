package common;

import javax.swing.*;
import java.net.URL;

@SuppressWarnings("serial")
public class FrameWithIcon extends JFrame {
	
	private static final String Icon = "common/logo.jpg";

	public FrameWithIcon(){
		URL iconUrl = FrameWithIcon.class.getClassLoader().getResource(Icon);
		if (iconUrl != null) this.setIconImage(getToolkit().getImage(iconUrl));
	}

}
