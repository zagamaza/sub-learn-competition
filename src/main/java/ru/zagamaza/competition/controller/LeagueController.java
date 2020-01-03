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
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.infra.service.LeagueInfraService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/competition/leagues")
@RequiredArgsConstructor
public class LeagueController {

    private final LeagueInfraService leagueInfraService;

    @GetMapping("/{id}")
    public LeagueModel get(@PathVariable Long id) {
        return leagueInfraService.get(id);
    }

    @GetMapping
    public Page<LeagueModel> getByLeagueLevelCode(@RequestParam Level level, Pageable pageable) {
        return leagueInfraService.getByLeagueLevelCode(level, pageable);
    }

    @GetMapping("/users/{userId}/my")
    public Page<LeagueModel> getPageWithUserByUserId(@PathVariable Long userId) {
        return leagueInfraService.getPageWithUserByUserId(userId);
    }

    @PostMapping
    public LeagueModel create(@Valid @RequestBody LeagueModel leagueModel) {
        return leagueInfraService.create(leagueModel);
    }

    @PutMapping
    public LeagueModel update(@Valid @RequestBody LeagueModel leagueModel) {
        return leagueInfraService.update(leagueModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        leagueInfraService.delete(id);
    }

}
