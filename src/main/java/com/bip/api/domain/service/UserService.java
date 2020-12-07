package com.bip.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;

import com.bip.api.domain.model.User;

public interface UserService {

	/**
	 * Retorna uma lista paginada de lançamentos de um determinado funcionário.
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	//Page<User> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna um lançamento por ID.
	
	 * @param id
	 * @return Optional<User>
	 */
	Optional<User> buscarPorId(String id);
	/**
	 * Persiste um lançamento na base de dados.
	 * 
	 * @param User
	 * @return User
	 */
	User insert(User user);
	/**
	 * Persiste um lançamento na base de dados.
	 * 
	 * @param User
	 * @return User
	 */
	User upDate(User user) ;
	/**
	 * Remove um lançamento da base de dados.
	 * 
	 * @param user
	 */
    void deletar(User user);
   
    List<User> findAll();
	/**
	 * Remove um lançamento da base de dados.
	 * 
	 */
    long count();
    Optional<User> findBy_id(String id);
 	User findByUserTypeAccess(String userTypeAccess);
 	User findByEmail(String email);
 	
 	@Query("{ 'numberAddress' : { $gt: ?0, $lt: ?1 } }")
 	List<User> findByNumberAddressBetween(int numberInitial, int numberFinal);
 		//CompanyMongoDB findByDomainAndDisplayAds(String company, boolean displayAds);
 	@Query("{_id:'?0'}")
 	User findCustomByDomain(String user);
	
}
