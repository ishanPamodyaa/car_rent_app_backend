package edu.icet.service.auth;

import edu.icet.dto.SignUpRequestDto;
import edu.icet.entity.UserEntity;

public interface AuthService {

    UserEntity createCustomer(SignUpRequestDto signupRequest);
    boolean hasCustomerEmails(String email);
}