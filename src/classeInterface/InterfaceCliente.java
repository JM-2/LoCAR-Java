/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeInterface;

import java.util.List;
import objetos.Cliente;

public interface InterfaceCliente {
  
    public List<Cliente> listarCliente();
    public boolean adicionarCliente(Cliente clienteNovo);
    public boolean removerCliente(Cliente clienteRemover);
    public boolean modificarCliente(int id, Cliente clienteAlterar);
    public Cliente getCliente(int id);
}
