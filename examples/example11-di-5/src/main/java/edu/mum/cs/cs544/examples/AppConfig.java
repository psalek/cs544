package edu.mum.cs.cs544.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	@Bean
	@Lazy(true)
	public AccountService accountService() {
		AccountService accountService = new AccountService();
		accountService.setAccountDAO(accountDAO());
		
		return accountService;
	}
	
	@Bean
	@Scope(value="prototype")
	public AccountDAO accountDAO() {
		return new AccountDAOImpl();
	}

}
