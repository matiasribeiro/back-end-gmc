package br.gmetric.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gmetric.dto.IssueDTO;
import br.gmetric.model.Issue;
import br.gmetric.model.IssueEvents;
import br.gmetric.model.view.IssueDatasContribuinteView;
import br.gmetric.model.view.IssueEventsView;
import br.gmetric.model.view.IssueMes;
import br.gmetric.model.view.IssueView;
import br.gmetric.model.view.TempoDeIssueView;
import br.gmetric.repository.RepositorioIssuesCustomizado;
import br.gmetric.repository.impl.RepositorioIssueEventsCustomizadoImpl;
import br.gmetric.repository.impl.RepositorioIssuesCustomizadoImpl;



@Service
public class IssuesService {

	@Autowired
	private RepositorioIssueEventsCustomizadoImpl repositorioIssueEventsCustomizadoImpl;
	
	@Autowired
	private RepositorioIssuesCustomizadoImpl repositorioIssueCustomizadoImpl;
	
	
	

	public List<IssueDTO> tempoDecorrido() {
		
		return repositorioIssueEventsCustomizadoImpl.calcularTempoDecorrido();
	
		
	}
	
	
	
	public List<IssueDatasContribuinteView> consultaIssueDatasContribuinte() {
		
		List<IssueDatasContribuinteView> issues = repositorioIssueCustomizadoImpl.getDatasIssuePorContribuinte(16290306L);

		for (IssueDatasContribuinteView i : issues) {
		
			i.setTempoDeIssue(converterTimeStamp(i));	
			i.setTimestampAbertura(formatarDataPadraoBrasil(i.getTimestampAbertura()));
			i.setTimestampFechamento(formatarDataPadraoBrasil(i.getTimestampFechamento()));	
		}
		
		return issues;		
	}
	
	

	
	public Map<Object, Map<String, Long>> consultaQuantMes(String ano) {
		
		List<Issue> issues = repositorioIssueEventsCustomizadoImpl.getIssueEventsPorAno(ano);
		
	
//		for (IssueEvents i : issues) {
//			
//			
//			LocalDateTime localdatetime = LocalDateTime.parse(i.getDataFechamento().replace("Z", ""));
//			
//			
//			System.out.println(localdatetime.getMonthValue());
//			
//		}
//		
		
//		Map<Object,Map<String,Long>> mapa = issues.stream()
//				.collect(Collectors.groupingBy(e -> LocalDateTime.parse(e.getDataFechamento().replace("Z", "")).getMonthValue(), 
//						Collectors.groupingBy(IssueEvents::getNomeRepositorio, Collectors.counting())
//						));

		
		//fruits.stream().collect(Collectors.groupingBy( fruit -> new TypeQuantity(fruit.getType(), fruit.getQuantity())));
	
		
		Map<Object, Map<String, Long>> mapa = issues.stream()
				.collect(
						Collectors.groupingBy( 
						e -> LocalDateTime.parse(e.getDataAbertura().replace("Z", "")).getMonthValue(),
						Collectors.groupingBy(Issue::getNomeRepositorio, Collectors.counting() )
						 ));
	

//		Map<Long,List<IssueEvents>> mapa = issues.stream()
//				.collect(groupingBy(IssueView::getId,IssueView::getNomeRepositorio, 
//						Collectors.groupingBy(e -> LocalDateTime.parse(e.getDataFechamento().replace("Z", "")).getMonthValue())));				
//		
//		
		
//		 Map<Object,List<IssueEvents>> mapa = issues.stream()
//				.collect(Collectors.groupingBy(e -> new IssueView(e.getNomeRepositorio(), 
//						LocalDateTime.parse(e.getDataFechamento().replace("Z", "")).getMonthValue(),
//						Collectors.counting().toString()) 
//				));
		
		return mapa;

		
	}


	public TempoDeIssueView converterTimeStamp(IssueDatasContribuinteView issueDatas ) {
		
		
		final int SECONDS_PER_HOUR = 3600;
		final int SECONDS_PER_MINUTE = 60;
		
		TempoDeIssueView tempoIssueView = new TempoDeIssueView();
		
		LocalDateTime fromDateTime = LocalDateTime.parse(issueDatas.getTimestampAbertura());
		LocalDateTime toDateTime = LocalDateTime.parse(issueDatas.getTimestampFechamento());
		
		Period period = Period.between(fromDateTime.toLocalDate(), toDateTime.toLocalDate());
		Duration duration = Duration.between(fromDateTime.toLocalTime(), toDateTime.toLocalTime());

		if (duration.isNegative()) {
		    period = period.minusDays(1);
		    duration = duration.plusDays(1);
		}
		
		long seconds = duration.getSeconds();
		long hours = seconds / SECONDS_PER_HOUR;
		long minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE);
		long secs = (seconds % SECONDS_PER_MINUTE);
		long time[] = {hours, minutes, secs};
		
		tempoIssueView.setAno(period.getYears());
		tempoIssueView.setMes(period.getMonths());
		tempoIssueView.setDia(period.getDays());
		
		tempoIssueView.setHora(time[0]);
		tempoIssueView.setMinuto(time[1]);
		tempoIssueView.setSegundo(time[2]);
	
		return tempoIssueView;
		
	}

	public String formatarDataPadraoBrasil(String dataSemFormatacao) {
		
		LocalDateTime data = LocalDateTime.parse(dataSemFormatacao);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				
		return data.format(formatter);
	}
	
}
