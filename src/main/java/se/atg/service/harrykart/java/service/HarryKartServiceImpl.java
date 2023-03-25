package se.atg.service.harrykart.java.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import se.atg.service.harrykart.java.model.HarryKart;
import se.atg.service.harrykart.java.model.Participant;
import se.atg.service.harrykart.java.model.Rank;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarryKartServiceImpl implements HarryKartService {
    private static final double TRACK_LENGTH = 1000.0;

    @Override
    public List<Rank> play(HarryKart race) {
        List<Rank> leaderboard = getRanks(race);

        int placement = 1;
        leaderboard.get(0).setPosition(placement);
        for (int positionIndex = 1; positionIndex < leaderboard.size(); positionIndex++) {
            if (leaderboard.get(positionIndex).getTime() != leaderboard.get(positionIndex - 1).getTime()) {
                leaderboard.get(positionIndex).setPosition(++placement);
            } else {
                leaderboard.get(positionIndex).setPosition(placement);
            }
        }

        return leaderboard.stream().filter(rank -> rank.getPosition() <= 3).collect(Collectors.toList());
    }

    @NotNull
    private List<Rank> getRanks(HarryKart race) {
        return race
                .getStartList()
                .stream()
                .map(participant -> getRankForParticipant(race, participant))
                .sorted()
                .collect(Collectors.toList());
    }

    @NotNull
    private Rank getRankForParticipant(HarryKart race, Participant participant) {
        Rank rank = new Rank(0, participant.getName(), TRACK_LENGTH / participant.getBaseSpeed());
        race.getPowerUps()
                .forEach(loop -> loop
                        .getLanes()
                        .stream()
                        .filter(lane -> lane.getNumber() == participant.getLane())
                        .forEach(lane -> {
                            participant.setBaseSpeed(participant.getBaseSpeed() + lane.getPowerValue());
                            rank.setTime(rank.getTime() + (TRACK_LENGTH / participant.getBaseSpeed()));
                        }));
        return rank;
    }
}
