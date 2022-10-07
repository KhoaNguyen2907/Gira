package cybersoft.javabackend.java18.gira.role.service;

import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.repository.IOperationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class OperationService implements IOperationService {

    private IOperationRepository operationRepository;
    private GiraMapper mapper;

    public OperationService(IOperationRepository operationRepositoryRepository, GiraMapper mapper) {
        this.operationRepository = operationRepositoryRepository;
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<Operation, UUID> getRepository() {
        return operationRepository;
    }

    @Override
    public GiraMapper getMapper() {
        return mapper;
    }

}
