package cybersoft.javabackend.java18.gira.role.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RoleRestResource {
    @Autowired
    private IRoleService service;

    @GetMapping
    public Object getRoles() {
        List<RoleDTO> list = service.findAllDto(RoleDTO.class);
        return ResponseUtils.get(list, HttpStatus.OK);
    }

    @GetMapping("/paging")
    public Object findAllDtoPaging(@RequestParam("size") int size,
                                   @RequestParam("index") int index) {
        return ResponseUtils.get(
                service.findAllDto(Pageable.ofSize(size).withPage(index), RoleDTO.class)
                , HttpStatus.OK
        );
    }

    @PostMapping
    public Object addRole(@Valid @RequestBody RoleDTO role) {
        return ResponseUtils.get(service.save(role), HttpStatus.CREATED);
    }

    @PostMapping("/{roleId}/add-operations")
    public ResponseEntity<?> addOperationsToRole(@PathVariable UUID roleId, @RequestBody List<UUID> operationIds) {
        return ResponseUtils.get(service.addOperationsToRole(operationIds, roleId), HttpStatus.OK);
    }

    @PutMapping
    public Object updateRole(@RequestBody Role role, @PathVariable("code") String code) {
        return ResponseUtils.get(service.mapToDto(service.update(role, code), RoleDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public Object deleteRole(@PathVariable String code) {
        service.deleteByCode(code);
        return ResponseUtils.get(code, HttpStatus.OK);
    }
}

