package cybersoft.javabackend.java18.gira.role.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.service.IOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/operations")
public class OperationRestResource {
    private final IOperationService operationService;

    public OperationRestResource(IOperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ResponseEntity<?> getAllServices() {
        return ResponseUtils.get(operationService.findAllDto(OperationDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveOperation(@Valid @RequestBody OperationDTO serviceDTO) {
        return ResponseUtils.get(operationService.save(operationService.mapToEntity(serviceDTO, Operation.class)), HttpStatus.OK);
    }




}
