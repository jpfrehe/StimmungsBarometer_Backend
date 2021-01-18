package de.fiduciagad.backend.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }
    public void addTeam(Team group){
        Optional<Team> teamByName = teamRepository.findTeamByName(group.getName());
        if(teamByName.isPresent()){
            throw new IllegalStateException("Team Name bereits vergeben");
        }
        teamRepository.save(group);
    }
    public List<Team> getTeams(){
        return teamRepository.findAll();
    }

    public Team getTeam(String teamName) {
        List<Team> allteams = getTeams();
        Team team = allteams.stream().filter(t -> t.getName().equals(teamName)).collect(Collectors.toList()).get(0);
        return  team;
    }
}
