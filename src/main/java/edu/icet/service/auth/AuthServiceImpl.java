package edu.icet.service.auth;


import edu.icet.dto.SignUpRequestDto;
import edu.icet.entity.UserEntity;
import edu.icet.enums.UserRoles;
import edu.icet.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService  {

    final UserRepository userRepository;
    final ModelMapper modelMapper;
    final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdminAccount() {
        Optional<UserEntity> adminAccount = userRepository.findByRole(UserRoles.ADMIN);
        if (adminAccount.isEmpty()) {
            UserEntity newAdminAccount = new UserEntity();
            newAdminAccount.setName("ADMIN");
            newAdminAccount.setRole(UserRoles.ADMIN);
            newAdminAccount.setEmail("ruvindusharadaha22@gmail.com");
            newAdminAccount.setPassword(passwordEncoder.encode("12345678")); // Encode the password
            userRepository.save(newAdminAccount);
            System.out.println("Admin account created successfully.");
        } else {
            System.out.println("Admin account already exists.");
        }
    }

    @Override
    public UserEntity createCustomer(SignUpRequestDto signupRequest) {
        System.out.println("Creating user: " + signupRequest);
        UserEntity user = modelMapper.map(signupRequest, UserEntity.class);
        user.setRole(UserRoles.CUSTOMER);
        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(encodedPassword);

        try {
            UserEntity savedUser = userRepository.save(user);
            System.out.println("User saved: " + savedUser);
            return savedUser;
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage());
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    @Override
    public boolean hasCustomerEmails(String email) {
        UserEntity user = userRepository.findByEmail(email);
        return user != null && user.getName() != null && !user.getName().isEmpty();
    }
}
