package book.manager.controller.page;

import book.manager.entity.AuthUser;
import book.manager.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller

public class AuthPageController {
    @Resource
    UserMapper mapper;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/index")
    public String index(HttpSession Session , Model model){
        AuthUser user= (AuthUser) Session.getAttribute("user");
        if(user==null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = mapper.getPasswordByUsername(authentication.getName());
            Session.setAttribute("user", user);
        }
        model.addAttribute(user);
        return "index";
    }
}
