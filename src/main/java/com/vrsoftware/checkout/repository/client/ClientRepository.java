package com.vrsoftware.checkout.repository.client;

import com.vrsoftware.checkout.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
