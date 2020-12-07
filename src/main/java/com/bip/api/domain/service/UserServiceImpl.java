package com.bip.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bip.api.domain.model.User;
import com.bip.api.domain.repository.UserRepository;
import com.bip.domain.exception.NegocioException;


@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	private User userExistente;
	
	public User insert(User user) {
		userExistente = userRepository.findByEmail(user.getEmail());
		if (userExistente != null && !userExistente.equals(user)) {
			throw new NegocioException("Esta empresa encontra-se cadastrada. ");
		}
	
		return userRepository.save(user);
	}
	
	//@CachePut("lancamentoPorId")
	public User upDate(User user) {
		userExistente = userRepository.findByEmail(user.getEmail());
		if (userExistente == null && userExistente.equals(user)) {
			throw new NegocioException("Esta empresa não está cadastrada. ");
		}
		return userRepository.save(user);
	}
	
   public void deletar(User user) {
	   userRepository.delete(user);
   }
   
   public List<User> findAll() {
      return userRepository.findAll();
   }

   public long count() {
       return userRepository.count();
   }

   //@Cacheable("lancamentoPorId")
   @Override
   public Optional<User> findBy_id(String id) {
	   log.info("Buscando pelo ID do usuário. ", id);
	   return Optional.ofNullable(userRepository.findBy_id(id));
   }

   @Override
   public User findByUserTypeAccess(String userTypeAccess) {
	 log.info("Buscando tipo de acesso {}", userTypeAccess);
	 return userRepository.findByUserTypeAccess(userTypeAccess);
   }

   @Override
   public User findByEmail(String email) {
	   log.info("Buscando e-mail do usuário.", email);
	   return userRepository.findByEmail(email);
   }

   @Override
   public List<User> findByNumberAddressBetween(int numberInitial, int numberFinal) {
	// TODO Auto-generated method stub
	   log.info("Buscando endereço do usuário.", numberInitial);
	return userRepository.findByNumberAddressBetween(numberInitial, numberFinal);
   }

   @Override
   public User findCustomByDomain(String user) {
	// TODO Auto-generated method stub
	log.info("Buscando usuário.", user);
	return userRepository.findCustomByDomain(user);
   }

@Override
public Optional<User> buscarPorId(String id) {
	// TODO Auto-generated method stub
	return null;
}
  

}
