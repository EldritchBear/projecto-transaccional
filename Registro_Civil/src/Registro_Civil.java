import javax.swing.*;

public class Registro_Civil {
	
	public static void main(String[] args) {
		Regiones regiones = new Regiones();
		try {
			regiones.leerTxt("registro.txt");
		} catch (Exception e) {
			System.out.println("No se pudo leer el archivo registro.txt");
		}
		JFrame frame = inicializarVentana();
		new VentanaMenu(regiones, frame);
		frame.setSize(512, 512);
	}

	public static JFrame inicializarVentana() {
		JFrame frame = new JFrame("Menú");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return frame;
	}
}