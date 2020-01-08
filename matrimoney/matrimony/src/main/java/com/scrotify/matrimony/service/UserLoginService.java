package com.scrotify.matrimony.service;

import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.exception.UserNotFoundException;

import java.util.List;


/**
 * The interface User login service.
 */
public interface UserLoginService {

    /**
     * Login user user login response dto.
     *
     * @param userLoginRequestDto the user login request dto
     * @return the user login response dto
     * @throws UserNotFoundException the user not found exception
     */
    public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) throws UserNotFoundException;

    /**
     * Gets by user id.
     *
     * @param userId the user id
     * @return the by user id
     * @throws UserNotFoundException the user not found exception
     */
    public List<UserViewProfileResponseDto> getByUserId(Long userId) throws UserNotFoundException;

}
