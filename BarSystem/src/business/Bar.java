package business;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bar {
	private HashMap<String, Cliente> hmC;
	private Set<Map.Entry<String, Cliente>> set;

	public Bar() {
		hmC = new HashMap<>();
	}

	public boolean validaEntrada(Cliente c) {
		boolean result = false;
		if (!hmC.containsValue(c)) {
			entrada(c);
			result = true;
		}

		return result;
	}

	public void entrada(Cliente c) {

		hmC.put(c.getCpf(), c);

	}

	public String quemEstanoBar() {
		String result = "";
		set = hmC.entrySet();
		for (Map.Entry<String, Cliente> me : set) {
			result = result + me.getValue().getNome() + "\n";
		}
		return result;
	}

	public String getClientePeloCpf(String cpf) {
		String result = "";
		set = hmC.entrySet();
		for (Map.Entry<String, Cliente> me : set) {
			if (me.getKey().equals(cpf)) {
				result = me.getValue().getNome();
				return result;
			} else {
				result = "Cliente não está no bar!";
			}
		}
		return result;

	}

	public int getTotaldeCliente() {
		return hmC.size();

	}

	public static double arredonda(double valor, int zeros) {
		if (zeros < 0)
			throw new IllegalArgumentException();

		long multiplo = (long) Math.pow(10, zeros);
		valor = valor * multiplo;
		long arredondado = Math.round(valor);
		return (double) arredondado / multiplo;
	}

	public double percFeminino() {
		double total = getTotaldeCliente();
		double totalfem = 0;
		double result = 0;
		set = hmC.entrySet();

		for (Map.Entry<String, Cliente> me : set) {
			if (me.getValue().getGenero().equals("Feminino")) {
				totalfem++;
			}
		}

		result = (totalfem * 100) / total;
		result = arredonda(result, 2);

		// DecimalFormat formato = new DecimalFormat("0.00");
		// result = Float.parseFloat(formato.format(result));
		// System.out.printf("%.2f", result);
		return result;
	}

	public double percMasculino() {
		double total = getTotaldeCliente();
		double totalmas = 0;
		double result = 0;
		set = hmC.entrySet();

		for (Map.Entry<String, Cliente> me : set) {
			if (me.getValue().getGenero().equals("Masculino")) {
				totalmas++;
			}
		}

		result = (totalmas * 100) / total;
		result = arredonda(result, 2);

		// DecimalFormat formato = new DecimalFormat("0.00");
		// result = Float.parseFloat(formato.format(result));
		// System.out.printf("%.2f", result);
		return result;
	}

	public int quantosSocios() {
		int result = 0;
		set = hmC.entrySet();
		for (Map.Entry<String, Cliente> me : set) {
			if (me.getValue().getSocio() == true) {
				result++;
			}
		}
		return result;
	}

	public Object quantosNsocios() {
		int result = 0;
		set = hmC.entrySet();
		for (Map.Entry<String, Cliente> me : set) {
			if (!me.getValue().getSocio() == true) {
				result++;
			}
		}
		return result;
	}
	
	

}
