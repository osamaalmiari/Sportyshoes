package com.SportyShoes.website.repository;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.website.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
