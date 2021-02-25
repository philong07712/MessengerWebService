package com.example.MessengerProject.service;

import com.example.MessengerProject.DatabaseClass;
import com.example.MessengerProject.models.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
    public static ProfileService instance;
    Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("Hung", new Profile(1L, "Hung", "Hung", "Doan"));
        profiles.put("Dung", new Profile(2L, "kide", "Dung", "Doan"));
    }

    public static ProfileService getInstance() {
        if (instance == null) {
            instance = new ProfileService();
        }
        return instance;
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String name) {
        if (profiles.containsKey(name)) {
            return profiles.get(name);
        }
        return null;
    }

    public Profile addProfile(Profile profile) {
        int index = profiles.size();
        index++;
        profile.setId(index);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(String name, Profile profile) {
        profile.setProfileName(name);
        profiles.replace(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String name) {
        if (profiles.containsKey(name)) {
            return profiles.remove(name);
        }
        return null;
    }
}
