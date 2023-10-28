package clases;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class Principal extends JFrame {
	    private JButton boton1;
	    private JButton boton2;
	    private JButton boton3;

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
	                // Cambio de color 1
	            }
	        });
	        
	       

	        boton2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Acción del botón 2
	            }
	        });

	        boton3.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Acción del botón 3
	            }
	        });

	        // Agrega los botones al contenedor principal
	        add(boton1);
	        add(boton2);
	        add(boton3);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            Principal ventana = new Principal();
	            ventana.setVisible(true);
	        });
	    }
	}