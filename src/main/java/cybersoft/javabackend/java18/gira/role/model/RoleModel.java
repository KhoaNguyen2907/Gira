package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleName;
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
    @Length (min = 5, max = 50, message = "{role.name.length}")
    @UniqueRoleName
    private String name;

    @Column(name = "code" , unique = true)
    @Length(min = 5, max = 50, message = "{role.code.length}")
    private String code;

    @Column(name = "description")
    @NotBlank (message = "{role.description.blank}")
    private String description;

    @Override
    public boolean equals(Object obj) {
        RoleModel roleObj = (RoleModel) obj;
        return super.equals(obj)
                && roleObj.name.equals(name)
                && roleObj.code.equals(code);
    }
}
