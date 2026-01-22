package com.manager.helpdesk;

import com.manager.helpdesk.entities.Chamado;
import com.manager.helpdesk.repository.ChamadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(ChamadoRepository repository) {
		return args -> {
			Chamado c1 = new Chamado();
			c1.setTitulo("Internet não funciona");
			c1.setDescricao("O roteador do setor financeiro parou de piscar.");
			c1.setSolicitante("João do RH");
			c1.setPrioridade("ALTA");
			c1.setStatus("ABERTO");

			repository.save(c1);

			System.out.println(">>> Chamado de teste salvo com sucesso!");
		};
	}
}
