package com.inyange.inyange.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inyange.inyange.model.School;
import com.inyange.inyange.repository.schoolRepository;

@Service
public class SchoolService {
    @Autowired
    private schoolRepository schoolRepositories;

    public List<School> findAllSchool() {
        return schoolRepositories.findAll();
    }
    public School findSchoolById(Long id) {
       Optional<School> schools = schoolRepositories.findById(id);
       School school2 = null;
         if(schools.isPresent()) {
              school2 = schools.get();
         }
            return school2;
    }
    public School saveSchool(School school) {
        return schoolRepositories.save(school);
    }
    public void deleteSchool(Long id) {
        boolean exists = schoolRepositories.existsById(id);
        if(exists) {
            schoolRepositories.deleteById(id);
        }else{
            System.out.println("School with id "+id+" does not exist");
        }
    }
    
}
