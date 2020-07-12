package br.com.mogi.justo.converter.servidor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class RendimentosConverterTest {
	
	RendimentosConverter converter = new RendimentosConverter();
	
	@Test
	void deve_remover_o_separador_de_milhar_e_converter_o_valor_em_decimal_para_a_tabela() {
		BigDecimal esperado = new BigDecimal("1999.23");
		BigDecimal rendimentos = converter.convertToDatabaseColumn("1.999,23");
		assertEquals(esperado, rendimentos);
	}
	
	@Test
	void deve_converter_o_valor_em_string_para_a_classe() {
		BigDecimal bd = new BigDecimal("1999.23");
		String rendimentos = converter.convertToEntityAttribute(bd);
		assertEquals("1.999,23", rendimentos);
	}
	
	@Test
	void deve_trocar_o_decimal_do_padrao_brasileiro_para_o_americano() {
		String valor = converter.convertCurrencyPattern("19,99");
		assertEquals("19.99", valor);
	}
	
	@Test
	void deve_retornar_uma_string_vazia_caso_o_valor_a_converter_seja_nulo() {
		String valor = converter.convertCurrencyPattern(null);
		assertEquals("", valor);
	}
	
	@Test
	void deve_remover_o_separador_de_milhar() {
		String rendimentos = converter.removeThousandSeparator("1.000.000,00");
		assertEquals("1000000,00", rendimentos);
	}
	
	@Test
	void deve_retornar_uma_string_vazia_caso_o_parametro_seja_nulo() {
		String rendimentos = converter.removeThousandSeparator(null);
		assertEquals("", rendimentos);
	}
}
