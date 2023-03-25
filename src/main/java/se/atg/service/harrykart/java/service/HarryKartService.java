package se.atg.service.harrykart.java.service;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.java.model.HarryKart;
import se.atg.service.harrykart.java.model.Rank;

import java.util.List;

@Service
public interface HarryKartService {
    List<Rank> play(HarryKart harryKart);
}
