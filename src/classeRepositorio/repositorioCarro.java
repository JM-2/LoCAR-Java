/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeRepositorio;

import classeInterface.InterfaceCarro;
import java.util.ArrayList;
import java.util.List;
import objetos.Carro;

public class repositorioCarro implements InterfaceCarro{
    
    List<Carro> repositorioCarro = new ArrayList<>();

    @Override
    public List<Carro> listarCarro() {
        return repositorioCarro;
    }

    @Override
    public boolean adicionarCarro(Carro carroNovo) {
        return repositorioCarro.add(carroNovo);
    }

    @Override
    public boolean removerCarro(Carro carroRemover) {
        return repositorioCarro.remove(carroRemover);
    }

    @Override
    public boolean modificarCarro(int id, Carro carroAlterar) {
        repositorioCarro.set(id, carroAlterar);
        return true;
    }

    @Override
    public Carro getCarro(int id) {
       return repositorioCarro.get(id);
    }

}
