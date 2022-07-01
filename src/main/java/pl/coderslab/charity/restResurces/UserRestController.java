package pl.coderslab.charity.restResurces;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;


//    @ResponseBody
//    @GetMapping("/rest")
//    public String findAll(){
//        return userService.findAllEnabledUsers()
//                .stream().map(user -> user.toString())
//                .collect(Collectors.joining("<br>"));
//    }

    @GetMapping("/rest")
    List<User> findAll(){
        return userService.findAllEnabledUsers();
    }


//    @ResponseBody
    @GetMapping("/rest/{id}")
//    public  String findById(@PathVariable Long id){
//        return userService.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rest entity not found")).toString();


    EntityModel<User> findById(@PathVariable Long id){
        User user = userService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rest entity not found"));
        return EntityModel.of(user,
    linkTo(methodOn(UserRestController.class).findById(id)).withSelfRel(),
    linkTo(methodOn(UserRestController.class).findAll()).withRel("rest"));
    }
}
