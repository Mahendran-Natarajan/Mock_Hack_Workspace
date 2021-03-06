package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.ReligionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Religion repository.
 */
@Repository
public interface ReligionRepository extends JpaRepository<ReligionDetail, Long> {

	ReligionDetail findByReligionId(Long religionId);
	

}
