package de.fiduciagad.backend.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/group")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(value = {"", "{teamName}"})
    public List<Team> getGroups(@PathVariable(required = false) String teamName) {
        System.out.print(teamName);
        if (teamName != null) {
            return List.of(teamService.getTeam(teamName));
        } else {
            return teamService.getTeams();
        }
    }

    @PostMapping
    public void addUser(@RequestBody Team team) {
        teamService.addGroup(team);

    }



}
