package ProblemasABC;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Programa para calcular la convolución ponderada dado un n, A, B, C y D
 * @author Santiago Pardo y Kevin Cohen
 */
public class ProblemaA {
	
	private static final DecimalFormat df = new DecimalFormat("0.0000");

	public static void main(String[] args) throws Exception {
		ProblemaA instancia = new ProblemaA();
		try (InputStreamReader is = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(is);) {
			String line = br.readLine();

			while (line != null && line.length() > 0 && !"0".equals(line)) {
				final String[] dataStr = line.split(" ");
				int n = Integer.parseInt(dataStr[0]);
				float a = Float.parseFloat(dataStr[1]);
				float b = Float.parseFloat(dataStr[2]);
				float c = Float.parseFloat(dataStr[3]);
				float d = Float.parseFloat(dataStr[4]);
				float res = instancia.calcular(n, a, b, c, d);
				String print = df.format(res);
				System.out.println(print);
				line = br.readLine();
			}
		}
	}

	/**
	 * @param n tiempo en años
	 * @param a	numero real
	 * @param b numero real
	 * @param c numero real
	 * @param d numero real
	 * @return float, la convolución ponderada de la reserva en el tiempo n, sobre los parametros de entrada A, B ,C y D
	 */
	public float calcular(int n, float a, float b, float c, float d) {
		ArrayList<Float> arreglo = new ArrayList<Float>();
		arreglo.add(0, a);
		arreglo.add(1, b);
		int pos = 2;
		while (pos <= n) {
			float valorPos = c * arreglo.get(pos - 2) + d * arreglo.get(pos - 1);
			arreglo.add(pos, valorPos);
			pos++;
		}
		float varSumatoria = 0;
		int k = 0;
		while (k <= n) {
			varSumatoria += (arreglo.get(k) * arreglo.get(n - k));
			k++;
		}
		return varSumatoria;
	}

}