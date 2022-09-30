import javax.swing.*;
import java.awt.event.*;
class WindowEventHandler extends WindowAdapter {
	Regiones regiones;
	public WindowEventHandler(Regiones regiones) {
		this.regiones = regiones;
	}
	public void windowClosing(WindowEvent evt) {
		try {
			regiones.escribirTxt("registro.csv");
		} catch(Exception e) {
			System.out.println("No se pudo escribir en registro.csv");
		}
	}
}

public class Registro_Civil {
	
	public static void main(String[] args) {
		Regiones regiones = new Regiones();
		try {
			regiones.leerTxt("registro.csv");
		} catch (Exception e) {
			System.out.println("No se pudo leer el archivo registro.txt");
		}
		JFrame frame = inicializarVentana(regiones);
		new VentanaMenu(regiones, frame);
		frame.setSize(512, 512);
	}

	public static JFrame inicializarVentana(Regiones regiones) {
		JFrame frame = new JFrame("Menú");
		frame.setVisible(true);
		frame.addWindowListener(new WindowEventHandler(regiones));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		return frame;
	}
}