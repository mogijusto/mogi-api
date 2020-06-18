package br.com.mogi.justo.converter.servidor;

import java.math.BigDecimal;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RendimentosConverter implements AttributeConverter<String, BigDecimal> {

	@Override
	public BigDecimal convertToDatabaseColumn(String rendimentos) {
		return rendimentos != null ? new BigDecimal(this.convertCurrencyPattern(this.removeThousandSeparator(rendimentos))) : new BigDecimal("0.0");
	}

	@Override
	public String convertToEntityAttribute(BigDecimal rendimentos) {
		return rendimentos != null ? this.convertCurrencyPattern(rendimentos.toString()) : "";
	}
	
	public String convertCurrencyPattern(String valor) {
		if (valor != null) {
			return valor.contains(",") ? valor.replace(",", ".") : valor.replace(".", ",");
		}
		return "";
	}
	
	public String removeThousandSeparator(String valor) {
		return valor != null ? valor.replace(".", "") : "";
	}

}
