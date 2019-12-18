package ru.zagamaza.competition.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zagamaza.competition.domain.model.UserFriendModel;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.infra.service.UserFriendInfraService;
import ru.zagamaza.competition.infra.service.UserInfraService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/competition/user_friends")
@RequiredArgsConstructor
public class UserFriendController {

    private final UserFriendInfraService userFriendInfraService;

    @GetMapping("/{id}")
    public UserFriendModel get(@PathVariable Long id) {
        return userFriendInfraService.get(id);
    }

    @PostMapping
    public UserFriendModel create(@Valid @RequestBody UserFriendModel userFriendModel) {
        return userFriendInfraService.create(userFriendModel);
    }

    @PutMapping
    public UserFriendModel update(@Valid @RequestBody UserFriendModel userFriendModel) {
        return userFriendInfraService.update(userFriendModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userFriendInfraService.delete(id);
    }

    @DeleteMapping("/users/{userId}/userFriend/{userFriendId}")
    public void delete(@PathVariable Long userId, @PathVariable Long userFriendId) {
        userFriendInfraService.deleteByUserIdAndUserFriendId(userId, userFriendId);
    }
}
