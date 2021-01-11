/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeRepositorio;

import java.util.ArrayList;
import java.util.List;
import objetos.LocacaoCarro;
import classeInterface.InterfaceAluguel;

public class repositorioLocacao implements InterfaceAluguel{
    
    List<LocacaoCarro> repositorioLocacaoCarro = new ArrayList<>();
  
    @Override
    public List<LocacaoCarro> listarLocacao() {
        return repositorioLocacaoCarro; //retorna o reposiorio inteiro
    }
    
    @Override
    public boolean adicionarLocacao(LocacaoCarro locacaoNova) {
        return repositorioLocacaoCarro.add(locacaoNova);
    }

    @Override
    public boolean removerLocacao(LocacaoCarro locacaoRemover) {
        return repositorioLocacaoCarro.remove(locacaoRemover);
    }

    @Override
    public boolean modificarLocacao(int id, LocacaoCarro locacaoAlterar) {
       repositorioLocacaoCarro.set(id, locacaoAlterar);
       return true;
    }

    @Override
    public LocacaoCarro getLocacao(int id) {
        return repositorioLocacaoCarro.get(id);
    }
}
