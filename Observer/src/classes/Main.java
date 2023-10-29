package classes;

import aspects.ObserverPattern;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton RedButton;
    private JButton GreenButton;
    private JButton CyanButton;
    
    public Main() {
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
            cambioDeFondo(Color.RED);
        } else if (e.getSource() == GreenButton) {
            cambioDeFondo(Color.GREEN);
        } else if (e.getSource() == CyanButton) {
            cambioDeFondo(Color.CYAN);
        }
    }
    
	public void cambioDeFondo(Color color) {
        getContentPane().setBackground(color);
        repaint();
	}

	public static void main (String [] args) {
        SwingUtilities.invokeLater(() -> {
            Main ventana = new Main();
            ObserverPattern.addListener(new ColorListener (new File ("ColorListenerLog.txt")));
            ventana.setVisible(true);
        });
	}
}
