package com.springboot.practice.data.repository;

import com.springboot.practice.data.entity.Usage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageRepository extends JpaRepository<Usage, Long> {
}
