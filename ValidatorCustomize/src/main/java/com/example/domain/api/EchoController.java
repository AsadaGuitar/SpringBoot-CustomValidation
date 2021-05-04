package com.example.domain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Account;
import com.example.domain.dao.DaoFactory;

@Controller
@RequestMapping("/echo")
public class EchoController {
	
	@Autowired 
	DaoFactory daoFactory;

	@GetMapping
	public String getEcho(Model model) {
		model.addAttribute(new Account());
		return "input";
	}
	
	@PostMapping
	public String postEcho(@Validated Account account, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors())
			return "input";
		var dao = daoFactory.getAccountDao();
		dao.create(account);
		model.addAttribute(account);
		return "output";
	}
}
