package com.example.demo2.services;

import com.example.demo2.Util.InvalidRequestException;
import com.example.demo2.repository.InternRepository;
import com.example.demo2.resources.entity.Interns;
import com.example.demo2.resources.request.InternRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InternService {

    @Autowired
    private InternRepository repository;

    public Interns create(InternRequest internRequest) {
    Interns interns = new Interns(
            internRequest.getFirstName(),
            internRequest.getLastName(),
            internRequest.getGender(),
            LocalDateTime.now()
            );
    return repository.save(interns);

    }

    public Interns get(Long id) {

        Optional<Interns> optionalInterns = repository.findById(id);
        if (!optionalInterns.isPresent())
        {
            throw new InvalidRequestException(String.format("the id : %s is not present",id));
        }
        return optionalInterns.get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Interns update(Long id,InternRequest request) {

        Optional<Interns> optionalInterns = repository.findById(id);
        Interns interns1 = null;
        if (optionalInterns.isPresent())
        {
            interns1 = optionalInterns.get();
            interns1.setFirstName(request.getFirstName());
            interns1.setLastName(request.getLastName());
            interns1.setGender(request.getGender());
        }

        return repository.save(interns1);
    }

    public List<Interns> getAll() {
        return repository.findAll();
    }
}
