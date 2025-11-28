package org.example.bai_tap2.repository;

import org.example.bai_tap2.entity.TuDien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TuDienRepository implements ITuDienRepository{


    private static final Map<String, String> TU_DIENS = new HashMap<>();


    static {
        TU_DIENS.put( "hello", "xin chào");
        TU_DIENS.put( "goodbye", "tạm biệt");
    }

    @Override
    public String search(String str) {
        return TU_DIENS.get(str);
    }
}
