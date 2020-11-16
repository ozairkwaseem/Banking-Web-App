package com.ozair.javaspringbasics.OnlineBanking.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozair.javaspringbasics.OnlineBanking.models.BankAccounts;
import com.ozair.javaspringbasics.OnlineBanking.models.User;
import com.ozair.javaspringbasics.OnlineBanking.repositories.BankAccountsRepository;
import com.ozair.javaspringbasics.OnlineBanking.repositories.UserRepository;
import com.ozair.javaspringbasics.OnlineBanking.services.BankAccountsService;
import com.ozair.javaspringbasics.OnlineBanking.services.UserService;


@Controller
@RequestMapping("/home")
public class BankAccountsController {
	@Autowired
	private BankAccountsRepository bRepo;
	@Autowired 
	private UserRepository uRepo;
	@Autowired
	private BankAccountsService bService;
	@Autowired
	private UserService uService;
	
	
	@GetMapping("")
	public String home(@ModelAttribute("bankaccounts") BankAccounts bankaccounts, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userid");
		
		model.addAttribute("userId", userId);
		if(userId == null) {

			return "redirect:/";}
		User user = this.uService.findById(userId);
		model.addAttribute("user", user);
		model.addAttribute("accountowner", this.bService.findBankAccountsById(userId));
		model.addAttribute("bankaccounts", user.getAccountsCreated());
		
		return "/banking/home.jsp";
	}
	
	@GetMapping ("/createform")
	public String createform(@ModelAttribute("bankaccounts") BankAccounts bankaccounts, Model model, HttpSession session ) {
		Long userId = (Long)session.getAttribute("userid");
		model.addAttribute("userId", userId);
		User user = this.uService.findById(userId);
		model.addAttribute("user", user);
		return "/banking/create.jsp";
	}
	@PostMapping("/createbankaccount")
	public String createBankAccount( @ModelAttribute("bankaccounts") BankAccounts bankaccounts, BindingResult result, Model model, HttpSession session)
	
	{ if(result.hasErrors()) {
		Long userId = (Long)session.getAttribute("userid");
		model.addAttribute("userId", userId);
		User user = this.uService.findById(userId);
		model.addAttribute("user", user);
		return "/ideas/newidea.jsp";
	}
	this.bService.create(bankaccounts);
	return"redirect:/home";
		
	}
	public Long userSessionId(HttpSession session) {
		if(session.getAttribute("user") == null)
			return null;
		return (Long)session.getAttribute("user");
	}
	
	@GetMapping ("/update")
	public String updateAccount(@ModelAttribute("bankaccounts") BankAccounts bankaccounts, Model model, HttpSession session ) {
		Long userId = (Long)session.getAttribute("userid");
		model.addAttribute("userId", userId);
		User user = this.uService.findById(userId);
		model.addAttribute("user", user);
		return "/banking/update.jsp";
	}
//	@PostMapping("/depositchecking")
//	public String depositChecking( @ModelAttribute("bankaccounts") BankAccounts bankaccounts, BindingResult result, Model model, HttpSession session)
//	
//	{ if(result.hasErrors()) {
//		Long userId = (Long)session.getAttribute("userid");
//		BankAccounts checking = new BankAccounts();
//		Double currentCheckingBalance =checking.getCheckingBalance();
//		Double newCheckingBalance = currentCheckingBalance + depositAmount;		
//		
//		model.addAttribute("userId", userId);
//		User user = this.uService.findById(userId);
//		model.addAttribute("user", user);
//		return "/banking/home.jsp";
//	}
//	Long accountId = (Long)session.getAttribute("accountId");
//
//	BankAccounts account = this.bService.findBankAccountsById(accountId);
//	
//	model.addAttribute("accountId", accountId);
//	this.bService.update(bankaccounts);
//	return"redirect:/home";
//		
//	}
	@GetMapping("/{id}/depositchecking")
	public String depositChecking(@PathVariable("id")Long id, BankAccounts deposit, HttpSession session, Model model )
	{ 
		Long userId = (Long)session.getAttribute("userid");
		User user = this.uService.findById(userId);
		model.addAttribute("bankaccounts", user.getAccountsCreated());
		BankAccounts currentAccount = this.bService.findBankAccountsById(id);
		Double currentCheckingBalance = currentAccount.getCheckingBalance();
		currentCheckingBalance = currentCheckingBalance + currentAccount.getCheckingBalance(currentAccount);
		currentAccount.setCheckingBalance(currentAccount.getCheckingBalance());
				
		this.bService.update(currentAccount);
		
		return "/redirect:/home";
	}
	
	
	
	
	
	
//	public Long userSessionId(HttpSession session) {
//		if(session.getAttribute("user") == null)
//			return null;
//		return (Long)session.getAttribute("user");
//	}
//	
//	@GetMapping ("/deposit")
//	public String deposit(@ModelAttribute("bankaccounts") BankAccounts bankaccounts, Model model, HttpSession session ) {
//		Long userId = (Long)session.getAttribute("userid");
//		model.addAttribute("userId", userId);
//		User user = this.uService.findById(userId);
//		model.addAttribute("user", user);
//		this.bService.create(bankaccounts);
//		return "/banking/home.jsp";
//	}
	

//	@GetMapping("/{id}")
//	public String viewIdea(@PathVariable("id")Long id, HttpSession session, Model model) {
////		System.out.println("SHOWWWW");
//
//		Long userId = this.userSessionId(session);
//		BankAccounts bankaccounts = this.bService.findBankAccountsById(id);
//		model.addAttribute("bankaccounts", bankaccounts);
//		return "/ideas/showidea.jsp";
//	
//	}
//	@GetMapping("/{id}/editselected")
//	
//	public String editBankAccounts(@PathVariable("id")Long id, HttpSession session, Model model) {
////		System.out.println("SHOWWWW");
//		Long userId = this.userSessionId(session);
//		BankAccounts bankaccounts = this.bService.findBankAccountsById(id);
//		model.addAttribute("bankaccounts", bankaccounts);
//		return "/ideas/editidea.jsp";
//	
//	}
	
//	
	

//	
//	@GetMapping("/{id}/delete")
//	public String deleteIdea(@PathVariable("id")Long id) {
////		System.out.println("delete!!1");
//		this.bService.delete(id);
//		return "redirect:/home ";
//	}
	
}