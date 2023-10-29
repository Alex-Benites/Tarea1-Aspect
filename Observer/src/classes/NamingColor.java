package classes;

import java.awt.Color;

public class NamingColor {
	public static String naming (Color color) {
		switch (color.getRGB()) {
		case -65536:
			return "Rojo";
		case -16711936:
			return "Verde";
		case -16711681:
			return "Azul";
		default:
			return String.valueOf(color.getRGB());
		}
	}
}
