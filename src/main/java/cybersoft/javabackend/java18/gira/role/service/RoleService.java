package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.dto.RoleWithOperationsDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;
    private final GiraMapper mapper;
    private final IOperationService operationService;

    public RoleService(IRoleRepository repository, GiraMapper mapper, IOperationService operationService) {
        this.roleRepository = repository;
        this.mapper = mapper;
        this.operationService = operationService;
    }


    @Override
    public JpaRepository<Role, UUID> getRepository() {
        return roleRepository;
    }

    @Override
    public GiraMapper getMapper() {
        return mapper;
    }

    @Override
    public Role update(Role role, String code) {
        Role foundRole = roleRepository.findByCode(code).orElseGet(() -> {return null;});
        foundRole.setName(role.getName());
        foundRole.setDescription(role.getDescription());
        return foundRole;
    }

    @Override
    public void deleteByCode(String code) {
        roleRepository.deleteByCode(code);
    }

    @Override
    public RoleDTO save(RoleDTO roleDto) {
        Role role = mapToEntity(roleDto, Role.class);
        Role savedRole = roleRepository.save(role);
        return mapToDto(savedRole,RoleDTO.class);
    }

    @Override
    public RoleWithOperationsDTO addOperationsToRole(List<UUID> ids, UUID roleId) {
        List<Operation> operations = operationService.findAllByIds(ids);
        Role role = roleRepository.findById(roleId).orElseThrow(
                () -> new ConstraintViolationException("Role not found", null)
        );
        operations.forEach(role::addOperation);
        return mapper.map(role, RoleWithOperationsDTO.class);
    }


}
