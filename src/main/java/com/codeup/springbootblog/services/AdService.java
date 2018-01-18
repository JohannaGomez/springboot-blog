package com.codeup.springbootblog.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    private List<Ad> ads;

    public AdService() {
        createAds();
    }

    public List<Ad> findAll() {
        return ads;
    }

    public Ad save(Ad ad) {
        // Generates a consecutive number
        ad.setId(ads.size() + 1);
        ads.add(ad);
        return ad;
    }

    public Ad findOne(long id) {
        return ads.get((int)(id - 1));
    }

    private void createAds() {
        // create some ad objects and add them to the ads list
        // with the save method
        save(new Ad("ad a", "description a"));
        save(new Ad("ad B", "description b"));
        save(new Ad("ad C", "description c"));
    }
}
