
package calculadoradolares;

import java.awt.EventQueue;

public class CalculadoraDolares {

    public static void main(String[] args) {
        
        //Validacion para que se muestre la ventana cCalculadoraDolares con un try y un catch
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cCalculadoraDolares window = new cCalculadoraDolares();
					window.isVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    
}
