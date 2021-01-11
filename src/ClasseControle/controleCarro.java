/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseControle;
import classeInterface.InterfaceCarro;
import classeRepositorio.repositorioCarro;
import java.util.ArrayList;
import java.util.List;
import objetos.Carro;

public class controleCarro {
    private static InterfaceCarro interfaceCarroRepositorio;
    
    public controleCarro(){
        synchronized(InterfaceCarro.class){ 
            if(interfaceCarroRepositorio == null){ 
                interfaceCarroRepositorio = new repositorioCarro();
            }
        }
    }
    public List<Carro> listarCarro(){
        List<Carro> listaTodosCarros = interfaceCarroRepositorio.listarCarro();
        return listaTodosCarros;
    }
    public boolean adicionarCarro(Carro carroNovo){
        boolean confirmacaoAdicionado = false;
        if(interfaceCarroRepositorio.adicionarCarro(carroNovo)){
            confirmacaoAdicionado = true;
        }
        return confirmacaoAdicionado;
    }
    public boolean removerCarro(int id){
        boolean confirmacaoRemocao = false;
        if(interfaceCarroRepositorio.removerCarro(interfaceCarroRepositorio.getCarro(id))){
            confirmacaoRemocao = true;
        }
        return confirmacaoRemocao;
    }
    public boolean modificarCarro(int id,Carro carroAlterar){
        boolean confirmacaoModificarCarro = false;
        if(interfaceCarroRepositorio.modificarCarro(id, carroAlterar)){
            confirmacaoModificarCarro = true;
        }
        return confirmacaoModificarCarro;
    }
    public Carro getCarro(int id){
        return interfaceCarroRepositorio.getCarro(id);
    }
}
