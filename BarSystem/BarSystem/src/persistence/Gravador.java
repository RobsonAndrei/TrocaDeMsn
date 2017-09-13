package persistence;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import business.Bar;

public class Gravador {
	private String str;

	public Gravador() {
	}

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long begin = System.currentTimeMillis();

	public static void grava(Bar b) throws IOException {
		try (FileWriter fw = new FileWriter("test.txt")) {
			fw.write("Arquivo gravado em : " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
			fw.write("\n");
			fw.write("Total de Clientes: " + b.getTotaldeCliente() + " Clientes");
			fw.write("\n");
			fw.write("Percentual de público feminino: " + b.percFeminino() + "%");
			fw.write("\n");
			fw.write("Percentual de público masculino: " + b.percMasculino() + "%");
			fw.write("\n");
			fw.write("Total de socios: " + b.quantosSocios());
			fw.write("\n");
			fw.write("Total de não socios: " + b.quantosNsocios());
			fw.write("\n");
			fw.write("=========================== Clientes no Bar =======================");
			fw.write("\n");
			fw.write(b.getTodosDados());
			fw.write("\n");
			long end = System.currentTimeMillis();
			fw.write("Tempo de gravação: " + (end - begin) + "ms.");
			// Criando o conteúdo do arquivo
			fw.flush();
			// Fechando conexão e escrita do arquivo.
			fw.close();
		} catch (IOException e) {
			System.out.println("I/O Error: " + e);
		}
	}
}
