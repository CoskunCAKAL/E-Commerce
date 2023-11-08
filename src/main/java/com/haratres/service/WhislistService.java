package com.haratres.service;

import com.haratres.entity.Whislist;

import java.util.List;

public interface WhislistService {

    List<Whislist> getAllWhislist(String name);

    Whislist getWhislistById(Long id);


    void saveWhislist(Whislist whislist);

    void delete(Whislist id);
}
