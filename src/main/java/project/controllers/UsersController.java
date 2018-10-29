package project.controllers;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.module.User;
import project.service.UserServise;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserServise userServise;


    public void setUserServise(UserServise userServise) {
        this.userServise = userServise;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("userAttribute", new User());
        return "addUser";
    }
    @RequestMapping(value = "/removeUser" , method = RequestMethod.GET)
    public String getDelete(@RequestParam(value = "id") long id, Model model) {
        userServise.removeUser(id);
        model.addAttribute("id", id);
        return "redirect:/list";
    }
    @RequestMapping(value = "/changeUser", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "idChange") long id,
                          @RequestParam(value = "nameChange") String name,
                          @RequestParam(value = "ageChange") int age,
                          @RequestParam(value = "loginChange") String login,
                          @RequestParam(value = "passwordChange") String password,
                          @RequestParam(value = "roleChange") String role,
                          Model model, @ModelAttribute("changeUser") User user) {


        model.addAttribute("idChange", id);
        model.addAttribute("nameChange", name);
        model.addAttribute("ageChange", age);
        model.addAttribute("loginChange", login);
        model.addAttribute("passwordChange", password);
        model.addAttribute("roleChange", role);
        model.addAttribute("changeUser", id);
        model.addAttribute("changeUser", name);
        model.addAttribute("changeUser", age);
        model.addAttribute("changeUser", login);
        model.addAttribute("changeUser", password);
        model.addAttribute("changeUser", role);


        return "/changeUser";
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public String listUsers(Model model, HttpSession session) throws IOException {
        if(session.getAttribute("userRole").equals("Admin")) {
            List<User> list = userServise.listUser();
            model.addAttribute("list", list);
            return "list";
        }
        else {
            return "forbidden";
        }
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("userAttribute") User user) {
        userServise.addUser(user);
        return "redirect:/list";
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public String changeUser(@RequestParam(value = "idChange") long id,
                             @RequestParam(value = "nameChange") String name,
                             @RequestParam(value = "ageChange") int age,
                             @RequestParam(value = "loginChange") String login,
                             @RequestParam(value = "passwordChange") String password,
                             @RequestParam(value = "roleChange") String role,
                              Model model, @ModelAttribute("changeUser") User profile) {
        profile.setId(id);
        profile.setName(name);
        profile.setAge(age);
        profile.setLogin(login);
        profile.setPassword(password);
        profile.setRole("User");
        userServise.changeUser(profile);

//        model.addAttribute("idChange", id);
//        model.addAttribute("nameChange", name);
//        model.addAttribute("ageChange", age);
//        model.addAttribute("loginChange", login);
//        model.addAttribute("passwordChange", password);
//        model.addAttribute("roleChange", role);
        return "redirect:/list";
    }
    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String getRegist(Model model) {
        model.addAttribute("registAttribute", new User("User"));
        return "registration";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@ModelAttribute("registAttribute") User user) {
        user.setRole("User");
        userServise.registrUser(user);
        return "redirect:/registred";
    }
    @RequestMapping(value = "/registred", method = RequestMethod.GET)
    public String registred() {
        return "registred";
    }



    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String enter(@RequestParam("login") String login,
                            @RequestParam("password") String password,
                            Model model, HttpSession session) {
        model.addAttribute("login", login);
        model.addAttribute("password", password);
        User profile = userServise.getUserLogin(login);
        if(profile.getPassword()!=null && profile.getLogin()!=null && profile.getPassword().equalsIgnoreCase(password)) {
            if (profile.getRole().equalsIgnoreCase("user")) {
                session.setAttribute("userRole", profile.getRole());
                return "forAuthorizingUser";

            }
            else if (profile.getRole().equalsIgnoreCase("admin")) {
                session.setAttribute("userRole", profile.getRole());
                return "redirect:/list";
            } else {
                return "redirect:/index";
            }
        } else {
            return "redirect:/index";
        }
    }


}
