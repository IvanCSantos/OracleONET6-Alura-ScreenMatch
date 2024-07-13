package br.alura.com.screenmatch;

import br.alura.com.screenmatch.model.DadosSerie;
import br.alura.com.screenmatch.service.ConsumoAPI;
import br.alura.com.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://start.spring.io/
@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();

		var json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
		ConverteDados conversor = new ConverteDados();
		DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(serie);
	}
}
