package clases;

import javax.swing.*;

import PatronObserver.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Principal extends JFrame implements ActionListener, Observable {
    private JButton RedButton;
    private JButton GreenButton;
    private JButton CyanButton;
    private Color colorFondo = Color.WHITE;
    public static ArrayList<Observer> lstObserver = new ArrayList<>(); 


    public Principal() {
        super("Cambiar Color de Fondo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        RedButton = new JButton("Rojo");
        GreenButton = new JButton("Verde");
        CyanButton = new JButton("Azul");

        add(RedButton);
        add(GreenButton);
        add(CyanButton);

        RedButton.addActionListener(this);
        GreenButton.addActionListener(this);
        CyanButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RedButton) {
        	
            colorFondo = Color.RED;
            notificacionObserver();
            
        } else if (e.getSource() == GreenButton) {
        	
            colorFondo = Color.GREEN;
            notificacionObserver();
            
        } else if (e.getSource() == CyanButton) {
        	
            colorFondo = Color.cyan;
            notificacionObserver();
        }

        getContentPane().setBackground(colorFondo);
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal ventana = new Principal();
        	CreateObservador observador1 = new CreateObservador();
	    	CreateObservador observador2 = new CreateObservador();
            ventana.agregarObserver(observador1);
            ventana.agregarObserver(observador2);
            ventana.setVisible(true);
        });
    }
    
    @Override
    public void agregarObserver(Observer observer) {
        lstObserver.add(observer);
    }
    
    @Override
    public void notificacionObserver() {
        for (Observer observer : lstObserver) {
            observer.update(colorFondo);
        }
    }
}

/*
import javax.swing.*;
import PatronObserver.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

	public class Principal extends JFrame implements Observable{
	    private JButton boton1;
	    private JButton boton2;
	    private JButton boton3;
	    private Color colorFondo = Color.WHITE;
	    public static ArrayList<Observer> lstObserver = new ArrayList<>(); 

	    public Principal() {
	        super("Menu Principal");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 200);

	        // Establece el diseño del contenedor principal
	        setLayout(new FlowLayout());

	        // Crea los botones y añade acciones para manejar los clics
	        boton1 = new JButton("Botón 1");
	        boton2 = new JButton("Botón 2");
	        boton3 = new JButton("Botón 3");

	        boton1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	colorFondo = Color.RED;
	                //System.out.println("Nuevo color de fondo: Rojo");
	                getContentPane().setBackground(colorFondo);
	                repaint();
	                notificacionObserver();
	            }
	        });
	        
	       

	        boton2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	colorFondo = Color.cyan;
	                //System.out.println("Nuevo color de fondo: cyan");
	                getContentPane().setBackground(colorFondo);
	                repaint();
	                notificacionObserver();
	            }
	        });

	        boton3.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	colorFondo = Color.GREEN;
//	        		System.out.println("Nuevo color de fondo: " + colorFondo.toString());
	                getContentPane().setBackground(colorFondo);
	                repaint();
	                notificacionObserver();
	            }
	        });

	        // Agrega los botones al contenedor principal
	        add(boton1);
	        add(boton2);
	        add(boton3);
	    }

	    public static void main(String[] args) {
	    	
	        SwingUtilities.invokeLater(() -> {
	        	CreateObservador observador1 = new CreateObservador();
		    	CreateObservador observador2 = new CreateObservador();
		    	
	            Principal ventana = new Principal();
	            ventana.agregarObserver(observador1);
	            ventana.agregarObserver(observador2);	            
	            ventana.setVisible(true);
	        });
	        
	    }
	    
	    @Override
	    public void agregarObserver(Observer observer) {
	        lstObserver.add(observer);
	    }
	    
	    @Override
	    public void notificacionObserver() {
	        for (Observer observer : lstObserver) {
	            observer.update(colorFondo);
	        }
	    }
	    
	   @Override 
	   public String toString() {
		return colorFondo.toString();
		   
	   }



	}
*/