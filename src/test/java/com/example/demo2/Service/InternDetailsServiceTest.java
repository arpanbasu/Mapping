package com.example.demo2.Service;

import com.example.demo2.Util.InvalidRequestException;
import com.example.demo2.repository.InternDetailsRepository;
import com.example.demo2.repository.InternRepository;
import com.example.demo2.resources.request.InternDetailsRequest;
import com.example.demo2.services.InternDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InternDetailsServiceTest {

    @Test
    void create() {

        // Mockito Library

        //Mock Objects
        InternRepository internRepository = Mockito.mock(InternRepository.class);
        //Mock Objects
        InternDetailsRepository internDetailsRepository = Mockito.mock(InternDetailsRepository.class);

        //Intializing InternDetailsService with mock objects
        InternDetailsService internDetailsService = new InternDetailsService(
                internRepository, internDetailsRepository
        );

        // Creating payload to pass in create method
        InternDetailsRequest request = new InternDetailsRequest(1L, "", 42432L);

        Mockito.when(internRepository.findById(request.getId()))
                .thenReturn(Optional.empty());

        InvalidRequestException exception = assertThrows(
                InvalidRequestException.class,
                () -> internDetailsService.create(request)
        );

        assertEquals("No intern found with id: 1", exception.getMessage());
    }

    @Test
    void get() {

    }
}
