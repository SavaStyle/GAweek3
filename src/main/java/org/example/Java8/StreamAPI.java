package org.example.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
    Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
    Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));


    public void init() {
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);

        List<String> unique = developerStream
                .flatMap(developer -> developer.getLanguages().stream())
                .collect(Collectors.groupingBy(l -> l, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Set<Developer> dev = Stream.of(dev1, dev2, dev3).
                filter(developer -> developer.getLanguages().stream().anyMatch(unique::contains)).collect(Collectors.toSet());

        for (Developer developer : dev)
            System.out.println(developer.getName());
    }
}
