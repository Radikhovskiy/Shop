package cxf.boot.service;

import cxf.boot.model.Client;
import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client getById(Long id);

    Client save(Client client);
}
