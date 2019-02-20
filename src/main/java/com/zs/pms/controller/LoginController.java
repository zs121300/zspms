package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.DateUtil;
import com.zs.pms.vo.QueryLogin;
import com.zs.pms.vo.QueryUser;

import oracle.net.aso.MD5;

@Controller//是一个控制器
public class LoginController {
	
	@Autowired
	UserService us;

	@RequestMapping("/tologin.do")
	//去登陆界面
	public String tologin() {
		return "login";
		
	}
	
	@RequestMapping("/login.do")
	//去主页面
	public String login(QueryLogin login,HttpSession session,ModelMap model) {
		//1.验证验证码
		String ocode=(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//生成的验证码和页面的验证码不相等
		if(!ocode.equals(login.getChkcode())) {
			
			model.addAttribute("MSG","验证码输入有误，请重新输入");
			return "login";
		}
			
		
			
			QueryUser query =new QueryUser();
			
			query.setLoginname(login.getUsername());
			//MD5加密
//			MD5 md5 = new MD5();
//			query.setPassword(md5.getMD5ofStr(login.getPassword()));
			query.setPassword(login.getPassword());//密码
			query.setIsenabled(1);
			//返回登录的的用户
			List<TUser> users = us.queryByCon(query);
			//登录失败
			if (users==null||users.size()!=1) {
				model.addAttribute("errmsg","用户名或密码错误请重新输入");
				return "login";
			} 
			//登录成功
			session.setAttribute("USER", users.get(0));
			//session.setAttribute("TIME", DateUtil.getStrDate(birthday));
			return "main";
		
	}
	
	@RequestMapping("/top.do")
	//去顶部页面
	public String top() {
		return "top";
		
	}
	
	@RequestMapping("/left.do")
	//去左页面
	public String left() {
		return "left";
		
	}
	
	@RequestMapping("/right.do")
	//去右页面
	public String right() {
		return "right";
		
	}
}
