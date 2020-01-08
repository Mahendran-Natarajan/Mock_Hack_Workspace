package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.CityDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface City repository.
 */
@Repository
public interface CityRepository extends JpaRepository<CityDetail, Long> {

	CityDetail findByCityId(Long cityId);

}
