package com.ozair.javaspringbasics.OnlineBanking.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="Accounts")
public class BankAccounts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String accountType;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name= "user_id")
	private User bankuser;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			
			name="bank_users",
			joinColumns = @JoinColumn(name="account_id"),
			inverseJoinColumns = @JoinColumn(name= "user_id")
			
			)

	private List<User> accountOwner;

	public BankAccounts() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(List<User> accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public User getBankuser() {
		return bankuser;
	}
	public void setBankuser(User bankuser) {
		this.bankuser = bankuser;
	}
	
	
}
