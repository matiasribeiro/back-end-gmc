package br.gmetric.dto;



import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IssueTempoDecorridoConverter implements Converter<Long, String> {

	  @Override
	    public String convert(Long seconds) {
	        
	        // Cria um objeto LocalTime a partir dos segundos
	        LocalTime localTime = LocalTime.ofSecondOfDay(seconds);

	        // Formata o LocalTime em "hh:mm:ss"
	        String formattedTime = localTime.toString();
	        
	        return formattedTime;
	        
	    }

	
}
