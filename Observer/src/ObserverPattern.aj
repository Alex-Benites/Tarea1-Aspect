package aspects;

import interfaces.EventListener;

import java.awt.Color;
import java.util.ArrayList;

public aspect ObserverPattern {
    public static ArrayList<EventListener> Listeners = new ArrayList<>();
	
	pointcut update(Color color): call(* cambioDeFondo(Color)) && args(color);
	after(Color color) : update(color) {
		for (EventListener listener: Listeners) {
			listener.update(color);
		}
	}
	
	public static void addListener (EventListener listener) {
		Listeners.add(listener);
	}
	
	public static void removeListener (EventListener listener) {
		Listeners.remove(listener);
	}
}
