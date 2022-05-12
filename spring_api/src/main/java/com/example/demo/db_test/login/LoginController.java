package com.example.demo.db_test.login;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@CrossOrigin(origins = {"http://localhost:8081/"}, allowCredentials = "true")
public class LoginController {

    @Autowired
    UserRepository repository;

    @Autowired
    TokenRepository tokenRepository;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public User UserLogin(@RequestBody UserForm form, HttpServletResponse responce) {
        User user = repository.getByEmail(form.getEmail());

        if(user != null && user.getPassword() == form.getPassword()) {
            
            String tk = generateRandomString(15);

            Token token = new Token();
            token.setUser_id(user.getId());
            token.setToken(tk);
            tokenRepository.save(token);

            Cookie cookie = new Cookie("access_token", tk);
            cookie.setPath("/");
            cookie.setMaxAge(5 * 60);
            responce.addCookie(cookie);
        }else {
            user = null;
        }
        
        return user;
    }


    @RequestMapping(value = "/api/login/check", method = RequestMethod.POST)
    public User LoginChecker(@CookieValue(name = "access_token") String access_token){
        
        Token token = tokenRepository.getByToken(access_token);

        User user = repository.getById(token.getUser_id());
        return user;
    }

    @RequestMapping(value = "api/logout", method = RequestMethod.POST)
    public void UserLogout(@CookieValue(name = "access_token") String access_token, HttpServletRequest request, HttpServletResponse response){

        Token token = tokenRepository.getByToken(access_token);
        tokenRepository.delete(token);
        
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if("access_token".equals(cookie.getName())){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }

    }

    public static String generateRandomString(int len){
		Random r = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890=?";
		String str = "";
		for (int i = 0; i < len; i++) {
			str = str + alphabet.charAt(r.nextInt(alphabet.length()));
		}
		System.out.println(str);

        return str;
    }

    @RequestMapping(value = "/api/users/login/cookie", method = RequestMethod.GET)
    public Object test(@CookieValue(value = "token_test", required = false) String sid){
        return sid;
    }

}
