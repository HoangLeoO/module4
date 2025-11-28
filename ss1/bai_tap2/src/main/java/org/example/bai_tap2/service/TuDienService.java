package org.example.bai_tap2.service;


import org.example.bai_tap2.repository.ITuDienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuDienService implements ITuDienService {

    @Autowired
    private  ITuDienRepository tuDienRepository;


    @Override
    public String search(String str) {
        return tuDienRepository.search(str);
    }
}
