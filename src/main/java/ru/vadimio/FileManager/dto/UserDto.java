package ru.vadimio.FileManager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vadimio.FileManager.entities.Role;

import java.util.Collection;

@Data
@NoArgsConstructor
public class UserDto {
    private String login;
    private Collection<Role> roles;

    public UserDto(String login, Collection<Role> roles) {
        this.login = login;
        this.roles = roles;
    }
}
