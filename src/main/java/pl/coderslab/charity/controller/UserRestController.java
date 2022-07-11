package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.charity.service.UserService;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("/check/email/{userName}")
    Boolean emailCheck(@PathVariable String userName , @RequestParam(required = false) Long id){
        return Optional.ofNullable(userService.findByUserName(userName))
                .map(user -> Optional.ofNullable(id).map(l -> l.equals(user.getId()))
                        .orElse(false)
                )
                .orElse(true);
    }
}
