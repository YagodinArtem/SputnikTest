package ru.sputnik.sputniktest.Service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StatusRandomService {

    List<Integer> statusRepo;

    public StatusRandomService() {
        statusRepo = new ArrayList<>(Arrays.asList(100, 101, 102, 200, 201, 202, 300, 301, 302, 308, 400, 500));
    }

    public Integer getRandomStatus() {
        Collections.shuffle(statusRepo);
        return statusRepo.stream().findAny().orElse(500);
    }
}
