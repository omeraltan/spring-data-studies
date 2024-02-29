package com.spring.data.repository;

import com.spring.data.entity.Pet_Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pet_OwnerRepository extends JpaRepository<Pet_Owner, Long> {
}
