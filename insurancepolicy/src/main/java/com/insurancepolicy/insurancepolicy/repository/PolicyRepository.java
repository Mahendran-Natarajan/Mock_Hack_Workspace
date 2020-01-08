package com.insurancepolicy.insurancepolicy.repository;

import com.insurancepolicy.insurancepolicy.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {


}
