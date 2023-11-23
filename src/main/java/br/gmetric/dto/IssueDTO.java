package br.gmetric.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Field;

import br.gmetric.model.Issue;
import br.gmetric.model.Usuario2;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Field(name="_id")
	private Long id;
	
	@Field(name="tempoDecorrido")
	private Long tempoDecorrido;
	
	@Field(name="login")
	private String login;

	public IssueDTO () {}
	
	public String getTempoDecorrido() {
		
        SimpleDateFormat sdf = new SimpleDateFormat("dd HH:mm:ss");
        Date date = new Date(tempoDecorrido);
        
        return sdf.format(date);
	
	}
	

}
