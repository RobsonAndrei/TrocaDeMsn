package uinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.plaf.synth.SynthSeparatorUI;
import business.Bar;
import business.Cliente;
import persistence.Gravador;

public class Sistema {
	private static Bar b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aux;
		Sistema s = new Sistema();
		b = new Bar();
		aux = "";
		while (!aux.equals("10")) {

			System.out.println("============== Sistema do bar aberto: =============\n");
			System.out.println("============== menu ===============================");
			System.out.println("\t\t[0]-Inserir Cliente\n\t\t[1]-Quem está no bar\n\t\t[2]-Busca cliente"
					+ "\n\t\t[3]-Total de pessoas" + "\n\t\t[4]-Porcentagem feminina"
					+ "\n\t\t[5]-Porcentagem masculina" + "\n\t\t[6]-Quantos sócios" + "\n\t\t[7]-Qantos não sócios"
					+ "\n\t\t[8]-Confirmar saída" + "\n\t\t[9]-Gravar dados" + "\n\t\t[10]-Sair do sistema!!");
			aux = br.readLine();

			switch (aux) {
			case "0":
				System.out.print("Digite os dados do Cliente:\nNome: ");
				String nome = br.readLine();
				System.out.print("CPF: ");
				String cpf = br.readLine();
				System.out.print("idade: ");
				String idade = br.readLine();
				int i = Integer.parseInt(idade);
				System.out.println("Genero: \t1 = Feminino\n\t\t2 = Masculino");
				String g = br.readLine();
				switch (g) {
				case "1":
					g = "Feminino";
					break;
				case "2":
					g = "Masculino";
					break;
				default:
					System.out.println("Erro");
					break;
				}
				System.out.println("É sócio?: \t1 = SIM\n\t\t2 = NÃO");
				String soc = br.readLine();
				boolean socio = false;
				int numeroSocio;
				int milhas = 0;
				if (soc.equals("1")) {
					socio = true;
					System.out.print("\nInsira o número de socio: ");
					String ns = br.readLine();
					numeroSocio = Integer.parseInt(ns);
					System.out.println("Quer pontos para milhas?: \t1 = SIM\n\t\t\t\t\t\t2 = NÃO");
					String mil = br.readLine();
					if (mil.equals("1")) {
						System.out.print("Insira a quantidade de ptos: ");
						String milh = br.readLine();
						milhas = Integer.parseInt(milh);
					} else {
						milhas = 0;
					}

				} else {
					socio = false;
					numeroSocio = 0;
				}
				Cliente c = new Cliente(nome, cpf, i, g, socio, numeroSocio, milhas);
				b.entrada(c);

				break;
			case "1":
				System.out.println("Estão no bar\n");
				System.out.println(b.quemEstanoBar());
				break;
			case "2":
				System.out.print("Insira o cpf do cliente: ");
				String aux2 = br.readLine();
				boolean ok = b.cpfEstanoBar(aux2);
				if (!ok) {
					System.out.println("Cliente não está no bar");
				} else {
					String cliente = b.getClientePeloCpf(aux2);
					System.out.println("Cliente " + cliente + " esta no bar");
				}
				break;

			case "3":
				System.out.println("TOTAL DE PESSOAS = " + b.getTotaldeCliente());
				break;

			case "4":
				System.out.println("Público feminino: " + b.percFeminino() + "%");
				break;
			case "5":
				System.out.println("Público masculino: " + b.percMasculino() + "%");
				break;
			case "6":
				System.out.println("Total de sócios: " + b.quantosSocios());
				break;
			case "7":
				System.out.println("Total de não sócios: " + b.quantosNsocios());

				break;
			case "8":
				System.out.println("Informe o CPF para validar a saida: ");
				String aux3 = br.readLine();
				boolean sai = b.saida(aux3);
				if (sai == true) {
					System.out.println("Saida confirmada!");
				} else {
					System.out.println("Saída não confirmada!!");
				}
				break;
			case "9":
				Gravador.grava(b);
				break;
			case "10":
				System.out.println("Saindo.....");
				break;

			default:
				break;
			}
		}

	}
}
