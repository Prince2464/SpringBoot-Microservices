package com.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.OfficialDetails;

public interface OfficialRepositoy extends JpaRepository<OfficialDetails, Long> {
}
