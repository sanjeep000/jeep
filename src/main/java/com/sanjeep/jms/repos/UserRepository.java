package com.sanjeep.jms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeep.jms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	



	User findByEmail(String string);

}
