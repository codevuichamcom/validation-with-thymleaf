package com.example.demoerrorthymleaf;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> personList = new ArrayList<>();

    public List<Person> getAll() {
        return personList;
    }

    public void save(Person person) {
        int id = 1;
        if (!personList.isEmpty()) {
            id = personList.get(personList.size() - 1).getId() + 1;
        }
        person.setId(id);
        personList.add(person);
    }
}
