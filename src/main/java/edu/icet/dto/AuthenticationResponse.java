package edu.icet.dto;

import edu.icet.enums.UserRoles;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String jwt;
    private UserRoles userRoles;
    private String userid;
}
