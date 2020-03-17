package com.example.demo2.api;

import com.example.demo2.resources.entity.Interns;
import com.example.demo2.resources.request.InternRequest;
import com.example.demo2.services.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/interns/")
public class controller {
    @Autowired
    private InternService service;

    @PostMapping
    public Interns create(@RequestBody InternRequest internRequest)
    {
        return service.create(internRequest);
    }

    @GetMapping("/{id}")
    public Interns get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }
    @GetMapping
    public List<Interns> getAll()
    {
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id)
    {
        service.delete(id);
    }
    @PutMapping("/{id}")
    public Interns update(@PathVariable("id") Long id,@RequestBody InternRequest request)
    {
        return service.update(id,request);
    }
}
