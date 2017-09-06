package business;

public class Cliente {
	private String nome, cpf, genero;
	private int idade, n_socio, milhagem;
	private boolean socio;
	

	public Cliente(String n, String cp, int i, String g, boolean sit, int n_soci, int mil) {
		this.nome = n;
		this.cpf = cp;
		this.idade = i;
		this.genero = g;
		this.socio = sit;
		this.n_socio = n_soci;
		this.milhagem = mil;

	}

	public String getCpf() {
		return cpf;
	}

	public String getGenero() {
		return genero;
	}

	public int getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}
	public int getN_socio() {
		return n_socio;
	}

	public void setSocio(boolean socio) {
		this.socio = socio;
	}

	public boolean getSocio() {
		return socio;
	}
	public void setMilhagem(int mi) {
		milhagem = milhagem + mi;
	}
	
	@Override
	public String toString() {
		String result = "";
		result = result = this.nome +"/n"+ this.cpf + "/n" + this.idade+" anos";
		
		return result;
	}
	

}
