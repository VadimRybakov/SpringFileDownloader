package ru.vadimio.FileManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vadimio.FileManager.dto.UserDto;
import ru.vadimio.FileManager.entities.Role;
import ru.vadimio.FileManager.entities.User;
import ru.vadimio.FileManager.service.RoleService;
import ru.vadimio.FileManager.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login_page";
    }

    @GetMapping("/users")
    public String getUsers(Model model, @RequestParam(required = false) String login) {
        if(login != null) {
            User user = userService.findByLogin(login);
            UserDto userDto = new UserDto(user.getLogin(), user.getRoles());
            model.addAttribute("userDto", userDto);
        }
        setMainUserAttributes(model);
        return "users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Short id){
        userService.delete(id);
        return "redirect:/users";
    }

    @PostMapping("/users")
    public String editUser(@ModelAttribute(name = "user") UserDto userdto, Model model) {
        if(userdto.getRoles().isEmpty()){
            model.addAttribute("error", "должна быть выбрана хотя бы одна роль");
            setMainUserAttributes(model);
            return "users";
        }
        User user = userService.findByLogin(userdto.getLogin());
        user.setRoles(userdto.getRoles());
        userService.save(user);
        setMainUserAttributes(model);
        return "users";
    }

    private void setMainUserAttributes(Model model){
        List<User> users = userService.findAll();
        List<Role> roles = roleService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
    }
}
