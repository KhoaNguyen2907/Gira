package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleCode;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_role")
public class Role extends BaseEntity implements Serializable {

    @Column(name = "name", unique = true, length = 100)
    @Length (min = 5, max = 50, message = "{role.name.length}")
    private String name;

    @Column(name = "code" , unique = true)
    @Length(min = 5, max = 50, message = "{role.code.length}")
    private String code;

    @Column(name = "description")
    @NotBlank (message = "{role.description.blank}")
    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "gira_role_operation",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "operation_id"))
    private Set<Operation> operations = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "gira_role_group",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<UserGroup> userGroups = new LinkedHashSet<>();

    public void addOperation(Operation operation) {
        operations.add(operation);
        operation.getRoles().add(this);
    }

    public void removeService(Operation service) {
        operations.remove(service);
    	service.getRoles().remove(this);
    }

    @Override
    public boolean equals(Object obj) {
        Role roleObj = (Role) obj;
        return super.equals(obj)
                && roleObj.name.equals(name)
                && roleObj.code.equals(code);
    }
}
