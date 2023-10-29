package clases;

import PatronObserver.Observer;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import clases.Principal;



aspect Notificaction {
	
	private SimpleDateFormat fecha = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

	// Aqui atrapo el metodo agregarObserver
	pointcut NumeroObserver() : call(* clases.Principal.notificacionObserver(..));
	
	// advice que se ejecutara despues de atrapar el metodo agregarObserver
	 after() returning : NumeroObserver() {
		 int num = Principal.lstObserver.size();
		System.out.println("Su numero actual de observadores es de: "+num);

	 }
	// Aqui atrapo el metodo notificacionObserver
	 pointcut AvisoCreacionObserver() : call(* clases.Principal.agregarObserver(..));
		

	 after() returning : AvisoCreacionObserver() {
		System.out.println("Se ha agregado un nuevo observer");
		ArchivoEstadoVentana();
	 }

	 public void ArchivoEstadoVentana() {
		 File file = new File("EstadoVentana.txt");
			String time = fecha.format(Calendar.getInstance().getTime());
			String message = null;
			try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
				if(Principal.colorFondo.equals(Color.RED)) {
					message = "El estado de la ventana cambio a rojo, el dia "+time;
				}else if(Principal.colorFondo.equals(Color.GREEN)){
		
					message = "El estado de la ventana cambio a verde, el dia "+time;
				}else if(Principal.colorFondo.equals(Color.cyan)){
		
					message = "El estado de la ventana cambio a celeste, el dia "+time;
				}
						
			
			System.out.println(message);
			out.println(message);
			} catch (IOException ex) {
			ex.printStackTrace();
			}	       
		 
	 }
	    	
	    	
	   
}