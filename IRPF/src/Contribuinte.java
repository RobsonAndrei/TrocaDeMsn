
public class Contribuinte {
	private String nome, cpf;
	private int idade, n_dependent;
	private static double cont_prev_ofic, rendiment;
	
	public Contribuinte(String name, String c_f, int ida_d, int n_dep) {
		this.nome = name;
		this.cpf = c_f;
		this.idade = ida_d;
		this.n_dependent = n_dep;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public int getIdade() {
		return idade;
	}
	public int getN_dependent() {
		return n_dependent;
	}
	public void setN_dependent(int n_dependent) {
		this.n_dependent = n_dependent;
	}
	public static void setCont_prev_ofic(double cont_prev_ofic) {
		Contribuinte.cont_prev_ofic = cont_prev_ofic;
	}
	public static void setRendiment(double rendiment) {
		Contribuinte.rendiment = rendiment;
	}
	public static double getCont_prev_ofic() {
		return cont_prev_ofic;
	}
	public static double getRendiment() {
		return rendiment;
	}
}
