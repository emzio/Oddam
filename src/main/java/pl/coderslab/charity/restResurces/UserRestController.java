package pl.coderslab.charity.restResurces;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.service.UserService;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;


    @ResponseBody
    @GetMapping("/rest/users")
    public String findAll(){
        return userService.findAllEnabledUsers()
                .stream().map(user -> user.toString())
                .collect(Collectors.joining("<br>"));
    }


    @ResponseBody
    @GetMapping("/rest/user/{id}")
    public  String findById(@PathVariable Long id){
        return userService.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rest entity not found")).toString();
    }
//    return EntityModel.of(employee, //
//    linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
//    linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
}
