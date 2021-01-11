/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeInterface;

import java.util.List;
import objetos.Carro;

public interface InterfaceCarro {
    
    public List<Carro> listarCarro();
    public boolean adicionarCarro(Carro carroNovo);
    public boolean removerCarro(Carro carroRemover);
    public boolean modificarCarro(int id,Carro carroAlterar);
    public Carro getCarro(int id);
}
