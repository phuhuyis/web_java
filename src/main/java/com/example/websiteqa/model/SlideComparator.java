package com.example.websiteqa.model;

import java.util.Comparator;

public class SlideComparator implements Comparator<Slide> {
    @Override
    public int compare(Slide o1, Slide o2) {
        if(o1.getVitri() > o2.getVitri())
            return 1;
        if(o1.getVitri() == o2.getVitri())
            return 0;
        return -1;
    }
}
