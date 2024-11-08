package hn.emeka.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.emeka.demo.model.ClientesEntity;
import hn.emeka.demo.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired    
    private ClienteRepository clienteRepository;

    public List<ClientesEntity> obtenerClientes(){
            return this.clienteRepository.findAll();        
    }
/**
 * Obtiene un registro de la tabla clientes por medio del dni
 * @param dni
 * @return
 */
    public ClientesEntity obtenerUnCliente(Integer dni){
        Optional<ClientesEntity> cliente = this.clienteRepository.findById(dni);
        return cliente.orElse(null); // Devuelve el cliente o null si no se encuentra
    }

    /**
     * Guarda o actualiza un registro en la tabla clientes
     * @param cliente
     * @return
     */
    public ClientesEntity crearCliente(ClientesEntity cliente){
            return clienteRepository.save(cliente);
    }

    
    /**
     * Actualiza un registro en la tabla clientes
     * @param cliente
     * @return
     */
    public ClientesEntity actualizarCliente(ClientesEntity cliente) {
        // Verifica si el cliente existe en la base de datos
        Optional<ClientesEntity> clienteExistente = clienteRepository.findById(cliente.getDni());
    
        if (clienteExistente.isPresent()) {
            // Si el cliente existe, lo actualiza
            return clienteRepository.save(cliente);
        } else {
            // Si el cliente no existe, lanza una excepción o maneja el caso como prefieras
            throw new RuntimeException("Cliente con DNI " + cliente.getDni() + " no encontrado.");
        }
    }
    





}
