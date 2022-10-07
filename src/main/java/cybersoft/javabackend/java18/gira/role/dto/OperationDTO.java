package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.model.Operation;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationDTO {
    private UUID id;
    @Length(min = 5, max = 50, message = "name must be between {min} and {max} characters")
    private String name;

    @Length(min = 5, max = 50, message = "code must be between {min} and {max} characters")
    private String code;

    @NotBlank(message = "must not be blank")
    private String description;

    private Operation.Type type;


}
