package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface User detail repository.
 */
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    /**
     * Find by email id optional.
     *
     * @param emailId the email id
     * @return the optional
     */
    Optional<UserDetail> findByEmailId(String emailId);

    /**
     * Find by user id optional.
     *
     * @param userId the user id
     * @return the optional
     */
    Optional<UserDetail> findByUserId(Long userId);


}
