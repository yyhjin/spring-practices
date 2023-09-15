package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @RequestMapping 클래스 단독 매핑
 * Spring MVC 4.x 에서만 지원!!
 */

//@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {

	@RequestMapping()
	public String list() {
		return "GuestbookController.list()";
	}
	
	@RequestMapping()
	public String delete() {
		return "GuestbookController.delete()";
	}
	
}
