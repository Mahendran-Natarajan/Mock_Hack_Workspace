package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.CasteDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Caste repository.
 */
@Repository
public interface CasteRepository extends JpaRepository<CasteDetail, Long> {

}
