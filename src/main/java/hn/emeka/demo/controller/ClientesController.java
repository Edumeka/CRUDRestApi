package hn.emeka.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hn.emeka.demo.model.ClientesEntity;
import hn.emeka.demo.service.ClienteService;





@RestController
@RequestMapping("api/v1/clientes")
public class ClientesController {
    @Autowired
    private ClienteService clienteService;


    @GetMapping("/todos")
    public List<ClientesEntity> obtenerClientes() {
       return clienteService.obtenerClientes();
    }
    @GetMapping("/{dni}")
    @ResponseBody
    public ClientesEntity obtenerUnCliente(@PathVariable Integer dni) {
            return clienteService.obtenerUnCliente(dni);   
    }
    @PostMapping("/crear")
    public ClientesEntity crearCliente(@RequestBody ClientesEntity cliente) {
        return this.clienteService.crearCliente(cliente);
    }
    
   @PutMapping("/actualizar/{dni}")
public ResponseEntity<Object> actualizarCliente(@PathVariable Integer dni, @RequestBody ClientesEntity cliente) {
    try {
        // Asigna el DNI recibido del @PathVariable al cliente
        cliente.setDni(dni);
        
        // Llama al servicio para actualizar el cliente
        ClientesEntity clienteActualizado = clienteService.actualizarCliente(cliente);
        
        // Devuelve la respuesta exitosa con el cliente actualizado
        return ResponseEntity.ok(clienteActualizado);
    } catch (RuntimeException e) {
        // Si ocurre un error, devuelve un mensaje de error adecuado
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + e.getMessage());
    }
}

    


}
