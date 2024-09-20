package com.sachith.server.repository;

import com.sachith.server.model.Company;
import com.sachith.server.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
