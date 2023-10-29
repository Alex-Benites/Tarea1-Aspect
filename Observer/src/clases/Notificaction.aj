package clases;

import PatronObserver.Observer;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



aspect Notificaction {
	
	
	// Aqui atrapo el metodo agregarObserver
	pointcut NumeroObserver() : call(* clases.Principal.notificacionObserver(..));
	

	 after() returning : NumeroObserver() {
		 int num = Principal.lstObserver.size();
		System.out.println("Su numero actual de observadores es de: "+num);

	 }
	// Aqui atrapo el metodo notificacionObserver
	 pointcut AvisoCreacionObserver() : call(* clases.Principal.agregarObserver(..));
		

	 after() returning : AvisoCreacionObserver() {
		System.out.println("Se ha agregado un nuevo observer");
	 }
    
}