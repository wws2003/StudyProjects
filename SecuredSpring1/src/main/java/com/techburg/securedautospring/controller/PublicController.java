package com.techburg.securedautospring.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RequestMapping(value="/public")

@Controller
public class PublicController {
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String showPublicPage() {
		return "hellopublic";
	}
}