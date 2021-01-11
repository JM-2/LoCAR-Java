/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

public class Cliente {
    private String nome; //Encapsulamento dos Campos que são acessando e modificados apartir dos metodos get e set
    private String cpf;
    private String dataNacimento;
    
    public Cliente(){
        this.cpf = "";
        this.dataNacimento = "";
        this.nome = "";        
    }
    public Cliente(String vnome, String vcpf, String vdataNascimento){
        setDataNacimento(vdataNascimento);
        setNome(vnome);
        setCpf(vcpf);
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dataNacimento
     */
    public String getDataNacimento() {
        return dataNacimento;
    }

    /**
     * @param dataNacimento the dataNacimento to set
     */
    public void setDataNacimento(String dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

}
