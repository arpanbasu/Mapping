package com.example.demo2.services;

import com.example.demo2.Util.InvalidRequestException;
import com.example.demo2.repository.InternDetailsRepository;
import com.example.demo2.repository.InternRepository;
import com.example.demo2.resources.entity.Embeddble.Address;
import com.example.demo2.resources.entity.Interns;
import com.example.demo2.resources.entity.InternsDetails;
import com.example.demo2.resources.request.InternDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InternDetailsService {

    private InternRepository repository;
    private InternDetailsRepository internRepository;

    @Autowired
    public InternDetailsService(InternRepository repository, InternDetailsRepository internRepository) {
        this.repository = repository;
        this.internRepository = internRepository;
    }

    public Interns create(InternDetailsRequest request)
    {
        Address address = new Address(
                request.getAddress(),
                request.getZipCode()
        );

        InternsDetails details = new InternsDetails(address);
        Optional<Interns> optionalInterns = repository.findById(request.getId());

        if (!optionalInterns.isPresent())
            throw new InvalidRequestException(String.format("No intern found with id: %s", request.getId()));
        Interns interns = optionalInterns.get();

        interns.setInternsDetails(details);
        return repository.save(interns);
    }

    public InternsDetails get(Long id) {
        return internRepository.findById(id).get();
    }
}
