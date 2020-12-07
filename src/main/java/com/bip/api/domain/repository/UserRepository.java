package com.bip.api.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bip.api.domain.model.User;


// No need implementation, just one interface, and you have CRUD, thanks Spring Data
//https://www.mballem.com/post/nosql-com-mongodb-e-persistencia-em-java/
public interface UserRepository extends MongoRepository<User, String> {

	
	User findBy_id(String id);
	User findByUserTypeAccess(String userTypeAccess);
	User findByEmail(String email);
	
	@Query("{ 'numberAddress' : { $gt: ?0, $lt: ?1 } }")
	List<User> findByNumberAddressBetween(int numberInitial, int numberFinal);
		//CompanyMongoDB findByDomainAndDisplayAds(String company, boolean displayAds);
	@Query("{_id:'?0'}")
	User findCustomByDomain(String user);

    
    
}
