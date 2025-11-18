package generadorContraseñas;
import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class GeneradorContrasena {

	public static void main(String[] args) {
		// Pedir longitud deseada al usuario
        String input = JOptionPane.showInputDialog(null, 
                "¿De cuántos caracteres quieres tu contraseña?\n(Recomendado: 8 - 20)",
                "Generador de Contraseñas", 
                JOptionPane.QUESTION_MESSAGE);

        // Validar entrada
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return;
        }

        int longitud;
        try {
            longitud = Integer.parseInt(input);
            if (longitud < 4) {
                JOptionPane.showMessageDialog(null, "La longitud debe ser mayor o igual a 4.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
            return;
        }

        // Caracteres posibles
        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minus = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%&*_-+=";

        String total = mayus + minus + numeros + simbolos;

        SecureRandom random = new SecureRandom();
        StringBuilder pass = new StringBuilder();

        // Generar contraseña
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(total.length());
            pass.append(total.charAt(index));
        }

        // Mostrar resultado
        JOptionPane.showMessageDialog(null, 
                "✨ Tu contraseña generada es:\n\n" + pass.toString(),
                "Resultado", 
                JOptionPane.INFORMATION_MESSAGE);
    }
}