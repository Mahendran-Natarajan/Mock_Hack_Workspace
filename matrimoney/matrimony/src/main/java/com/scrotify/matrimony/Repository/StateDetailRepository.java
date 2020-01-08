package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.StateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface State detail repository.
 */
@Repository
public interface StateDetailRepository extends JpaRepository<StateDetail, Long> {

}
