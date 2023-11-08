package com.haratres.service.impl;

import com.haratres.entity.Whislist;
import com.haratres.repository.WhislistRepository;
import com.haratres.service.WhislistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhislistServiceImpl implements WhislistService {

    private final WhislistRepository whislistRepository;


    @Override
    public List<Whislist> getAllWhislist(String name) {
        return whislistRepository.findAll();
    }

    @Override
    public Whislist getWhislistById(Long id) {
        return whislistRepository.findById(id).orElseThrow();
    }


    @Override
    public void saveWhislist(Whislist whislist) {
        whislistRepository.save(whislist);
    }

    @Override
    public void delete(Whislist whislist) {
        whislistRepository.delete(whislist);
    }


}
