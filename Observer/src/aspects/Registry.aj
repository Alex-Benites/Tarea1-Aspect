package aspects;

import classes.NamingColor;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.util.Calendar;

public aspect Registry {
	File file = new File("Background.txt");
	Calendar cal;
	
	pointcut registrarCambio(Color color): call(* cambioDeFondo(Color)) && args(color);
    
    after(Color color) : registrarCambio(color) {
	    this.cal = Calendar.getInstance();
	    String colorName = NamingColor.naming(color);
	    
	    try (PrintWriter pw=new PrintWriter(new FileOutputStream(file,true))) {
	    	pw.println("Cambio de fondo registrado: ["+colorName+"] Fecha: ["+cal.getTime() + "]");
	    	System.out.println("****Color de fondo ["+colorName+"] Registrado**** "+cal.getTime());
	    } catch (FileNotFoundException e){
	    	System.out.println(e.getMessage());
	    }
    }
}
