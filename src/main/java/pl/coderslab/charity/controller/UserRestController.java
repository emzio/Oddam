package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @GetMapping("/check/email/{userName}")
    Boolean emailCheck(@PathVariable String userName , @RequestParam(required = false) Long id){
        return Optional.ofNullable(userService.findByUserName(userName))
                .map(user -> Optional.ofNullable(id).map(l -> l.equals(user.getId()))
                        .orElse(false)
                )
                .orElse(true);
    }
}
