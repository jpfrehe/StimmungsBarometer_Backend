package de.fiduciagad.backend.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/team")
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
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);

    }
    @GetMapping("/rating/{teamName}")
    public Map<String,Double> getEvalution(@PathVariable(required = true) String teamName){
        return teamService.getEvaluation(teamName);


    }
    @GetMapping("/rating/{teamName}/{date}")
    public Map<String,Double> getEvalutionByDate(@PathVariable(required = true) String teamName,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){

        return teamService.getEvaluation(teamName, date);


    }



}
