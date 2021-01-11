/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeInterface;

import java.util.List;
import objetos.LocacaoCarro;

public interface InterfaceAluguel {
     
    public List<LocacaoCarro> listarLocacao();
    public boolean adicionarLocacao(LocacaoCarro locacaoNova);
    public boolean removerLocacao(LocacaoCarro locacaoRemover);
    public boolean modificarLocacao(int id,LocacaoCarro locacaoAlterar);
    public LocacaoCarro getLocacao(int id);
}
