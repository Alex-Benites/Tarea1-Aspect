package classes;

import interfaces.EventListener;

import java.awt.Color;
import java.io.File;

public class ColorListener implements EventListener {
	private File log;
	private String colorActual;
	
	public ColorListener (File log) {
		this.log = log;
	}
	
	@Override
	public void update (Color color) {
		colorActual = NamingColor.naming(color);
		System.out.println("Save to log "+log+": Color de fondo actual: "+colorActual);
	}
}
