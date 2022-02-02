package cxf.boot.service.impl;

import cxf.boot.model.Client;
import cxf.boot.repository.ClientRepository;
import cxf.boot.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
