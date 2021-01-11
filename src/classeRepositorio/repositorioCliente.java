/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeRepositorio;

import classeInterface.InterfaceCliente;
import java.util.ArrayList;
import java.util.List;
import objetos.Cliente;

public class repositorioCliente implements InterfaceCliente{
   
    List<Cliente> repositorioCliente = new ArrayList<>();

    @Override
    public List<Cliente> listarCliente() {
        return repositorioCliente;
    }

    @Override
    public boolean adicionarCliente(Cliente clienteNovo) {
        return repositorioCliente.add(clienteNovo);
    }

    @Override
    public boolean removerCliente(Cliente clienteRemover) {
        return repositorioCliente.remove(clienteRemover);
    }

    @Override
    public boolean modificarCliente(int id, Cliente clienteAlterar) {
        repositorioCliente.set(id, clienteAlterar);
        return true;
    }

    @Override
    public Cliente getCliente(int id) {
        return  repositorioCliente.get(id);
    }

    
}
