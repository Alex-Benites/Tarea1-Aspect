package clases;

import javax.swing.*;

import PatronObserver.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Principal extends JFrame implements ActionListener, Observable {
    public static JButton RedButton;
    public static JButton GreenButton;
    public static JButton CyanButton;
    public static Color colorFondo = Color.WHITE;
    public static ArrayList<Observer> lstObserver = new ArrayList<>(); 
	static Principal ventana = new Principal();
    public JLabel mensajeLabel = new JLabel("Mensaje: ");


    public Principal() {
        super("Cambiar Color de Fondo");
        setSize(600, 300);
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
            Rojo observador2 = new Rojo();
            ventana.agregarObserver(observador2);
            notificacionObserver();
            
            
        } else if (e.getSource() == GreenButton) {
        	
            colorFondo = Color.GREEN;
            Green observador2 = new Green();
            ventana.agregarObserver(observador2);
            notificacionObserver();
            
        } else if (e.getSource() == CyanButton) {
        	
            colorFondo = Color.cyan;
            Cyan observador2 = new Cyan();
            ventana.agregarObserver(observador2);
            notificacionObserver();
        }

        getContentPane().setBackground(colorFondo);
        repaint();
    }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
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
            observer.update();
        }
    }
    

}

