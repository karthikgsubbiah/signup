package com.karthik.signupApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karthik.signupApp.model.AppUser;

/**
 * 
 * @author karthikgsubbiah
 *
 *         Dao layer for App user repository
 *
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, String> {

	@Query("FROM AppUser a WHERE a.emailAddress = ?1")
	AppUser findByEmail(String emailAddress);

	@Transactional
	@Modifying
	@Query("UPDATE AppUser a " + "SET a.isEnabled = TRUE WHERE a.emailAddress = ?1")
	int enableAppUser(String emailAddress);
	
	@Transactional
	@Modifying
	@Query("UPDATE AppUser a " + "SET a.isEnabled = FALSE WHERE a.emailAddress = ?1")
	int disableAppUser(String emailAddress);

	@Transactional
	@Modifying
	@Query("UPDATE AppUser a " + "SET a.password = ?2 WHERE a.emailAddress = ?1")
	int updatePassword(String emailAddress, String newPassword);

}
