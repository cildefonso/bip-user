package com.bip.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bip.api.domain.model.User;
import com.bip.api.domain.service.UfCacheService;
import com.bip.api.domain.service.UserService;
/* Teste de stress e performace com Apache Ab
   ab -n 10000 -c 100 http://localhost:8080/api/companymongodb/
*/

@RestController
@EnableCaching
@RequestMapping("/api/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private UfCacheService ufCacheService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/email/{strEmail:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<User> findByEmail(@PathVariable ("strEmail") String strEmail) {
		System.out.println("--------------------------------");
		User user = userService.findByEmail(strEmail);
		System.out.println("Informações da empresa "+ user);
		log.info("Informações da empresa "+ user);
		
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(user == null)) {
		   return ResponseEntity.ok(user);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	
	@PostMapping(value = "/", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<User> register(@Valid @RequestBody User user) {
		if ((user == null )) {
			return ResponseEntity.notFound().build();
		}
		User userDB = userService.insert(user);
		
		return ResponseEntity.ok(userDB);
	}
	
	@PutMapping(value = "/{strEmail}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<User> change(@Valid @PathVariable ("strEmail") String strEmail, @RequestBody User user){
		
		if ((user == null )) {
			return ResponseEntity.notFound().build();
		}
		//companyMongoDB.setCnpj(strCnpj);
		User userDB = userService.upDate(user);
		
		
		return ResponseEntity.ok(userDB);
	}
	
	@DeleteMapping(value = "/{strEmail}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Void> deletar(@PathVariable String strEmail){
		User user = userService.findByEmail(strEmail);
		
		if ((user == null)) {
			return ResponseEntity.notFound().build();
			
		}
		userService.deletar(user);
	
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "email/v4/{strEmail}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<User> buscarV1(@PathVariable ("strEmail") String strEmail) {
		User userDB = new User();
		userService.findAll().forEach(System.out::println);
		System.out.println();
	
		System.out.println("--------------------------------");
		userService.findByNumberAddressBetween(18, 90).forEach(System.out::println);
		System.out.println("--------------------------------");
		
		System.out.println("Executando serviço pela primeira vez: ");
		System.out.println(this.ufCacheService.lisUfCache());
		
		System.out.println("Executando serviço pela segunda vez, deve obter dados do cache: ");
		System.out.println(this.ufCacheService.lisUfCache());
	    
	    return ResponseEntity.ok(userDB);	
	}
	
	

}
