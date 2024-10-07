package com.example.websiteqa.entity;

import java.util.Comparator;

public class SlideEntityComparator implements Comparator<SlideEntity> {
    @Override
    public int compare(SlideEntity o1, SlideEntity o2) {
        if(o1.getVitri() > o2.getVitri())
            return 1;
        if(o1.getVitri() == o2.getVitri())
            return 0;
        return -1;
    }
}
