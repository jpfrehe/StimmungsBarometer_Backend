package de.fiduciagad.backend.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }
    public void addGroup(Team group){
        teamRepository.save(group);
    }
    public List<Team> getTeams(){
        return teamRepository.findAll();
    }

    public Team getTeam(String teamName) {
        List<Team> allteams = getTeams();
        //System.out.println("TeamNane:"+ teamName);
        //allteams.stream().forEach(s-> System.out.println(s));
        List<Team> selectedTEams = allteams.stream().filter(t -> t.getName().equals(teamName)).collect(Collectors.toList());
        //TODO andere Lösung Team name nur einmal vergeben
        Team team = selectedTEams.get(0);
        return  team;
    }
}
