/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseControle;
import classeInterface.InterfaceCliente;
import classeRepositorio.repositorioCliente;
import java.util.List;
import objetos.Cliente;

public class controleCliente {
    
    private static InterfaceCliente interfaceClienteRepositorio;
    
    public controleCliente(){
        synchronized(InterfaceCliente.class){
            if(interfaceClienteRepositorio == null){
                interfaceClienteRepositorio = new repositorioCliente();
            }
        }
    }
    public List<Cliente> listarCliente(){
        List<Cliente> listarTodosCliente = interfaceClienteRepositorio.listarCliente();
        return listarTodosCliente;
    }
    public boolean adicionarCliente(Cliente clienteNovo){
        boolean confirmacaoAdicionado = false;
        if(interfaceClienteRepositorio.adicionarCliente(clienteNovo)){
            confirmacaoAdicionado = true;
        }
        return confirmacaoAdicionado;
    }
    public boolean removerCliente(int id){ 
        boolean confirmacaoRemovido = false;
        if(interfaceClienteRepositorio.removerCliente(interfaceClienteRepositorio.getCliente(id))){
            confirmacaoRemovido = true;
        }
        return confirmacaoRemovido;
    }
    public boolean modificarCliente(int id, Cliente clienteAlterar){
        boolean confirmacaoAlterado = false;
        if(interfaceClienteRepositorio.modificarCliente(id, clienteAlterar)){
            confirmacaoAlterado = true;
        }
        return confirmacaoAlterado;
    }
    public Cliente getCliente(int id){
        return interfaceClienteRepositorio.getCliente(id); 
    }
}
