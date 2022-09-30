package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_role")
public class RoleModel extends BaseEntity implements Serializable {

    @Column(name = "name")
    @Length (min = 5, max = 50, message = "Role name must be between {min} and {max} characters")
    private String name;

    @Column(name = "code" , unique = true)
    @Length(min = 6, max = 6, message = "Code must be 6 characters")
    private String code;

    @Column(name = "description")
    @NotBlank
    private String description;

    @Override
    public boolean equals(Object obj) {
        RoleModel roleObj = (RoleModel) obj;
        return super.equals(obj)
                && roleObj.name.equals(name)
                && roleObj.code.equals(code);
    }
}
