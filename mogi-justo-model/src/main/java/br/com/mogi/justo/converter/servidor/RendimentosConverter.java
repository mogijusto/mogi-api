package br.com.mogi.justo.converter.servidor;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RendimentosConverter implements AttributeConverter<String, BigDecimal> {

	private static final DecimalFormat BRL = new DecimalFormat("###,###.00");
	
	@Override
	public BigDecimal convertToDatabaseColumn(String rendimentos) {
		return rendimentos != null ? new BigDecimal(this.convertCurrencyPattern(this.removeThousandSeparator(rendimentos))) : new BigDecimal("0.0");
	}

	@Override
	public String convertToEntityAttribute(BigDecimal rendimentos) {
		return rendimentos != null ? BRL.format(rendimentos) : "";
	}
	
	public String convertCurrencyPattern(String valor) {
		return valor != null ? valor.replace(",", ".") : "";
	}
	
	public String removeThousandSeparator(String valor) {
		return valor != null ? valor.replaceAll("\\.", "") : "";
	}

}
