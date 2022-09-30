package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.model.RoleModel;
import cybersoft.javabackend.java18.gira.role.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository repository;
    @Autowired
    private GiraMapper mapper;

    @Override
    public JpaRepository<RoleModel, UUID> getRepository() {
        return repository;
    }

    @Override
    public GiraMapper getMapper() {
        return mapper;
    }

    @Override
    public RoleModel update(RoleModel role, String code) {
        RoleModel foundRole = repository.findByCode(code).orElseGet(() -> {return null;});
        foundRole.setName(role.getName());
        foundRole.setDescription(role.getDescription());
        return foundRole;
    }

    @Override
    public void deleteByCode(String code) {
        repository.deleteByCode(code);
    }

    @Override
    public RoleDTO save(RoleDTO roleDto) {
        RoleModel role = mapToEntity(roleDto,RoleModel.class);
        role = repository.save(role);
        return mapToDto(role,RoleDTO.class);
    }
}
