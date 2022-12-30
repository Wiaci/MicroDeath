package wiaci.proj.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import wiaci.proj.userservice.entity.User;
import wiaci.proj.userservice.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Mono<User> getUser(@RequestParam String username) {
        return Mono.just(userService.findByUsername(username));
    }

    @GetMapping("/all")
    public Flux<User> getAll() {
        return Flux.fromIterable(userService.getAll());
    }

    @PostMapping("/new")
    public Mono<User> addUser(@RequestParam User user) {
        return Mono.just(userService.register(user));
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteById(id);
    }
}
