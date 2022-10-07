package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleCode;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleName;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
    private UUID id;

    @Length(min = 5, max = 50, message = "{role.name.length}")
    @UniqueRoleName
    private String name;

    @UniqueRoleCode
    @Length(min = 5, max = 50, message = "{role.code.length}")
    private String code;

    @NotBlank(message = "{role.description.blank}")
    private String description;
}
