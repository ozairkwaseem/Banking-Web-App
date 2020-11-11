package com.ozair.javaspringbasics.OnlineBanking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozair.javaspringbasics.OnlineBanking.models.BankAccounts;

@Repository
public interface BankAccountsRepository extends CrudRepository<BankAccounts, Long>{
	List <BankAccounts> findAll();

}
