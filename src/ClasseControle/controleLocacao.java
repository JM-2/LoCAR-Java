/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseControle;

import java.util.List;
import classeInterface.InterfaceAluguel;
import classeRepositorio.repositorioLocacao;
import objetos.LocacaoCarro;

public class controleLocacao {
    
    private static InterfaceAluguel interfaceLocacaoRepositorio;
    controleCarro controleCarro = new controleCarro();
    controleCliente controleCliente = new controleCliente();
    
    public controleLocacao(){
        synchronized(InterfaceAluguel.class){
            if(interfaceLocacaoRepositorio == null){
                interfaceLocacaoRepositorio = new repositorioLocacao();
            }
        }
    }
    public List<LocacaoCarro> listarLocacao(){
        List<LocacaoCarro> listarTodasLocacao = interfaceLocacaoRepositorio.listarLocacao();
        return listarTodasLocacao;
    }
    public boolean adicionarLocacao(int idCliente , int idCarro){
        boolean confirmacaoAdicionado = false;
        LocacaoCarro locacaoNova = new LocacaoCarro(controleCliente.getCliente(idCliente), controleCarro.getCarro(idCarro));
        if(interfaceLocacaoRepositorio.adicionarLocacao(locacaoNova)){
            confirmacaoAdicionado = true;
        }
        return confirmacaoAdicionado;
    }
    public boolean removerLocacao(int id){
        boolean confirmacaoRemover = false;
        if(interfaceLocacaoRepositorio.removerLocacao(interfaceLocacaoRepositorio.getLocacao(id))){
            confirmacaoRemover = true;
        }
        return confirmacaoRemover;
    }
}
