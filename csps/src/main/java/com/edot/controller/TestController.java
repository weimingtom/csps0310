package com.edot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edot.api.response.TestListResponse;
import com.edot.service.TestService;
import com.edot.web.request.TestEditReqeust;

import java.util.List;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		List<TestListResponse> list = testService.list();
		model.addAttribute("list", list);
		return "test/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("user_id") Long userId, Model model) throws Exception {
		TestListResponse response = testService.detail(userId);
		model.addAttribute("test", response);
		return "test/detail";
	}
	
	@RequestMapping(value = "/preEdit", method = RequestMethod.GET)
	public String preEdit() {
		return "test/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(TestEditReqeust request, Model model) throws Exception {
		TestListResponse response = testService.edit(request);
		model.addAttribute("test", response);
		return "redirect:/detail?user_id=" + response.getId();
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.GET)
	public String deleteById(@RequestParam("user_id") Long userId) throws Exception{
		testService.deleteById(userId);
		return "redirect:/list";
	}
}
