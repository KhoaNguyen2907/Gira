package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_operation")
public class Operation extends BaseEntity {
    @Column(name = "name", unique = true, length = 100)
    @Length(min = 3, max = 50, message = "name must be between {min} and {max} characters")
    private String name;

    @Column(name = "code" , unique = true)
    @Length(min = 3, max = 15, message = "code must be between {min} and {max} characters")
    private String code;

    @Column(name = "description")
    @NotBlank(message = "must not be blank")
    private String description;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    public enum Type{
        SAVE_OR_UPDATE,
        FETCH,
        REMOVE
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "operations")
    private Set<Role> roles = new LinkedHashSet<>();;


}
