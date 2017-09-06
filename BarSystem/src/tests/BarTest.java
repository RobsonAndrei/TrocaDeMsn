package tests;
import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

import business.Bar;
import business.Cliente;

public class BarTest {
	private Bar b;
	private Cliente c, c1, c2, c3, c4, c5;

	@Before
	public void setUp() throws Exception {
		b = new Bar();
		c = new Cliente("Robson", "76425584068", 24, "Masculino", true, 22, 10);
		c1 = new Cliente("Amanda", "12309884790", 34, "Feminino", false, 0, 0);
		c2 = new Cliente("Ricardo", "09594893840", 56, "Masculino", true, 345, 100);
		c3 = new Cliente("Amarildo", "84794894812", 45, "Masculino", false, 0, 0);
		c4 = new Cliente("Maria", "93894884398", 24, "Feminino", true, 454, 200);
		c5 = new Cliente("Paulo", "48594894809", 20, "Masculino", true, 8457, 100);
	}

	@Test
	public void validarEntradaClient() {
		boolean in, in1, in2, in3, in4, in5 = false;
		in = b.validaEntrada(c);
		in1 = b.validaEntrada(c1);
		in2 = b.validaEntrada(c2);
		in3 = b.validaEntrada(c3);
		in4 = b.validaEntrada(c4);
		in5 = b.validaEntrada(c5);

		assertEquals(true, in);
		assertEquals(true, in1);
		assertEquals(true, in2);
		assertEquals(true, in3);
		assertEquals(true, in4);
		assertEquals(true, in5);
	}

	@Test
	public void quemEstanoBar() {

		b.validaEntrada(c);
		b.validaEntrada(c1);
		b.validaEntrada(c2);
		b.validaEntrada(c3);
		b.validaEntrada(c4);
		b.validaEntrada(c5);
		String s = b.quemEstanoBar();
		String s2 = "Teste";
		assertEquals(s, b.quemEstanoBar());
	}

	@Test
	public void getClientePeloCpf() {

		b.validaEntrada(c);
		b.validaEntrada(c1);
		b.validaEntrada(c2);
		b.validaEntrada(c3);
		b.validaEntrada(c4);
		b.validaEntrada(c5);

		String cpf = "93894884398";
		String result = b.getClientePeloCpf(cpf);
		assertEquals("Maria", result);
	}
	@Test
	public void getTotaldeCliente() {
		b.validaEntrada(c);
		b.validaEntrada(c1);
		b.validaEntrada(c2);
		b.validaEntrada(c3);
		b.validaEntrada(c4);
		b.validaEntrada(c5);
		int total = 6;
		assertEquals(b.getTotaldeCliente(), total);
		
	}
	@Test
	public void percFeminino() {
		b.validaEntrada(c);
		b.validaEntrada(c1);
		b.validaEntrada(c2);
		b.validaEntrada(c3);
		b.validaEntrada(c4);
		b.validaEntrada(c5);
		double percFem = 33.33;
		assertEquals(percFem, b.percFeminino(), 0.001);
		
	}
	@Test
	public void percMasculino() {
		b.validaEntrada(c);
		b.validaEntrada(c1);
		b.validaEntrada(c2);
		b.validaEntrada(c3);
		b.validaEntrada(c4);
		b.validaEntrada(c5);
		double percFem = 66.67;
		assertEquals(percFem, b.percMasculino(), 0.001);
		
	}
	
	@Test
	public void quantosSocios() {
		b.validaEntrada(c);
		b.validaEntrada(c1);
		b.validaEntrada(c2);
		b.validaEntrada(c3);
		b.validaEntrada(c4);
		b.validaEntrada(c5);
		int s = 12;
		assertEquals(b.quantosSocios(), s);
		
	}
	@Test
	public void quantosNsocios() {
		b.validaEntrada(c);
		b.validaEntrada(c1);
		b.validaEntrada(c2);
		b.validaEntrada(c3);
		b.validaEntrada(c4);
		b.validaEntrada(c5);
		int s = 2;
		assertEquals(b.quantosNsocios(), s);
		
	}

}
