package com.example.demo.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}

