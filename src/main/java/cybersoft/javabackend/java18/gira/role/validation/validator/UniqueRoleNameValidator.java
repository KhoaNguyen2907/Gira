package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.RoleModel;
import cybersoft.javabackend.java18.gira.role.repository.IRoleRepository;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName,String> {
    private String message;

    @Autowired
    private IRoleRepository repository;

    @Override
    public void initialize(UniqueRoleName constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        Optional<RoleModel> role = repository.findByName(name);
        if (role.isEmpty()){
            return true;
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}
