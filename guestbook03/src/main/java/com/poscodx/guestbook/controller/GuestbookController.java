package com.poscodx.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscodx.guestbook.repository.GuestbookRepository;
import com.poscodx.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("/")
	public String main(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "main";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable int no, Model model) {
		model.addAttribute("no", no);
		return "delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(int no, String password) {
		if(password.equals(guestbookRepository.findPasswordByNo(no))) {
			guestbookRepository.deleteByNo(no);	
		}
		return "redirect:/";
	}

}
