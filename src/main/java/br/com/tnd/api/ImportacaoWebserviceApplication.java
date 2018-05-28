package br.com.tnd.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImportacaoWebserviceApplication {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ImportacaoWebserviceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Kazale IT");
			empresa.setCnpj("01564564564564");

			this.empresaRepository.save(empresa);

			Empresa empresa1 = new Empresa();
			empresa1.setRazaoSocial("Nutit");
			empresa1.setCnpj("13213215348545");

			this.empresaRepository.save(empresa1);
		};
	}
}
