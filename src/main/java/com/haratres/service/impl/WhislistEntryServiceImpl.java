package com.haratres.service.impl;

import com.haratres.entity.WhislistEntry;
import com.haratres.repository.WhislistEntryRepository;
import com.haratres.service.WhislistEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhislistEntryServiceImpl implements WhislistEntryService {

    private final WhislistEntryRepository whislistEntryRepository;
    @Override
    public List<WhislistEntry> getAllWhislistEntry(String name) {
        return whislistEntryRepository.findAll();
    }

    @Override
    public WhislistEntry getWhislistEntryById(Long id) {
        return whislistEntryRepository.findById(id).get();
    }

    @Override
    public WhislistEntry findByWhislistId(Long id){
        return  whislistEntryRepository.findById(id).get();
    }

    @Override
    public void saveWhislistEntry(WhislistEntry whislistEntry) {
        whislistEntryRepository.save(whislistEntry);
    }

    @Override
    public void deleteWhislistEntry(Long id) {
        whislistEntryRepository.deleteById(id);
    }
}
