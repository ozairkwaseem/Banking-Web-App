package com.ozair.javaspringbasics.OnlineBanking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.OnlineBanking.models.BankAccounts;
import com.ozair.javaspringbasics.OnlineBanking.repositories.BankAccountsRepository;
import com.ozair.javaspringbasics.OnlineBanking.repositories.UserRepository;

@Service
public class BankAccountsService {

	@Autowired
	private BankAccountsRepository bRepo;
	@Autowired 
	private UserRepository uRepo;
	
	
	public List<BankAccounts> getBankAccounts(){
		return this.bRepo.findAll();
	}


	public BankAccounts findBankAccountsById(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
//	public Ideas findUserIdofCreator(long userIdOfCreator) {
//		return this.iRepofind
//	}
	public BankAccounts create(BankAccounts account) {
		return this.bRepo.save(account);
	}
	public BankAccounts update(BankAccounts account) {
		return this.bRepo.save(account);
	}
	public void delete(Long id) {
		this.bRepo.deleteById(id);
	}
	

//	public void addAccountOwner(User user, BankAccounts account) {
//		List<User> accounts = account.getAccounts();
//		accounts.add(user);
//		this.bRepo.save(account);
//	}
//	
//	public void removeLiker(User user, BankAccounts account) {
//		List<User> likers = account.getAccounts();
//		likers.remove(user);
//		this.bRepo.save(account);
//	}

}