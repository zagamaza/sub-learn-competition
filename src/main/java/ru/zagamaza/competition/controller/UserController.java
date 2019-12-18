package ru.zagamaza.competition.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.infra.service.UserInfraService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/competition/users")
@RequiredArgsConstructor
public class UserController {

    private final UserInfraService userInfraService;

    @GetMapping("/{id}")
    public UserModel get(@PathVariable Long id) {
        return userInfraService.get(id);
    }

    @GetMapping("/user_friends/{userId}")
    public Page<UserModel> getByUserFriendUserId(@PathVariable Long userId, Pageable pageable) {
        return userInfraService.getByUserFriendUserId(userId, pageable);
    }

    @GetMapping("/telegram/{telegramId}")
    public UserModel getByTelegramId(@PathVariable Long telegramId) {
        return userInfraService.getByTelegramId(telegramId);
    }

    @PostMapping
    public UserModel create(@Valid @RequestBody UserModel userModel) {
        return userInfraService.create(userModel);
    }

    @PutMapping
    public UserModel update(@Valid @RequestBody UserModel userModel) {
        return userInfraService.update(userModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userInfraService.delete(id);
    }

}
