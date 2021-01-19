package de.fiduciagad.backend.group;

import de.fiduciagad.backend.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void addTeam(Team group) {
        Optional<Team> teamByName = teamRepository.findTeamByName(group.getName());
        if (teamByName.isPresent()) {
            throw new IllegalStateException("Team Name bereits vergeben");
        }
        teamRepository.save(group);
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam(String teamName) {
        List<Team> allteams = getTeams();

        List<Team> team = allteams.stream().filter(t -> t.getName().equals(teamName)).collect(Collectors.toList());
        if (team.size() == 0) {
            teamRepository.save(new Team(teamName));
            Optional<Team> optTeam = teamRepository.findTeamByName(teamName);
            if (optTeam.isPresent()) {
                return optTeam.get();
            }
        }
        return team.get(0);
    }

    public Map<String, Integer> getEvaluation(String teamName) {
        Map<String, Integer> eval = new HashMap<>();
        Team team = getTeam(teamName);
        List<Rating> ratingTeam = team.getRatings();
        if (ratingTeam.isEmpty()) {
            eval.put("maximum", 0);
            eval.put("minimum", 0);
            eval.put("average", 0);
            eval.put("coffeeCount", 0);
        } else {
            IntSummaryStatistics stats = ratingTeam.stream().mapToInt((x) -> x.getStimmung()).summaryStatistics();
            int coffeeCount = ratingTeam.stream().mapToInt(i -> i.getCoffeeCount()).sum();
            eval.put("maximum", stats.getMax());
            eval.put("minimum", stats.getMin());
            eval.put("average", (int) stats.getAverage());
            eval.put("coffeeCount", coffeeCount);
        }
        return eval;
    }

    public Map<String, Integer> getEvaluation(String teamName, LocalDate date) {
        Map<String, Integer> eval = new HashMap<>();
        Team team = getTeam(teamName);
        List<Rating> ratingTeam = team.getRatings();
        List<Rating> ratingByDate = new ArrayList<>();
        for (Rating rating : ratingTeam) {
            if (rating.getDateOfRating().equals(date)) {
                ratingByDate.add(rating);
            }
        }
        if (ratingByDate.isEmpty()) {
            eval.put("maximum", 0);
            eval.put("minimum", 0);
            eval.put("average", 0);
            eval.put("coffeeCount", 0);
        } else {
            IntSummaryStatistics stats = ratingByDate.stream().mapToInt((x) -> x.getStimmung()).summaryStatistics();
            int coffeeCount = ratingByDate.stream().mapToInt(i -> i.getCoffeeCount()).sum();
            eval.put("maximum", stats.getMax());
            eval.put("minimum",stats.getMin());
            eval.put("average", (int) stats.getAverage());
            eval.put("coffeeCount", coffeeCount);
        }
        return eval;
    }
}
