package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.model.Operation;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleWithOperationsDTO {
    private UUID id;
    private String name;

    private String code;

    private String description;

    private Set<OperationDTO> operations;
}
