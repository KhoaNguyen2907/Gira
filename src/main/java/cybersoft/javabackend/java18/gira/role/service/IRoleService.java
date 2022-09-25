package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.IGenericService;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.model.RoleModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
public interface IRoleService extends IGenericService<RoleModel, RoleDTO, UUID> {
    RoleModel update(RoleModel role, String code);
    void deleteByCode(String code);

}
