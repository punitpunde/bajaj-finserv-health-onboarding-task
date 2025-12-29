package com.bajaj.event.controller;

import com.bajaj.event.entity.Show;
import com.bajaj.event.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowRepository repository;

    @PostMapping
    public Show createShow(@RequestBody Show show) {
        return repository.save(show);
    }

    @GetMapping
    public List<Show> getAllShows() {
        return repository.findAll();
    }
}
