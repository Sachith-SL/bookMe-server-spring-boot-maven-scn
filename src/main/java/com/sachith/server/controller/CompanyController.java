package com.sachith.server.controller;

import com.sachith.server.model.Company;
import com.sachith.server.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/company")
@CrossOrigin()
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/{id}")
    public Optional<Company> read(@PathVariable Integer id){
        return companyRepository.findById(id);
    }

    @PostMapping()
    public Company create(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable Integer id,@RequestBody Company newCompany){
        Optional<Company> oldOptionalCompany = companyRepository.findById(id);

        if(oldOptionalCompany.isPresent()){
            Company oldCompany = oldOptionalCompany.get();
            oldCompany.setName(newCompany.getName());
            oldCompany.setRegistrationNumber(newCompany.getRegistrationNumber());
            oldCompany.setAddress(newCompany.getAddress());
            oldCompany.setCity(newCompany.getCity());
            oldCompany.setCountry(newCompany.getCountry());
            oldCompany.setFoundedDate(newCompany.getFoundedDate());
            oldCompany.setWebsite(newCompany.getWebsite());
            oldCompany.setEmail(newCompany.getEmail());
            oldCompany.setPhone(newCompany.getPhone());
            oldCompany.setActive(newCompany.getActive());
            return companyRepository.save(oldCompany);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        companyRepository.deleteById(id);
    }
}
