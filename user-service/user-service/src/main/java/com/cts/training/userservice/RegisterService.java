package com.cts.training.userservice;

import java.util.List;

public interface RegisterService {
	public Register insert(Register rd);
	public void deleteById(int id);
	public String activate(String email);
	public Register updateUser(Register users);
	public List<Register> getAllUsers();
	public Register getUserById(int id);
	public RegisterDTO getUserByEmailAndPassword(String email, String password);
	
}
