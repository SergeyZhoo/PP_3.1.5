package springboot.pp_3_1_31.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.pp_3_1_31.entity.User;
import springboot.pp_3_1_31.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping()
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user";
	}

	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "add";
	}

	@PostMapping()
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/user";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("user", userService.getUser(id));
		return "edit";
	}


	@PatchMapping("/{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
		userService.updateUser(id, user);
		return "redirect:/user";
	}

//	@DeleteMapping("/{id}/delete")
//	public String deletePerson(@PathVariable("id") Long id){
//		userService.deleteUser(id);
//		return "redirect:/user";
//	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/user";
	}

}
