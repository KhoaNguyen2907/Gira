package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.service.IGenericService;
import cybersoft.javabackend.java18.gira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;

import java.util.UUID;

public interface IOperationService extends IGenericService<Operation, OperationDTO, UUID> {
}
