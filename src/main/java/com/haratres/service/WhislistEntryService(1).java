package com.haratres.service;

import com.haratres.entity.WhislistEntry;

import java.util.List;

public interface WhislistEntryService {
    List<WhislistEntry> getAllWhislistEntry(String name);

    WhislistEntry getWhislistEntryById(Long id);

    WhislistEntry findByWhislistId(Long id);

    void saveWhislistEntry(WhislistEntry whislistEntry);


    void deleteWhislistEntry(Long id);
}
