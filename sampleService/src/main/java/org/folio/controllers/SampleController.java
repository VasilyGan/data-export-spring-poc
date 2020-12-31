package org.folio.controllers;

import org.folio.dto.GreetingDto;
import org.folio.model.entities.Greeting;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class SampleController {

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/greeting/search")
    public List<GreetingDto> getGreeting(@RequestParam(value = "offset") int offset, @RequestParam(value = "limit") int limit) {

        List<Greeting> greetingList = new ArrayList<>();
        greetingList.add(new Greeting("Hello", "English"));
        greetingList.add(new Greeting("Hi", "English"));
        greetingList.add(new Greeting("Bonjour", "French"));
        greetingList.add(new Greeting("Guten Tag", "German"));
        greetingList.add(new Greeting("Ciao", "Italian"));
        greetingList.add(new Greeting("Hola", "Spanish"));

        List<GreetingDto> exportedData = new ArrayList<>();
        Random random = new Random();

        int maxGreetingListIndex = greetingList.size() - 1;
        int currentOffset = offset;
        for (int i = 0; i < limit; i++) {
            int greetingIndex = random.nextInt(maxGreetingListIndex);
            Greeting currentGreeting = greetingList.get(greetingIndex);
            GreetingDto currentGreetingDto = this.modelMapper.map(currentGreeting, GreetingDto.class);
            currentGreetingDto.setId(currentOffset);
            currentOffset++;

            exportedData.add(currentGreetingDto);
        }

        return exportedData;
    }
}
