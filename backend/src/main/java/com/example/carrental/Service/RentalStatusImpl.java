package com.example.carrental.Service;
import com.example.carrental.Model.RentalStatus;
import com.example.carrental.Repository.RentalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RentalStatusImpl implements RentalStatusService {
    @Autowired
    private RentalStatusRepository statusRepository;


    @Override
    public List<RentalStatus> getAllStatus() {
        return statusRepository.findAll();
    }
}
