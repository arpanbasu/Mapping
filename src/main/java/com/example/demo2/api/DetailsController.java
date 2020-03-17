package com.example.demo2.api;

import com.example.demo2.resources.entity.Interns;
import com.example.demo2.resources.entity.InternsDetails;
import com.example.demo2.resources.request.InternDetailsRequest;
import com.example.demo2.services.InternDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/interns/details/")
public class DetailsController {

    @Autowired
    private InternDetailsService service;

    @PostMapping
    public Interns create(@RequestBody InternDetailsRequest request)
    {
        return service.create(request);
    }
    @GetMapping("/{id}")
    public InternsDetails get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }
}
