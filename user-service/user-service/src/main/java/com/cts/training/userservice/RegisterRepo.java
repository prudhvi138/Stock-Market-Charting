package com.cts.training.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<Register, Integer>  {
	public Register findByEmail(String email);

	public Register findByEmailAndPassword(String email, String password);

}
