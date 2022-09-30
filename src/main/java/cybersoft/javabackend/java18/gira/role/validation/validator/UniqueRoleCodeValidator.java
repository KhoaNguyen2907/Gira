package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.RoleModel;
import cybersoft.javabackend.java18.gira.role.repository.IRoleRepository;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleCodeValidator implements ConstraintValidator<UniqueRoleCode,String> {
    private String message;
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void initialize(UniqueRoleCode constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        Optional<RoleModel> role = roleRepository.findByCode(code);
        if (role.isEmpty()){
            return true;
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}
