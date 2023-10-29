package clases;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import PatronObserver.Observer;

public class Rojo implements Observer {
	SimpleDateFormat fecha = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	String time = fecha.format(Calendar.getInstance().getTime());


	@Override
	public void update() {
		
		System.out.println("Hola Soy el observador Rojo, creado el "+time );
	
	}

	@Override
	public String toString() {
		return "Rojo";
	}

}
