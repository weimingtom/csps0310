package com.edot.controller;

import com.edot.model.UserInfoModel;
import com.edot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserInfoController extends BaseController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<UserInfoModel> list() {
		return userInfoService.list();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody
	public UserInfoModel detail(@RequestParam(value = "user_id") long userId) {
		return userInfoService.get(userId);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public void delete(@RequestParam(value = "user_id") long userId) {
		userInfoService.delete(userId);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public UserInfoModel insert(@RequestBody UserInfoModel userInfo) {
		userInfoService.saveOrUpdate(userInfo);
		return userInfo;
	}

}
