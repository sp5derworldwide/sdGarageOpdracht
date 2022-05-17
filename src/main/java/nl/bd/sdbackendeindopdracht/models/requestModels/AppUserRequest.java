package nl.bd.sdbackendeindopdracht.models.requestModels;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class AppUserRequest {

    private final String name;
    private final String username;
    private final String email;
    private final String password;
    private final Roles userRole;
    private final String function;

}
