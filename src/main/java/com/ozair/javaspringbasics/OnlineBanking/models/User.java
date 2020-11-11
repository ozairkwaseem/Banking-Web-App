package com.ozair.javaspringbasics.OnlineBanking.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	@Size(max=55)
	private String email;
	@NotBlank
	@Size(min=8)
	private String password;
	@Transient
	private String passwordValidation;
	@OneToMany(mappedBy="bankuser", cascade = CascadeType.ALL, 	fetch=FetchType.LAZY)
	private List<BankAccounts> accountsCreated;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			
			name="bank_users",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name= "account_id")
			
			)
	
	private List<BankAccounts> accountOwners;

	public User() {
}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordValidation() {
		return passwordValidation;
	}


	public void setPasswordValidation(String passwordValidation) {
		this.passwordValidation = passwordValidation;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public List<BankAccounts> getAccountsCreated() {
		return accountsCreated;
	}


	public void setAccountsCreated(List<BankAccounts> accountsCreated) {
		this.accountsCreated = accountsCreated;
	}


	public List<BankAccounts> getAccountOwners() {
		return accountOwners;
	}


	public void setAccountOwners(List<BankAccounts> accountOwners) {
		this.accountOwners = accountOwners;
	}


}