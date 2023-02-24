package com.food.dumplingdelights.controller;
import com.food.dumplingdelights.Entity.User;
import com.food.dumplingdelights.pojo.UserPojo;
import com.food.dumplingdelights.repo.UserRepo;
import com.food.dumplingdelights.services.user_management.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepo userRepo;

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "dashboard";
    }

    @GetMapping("/dispatching")
    public String getShippingPage() {
        return "dispatching";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("user", new UserPojo());
        return "create";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        UserPojo user = new UserPojo();
        model.addAttribute("user", new UserPojo());//pass user object of user pojo to regester template
        return "register";
    }

    @PostMapping("/register/save")
    public String createUser(@Valid UserPojo userPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/register";
        }
        userService.save(userPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");
        return "redirect:/user/login";
    }

    @GetMapping("/userList")
    public String getUser(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users.stream().map(user ->
                User.builder()
                        .id(user.getId())
                        .fullName(user.getFullName())
                        .email(user.getEmail())
                        .build()
        ));
        return null;
    }



    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }
}