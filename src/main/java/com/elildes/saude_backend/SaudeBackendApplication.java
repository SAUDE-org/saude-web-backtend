package com.elildes.saude_backend;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaudeBackendApplication {

	public static void main(String[] args) {
		// Verifica a configuração regional
        Locale currentLocale = Locale.getDefault();
        System.out.println("Localidade configurada: " + currentLocale);
		SpringApplication.run(SaudeBackendApplication.class, args);
	}

}
