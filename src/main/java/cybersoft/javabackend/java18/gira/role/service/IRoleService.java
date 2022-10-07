package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.IGenericService;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.dto.RoleWithOperationsDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.model.Role;

import java.util.List;
import java.util.UUID;
public interface IRoleService extends IGenericService<Role, RoleDTO, UUID> {
    Role update(Role role, String code);
    void deleteByCode(String code);
    RoleDTO save(RoleDTO roleDto);
    RoleWithOperationsDTO addOperationsToRole(List<UUID> ids, UUID roleId);
}
