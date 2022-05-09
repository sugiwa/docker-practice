package com.example.demo.db_test.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.db_test.User;
import com.example.demo.db_test.UserForm;
import com.example.demo.db_test.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8081/"})
public class LoginController {

    @Autowired
    UserRepository repository;

    @RequestMapping(value = "/api/users/login", method = RequestMethod.POST)
	public User UserLogin(@RequestBody UserForm form, HttpServletResponse responce) {
        User user = repository.getByEmail(form.getEmail());

        String token = null;
        
        if(user.getPassword() == form.getPassword()) {
            
            token = "thisisthetoken!";

            Cookie cookie = new Cookie("token_test", token);
            cookie.setPath("http://localhost:8080/");
            cookie.setMaxAge(1000 * 60);
            responce.addCookie(cookie);
        }else {
            user = null;
        }
        
        return user;
    }

    @RequestMapping(value = "/api/users/login/cookie", method = RequestMethod.GET)
    public Object test(@CookieValue(value = "token_test", required = false) String sid){
        return sid;
    }

}
