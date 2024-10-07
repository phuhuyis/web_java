package com.example.websiteqa.service;

import com.example.websiteqa.model.Lienhe;

import java.util.List;

public interface LienHeService {
    List<Lienhe> list();
    void add(Lienhe lienhe);
    void update(Lienhe lienhe);
    void delete(int id);
    Lienhe get(int id);
}
