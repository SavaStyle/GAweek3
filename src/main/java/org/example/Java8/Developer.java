package org.example.Java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Developer {
    private String name;
    private List<String> languages;

}
