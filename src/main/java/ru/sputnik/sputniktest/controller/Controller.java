package ru.sputnik.sputniktest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.sputnik.sputniktest.Service.StatusRandomService;

@RestController("/")
@RequiredArgsConstructor
public class Controller {


    private final RestTemplate restTemplate;
    private final StatusRandomService statusRandomService;

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getRandomHttpStatusFunnyCatPicture() {
        return restTemplate.getForObject(String.format("https://http.cat/%s", statusRandomService.getRandomStatus()), byte[].class);
    }
}
