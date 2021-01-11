/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

public class LocacaoCarro {
    private Cliente clienteAluguel; 
    private Carro carroCliente;  
    
    public LocacaoCarro(Cliente vcliente, Carro vcarro){
        setCarroCliente(vcarro);
        setClienteAluguel(vcliente);
    }

    /**
     * @return the clienteAluguel
     */
    public Cliente getClienteAluguel() {
        return clienteAluguel;
    }

    /**
     * @param clienteAluguel the clienteAluguel to set
     */
    public void setClienteAluguel(Cliente clienteAluguel) {
        this.clienteAluguel = clienteAluguel;
    }

    /**
     * @return the carroCliente
     */
    public Carro getCarroCliente() {
        return carroCliente;
    }

    /**
     * @param carroCliente the carroCliente to set
     */
    public void setCarroCliente(Carro carroCliente) {
        this.carroCliente = carroCliente;
    }
}
