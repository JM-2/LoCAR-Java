/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuExibicao;

import ClasseControle.controleCarro;
import ClasseControle.controleCliente;
import ClasseControle.controleLocacao;
import java.util.List;
import java.util.Scanner;
import objetos.Carro;
import objetos.Cliente;
import objetos.LocacaoCarro;

public class menu {
    Scanner leitor = new Scanner(System.in);
    controleCliente todosControleCliente = new controleCliente();
    controleCarro todosControleCarro = new controleCarro();
    controleLocacao todosControleLocacao = new controleLocacao();
    
    public menu(){
        menuExibicao();
    }    
    private void menuExibicao(){ 
        try {
        System.out.println("Menu");
        System.out.println("Escolha uma das opção a baixo:");
        System.out.println("-------------------------------");
        System.out.println("Cliente");
        System.out.println("1 - cadastrar Cliente");
        System.out.println("2 - Listar Cliente");
        System.out.println("3 - Exlcluir Cliente");
        System.out.println("4 - Editar Cliente");
        System.out.println("-------------------------------");
        System.out.println("Carro");
        System.out.println("5 - cadastrar Carro");
        System.out.println("6 - Listar Carro");
        System.out.println("7 - Exlcluir Carro");
        System.out.println("8 - Editar Carro");
        System.out.println("-------------------------------");
        System.out.println("Locação");
        System.out.println("9 - Alocar Carro");
        System.out.println("10 - Devolver Carro");
        System.out.println("11 - Listar Todas as Locações");
        System.out.println("-------------------------------");
        System.out.println("Opção:");
        int opcao = leitor.nextInt();
        
        switch(opcao){
            case 1:
                cadastraCliente();
                break;
            case 2:
                ListarCliente();
                break;
            case 3:
                ExluirCliente();
                break;
            case 4:
                EditarCliente();
                break;
            case 5:
                cadastraCarro();
                break;
            case 6:
                ListarCarro();
                break;
            case 7:
                ExluirCarro();
                break;
            case 8:
                EditarCarro();
                break;
            case 9:
                alocarCarro();
                break;
            case 10:
                devolverCarro();
                break;
            case 11:
                listarLocacoes();
                break;
            default:
                System.out.println("Opcao Invalida!!Digite a opcao Novamente!!");
                menuExibicao();
                break;
        }       
        } catch (Exception e) {
            System.out.println("Algo de Errado Aconteceu,Programa Encerrado!!");
            
        }
    }
    public void cadastraCliente(){
        System.out.println("Informe o nome do Cliente; Obs:sem espaço - Ex:Victoria_Siva_Monteiro"); 
        String nomeCliente = leitor.next(); 
        leitor.nextLine();
        System.out.println("Informe o cpf do Cliente:");
        String cpfCliente = leitor.next();
        
        while(!(cpfCliente.length()>=11) || !(cpfCliente.length()<12)){
            System.out.println("Cpf invalido,digite os seu onze numeros do seu cpf, sem os pontos: ");
            System.out.println("Informe o cpf do Cliente:");
            cpfCliente = leitor.next();
        }        
        leitor.nextLine();
        System.out.println("Informe a data de nascimento do cliente: exemplo:11/11/1999");
        String dataNascimento = leitor.next();
        while(!(dataNascimento.length()>=10) || !(dataNascimento.length()<11)){
            System.out.println("Data de Nascimento invalida,digite os seu dez numeros da sua data de nascimento, com as barras da data exemplo:11/11/1999: ");
            System.out.println("Informe o cpf do Cliente:");
            dataNascimento = leitor.next();
        }
        leitor.nextLine();
        Cliente clienteNovo  = new Cliente(nomeCliente, cpfCliente, dataNascimento);
        boolean conf = todosControleCliente.adicionarCliente(clienteNovo);
        if(conf){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Usuario Cadastrado com sucesso!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("erro, Usuario não cadastrado!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }
        
    }
    public void ListarCliente(){
        List<Cliente> listaCliente = todosControleCliente.listarCliente();
        for(int i=0;i<listaCliente.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Nome do Cliente: " + listaCliente.get(i).getNome());
            System.out.println("Cpf: " + listaCliente.get(i).getCpf());
            System.out.println("Data de nascimento: " + listaCliente.get(i).getDataNacimento());
            System.out.println("--------------------------------------------------------------");
        }
         menuExibicao();
    }
    public void ExluirCliente(){
        List<Cliente> listaCliente = todosControleCliente.listarCliente();
        try {
            for(int i=0;i<listaCliente.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("ID: " +i+ " Nome do Cliente: " + listaCliente.get(i).getNome() + " Cpf: " + listaCliente.get(i).getCpf() + " Data de nascimento: " + listaCliente.get(i).getDataNacimento());
            System.out.println("--------------------------------------------------------------");
        }
            System.out.println("================================");
            System.out.println("Escolha o id do usuario que deseja excluir: ");
            int idRemover = leitor.nextInt();

             boolean confirmacao = todosControleCliente.removerCliente(idRemover);
                if(confirmacao){
                   System.out.println("--------------------------------------------------------------");
                   System.out.println("Usuario Excluido com sucesso!!!");
                   System.out.println("--------------------------------------------------------------");            
               }else{
                   System.out.println("--------------------------------------------------------------");
                   System.out.println("erro, Usuario não Excluido!!!");
                   System.out.println("--------------------------------------------------------------");            
               }
            int voltar = 7;
            while(voltar!= 0 || voltar !=1){
                System.out.println("================================");
                System.out.println("Deseja excluir mais algum usuario? 1 = sim ou 0 = não");
                voltar = leitor.nextInt();
                    if(voltar==1){
                        ExluirCliente();
                    }if(voltar==0){
                        menuExibicao();
                    }else{
                        System.out.println("Opcao Invalida!!");
                    }
            }
        } catch (Exception e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERRO,Não existe esse id do usuario para ser excluido!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }      
    }
    public void EditarCliente(){
        List<Cliente> listaCliente = todosControleCliente.listarCliente();
       
        try {
            for(int i=0;i<listaCliente.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("ID: " +i+ " Nome do Cliente: " + listaCliente.get(i).getNome() + " Cpf: " + listaCliente.get(i).getCpf() + " Data de nascimento: " + listaCliente.get(i).getDataNacimento());
            System.out.println("--------------------------------------------------------------");
        }
            System.out.println("================================");
            System.out.println("Escolha o id do usuario que deseja Editar: ");
            int idEditar = leitor.nextInt();
            
            if(idEditar>-1){
                System.out.println("Informe o nome do Cliente; Obs:sem espaço - Ex:Victoria_Siva_Monteiro"); 
                String nomeCliente = leitor.next();
                leitor.nextLine();
                System.out.println("Informe o cpf do Cliente:");
                String cpfCliente = leitor.next();
                leitor.nextLine();
                System.out.println("Informe a data de nascimento do cliente: exemplo:11/11/1999");
                String dataNascimento = leitor.next();
                while(!(dataNascimento.length()>=10) || !(dataNascimento.length()<11)){
                    System.out.println("Data de Nascimento invalida,digite os seu dez numeros da sua data de nascimento, com as barras da data exemplo:11/11/1999: ");
                    System.out.println("Informe o cpf do Cliente:");
                    dataNascimento = leitor.next();
                }
                leitor.nextLine();
                Cliente clienteEditar  = new Cliente(nomeCliente, cpfCliente, dataNascimento);
                    boolean confirmacao = todosControleCliente.modificarCliente(idEditar, clienteEditar);
                        if(confirmacao){
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("Usuario editado com sucesso!!!");
                            System.out.println("--------------------------------------------------------------");
                            menuExibicao();
                        }else{
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("erro, Usuario não editado!!!");
                            System.out.println("--------------------------------------------------------------");
                            menuExibicao();
                        }
            }
        } catch (Exception e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERRO,Não existe esse id do usuario para ser editado!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }
        
        
    }
    ////////////////////////////////////CARRO//////////////////////
    public void cadastraCarro(){
        System.out.println("Informe o nome do carro: Obs:sem espaço");
        String nomeCarro = leitor.next();
        leitor.nextLine();
        System.out.println("Informe a marca do carro: ");
        String marcaCarro = leitor.next();
        leitor.nextLine();
        System.out.println("Informe a placa do carro: ");
        String placaCarro = leitor.next();
        leitor.nextLine();
        System.out.println("Informe o valor da locacao do carro");
        Double valorCarro = leitor.nextDouble();
        leitor.nextLine();
        Carro carroNovo = new Carro(nomeCarro, marcaCarro, placaCarro, valorCarro);
        boolean confirmacao = todosControleCarro.adicionarCarro(carroNovo);
        if(confirmacao){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Carro Cadastrado com sucesso!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("erro, Carro não cadastrado!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }
    }
    public void ListarCarro(){
        List<Carro> listaTodosCarros = todosControleCarro.listarCarro();
        for(int i=0;i<listaTodosCarros.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Nome carro: " + listaTodosCarros.get(i).getNome());
            System.out.println("Marca: " + listaTodosCarros.get(i).getMarca());
            System.out.println("Placa: "+ listaTodosCarros.get(i).getPlacaCarro());
            System.out.println("Valor para alugar: " + listaTodosCarros.get(i).getValor());
            System.out.println("--------------------------------------------------------------");
        }
        menuExibicao();
    }
    public void ExluirCarro(){
        try {
            List<Carro> listaTodosCarros = todosControleCarro.listarCarro();
        for(int i=0;i<listaTodosCarros.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Id carro: " + i);
            System.out.println("Nome carro: " + listaTodosCarros.get(i).getNome());
            System.out.println("Marca: " + listaTodosCarros.get(i).getMarca());
            System.out.println("Placa: "+ listaTodosCarros.get(i).getPlacaCarro());
            System.out.println("Valor para alugar: " + listaTodosCarros.get(i).getValor());
            System.out.println("--------------------------------------------------------------");
        }
            System.out.println("================================");
            System.out.println("Escolha o id do carro que deseja excluir: ");
            int idRemover = leitor.nextInt();

             boolean confirmacao = todosControleCarro.removerCarro(idRemover);
                if(confirmacao){
                   System.out.println("--------------------------------------------------------------");
                   System.out.println("Carro Excluido com sucesso!!!");
                   System.out.println("--------------------------------------------------------------");            
               }else{
                   System.out.println("--------------------------------------------------------------");
                   System.out.println("erro, Carro não Excluido!!!");
                   System.out.println("--------------------------------------------------------------");            
               }
            int voltar = 7;
            while(voltar!= 0 || voltar !=1){
                System.out.println("================================");
                System.out.println("Deseja excluir mais algum Carro? 1 = sim ou 0 = não");
                voltar = leitor.nextInt();
                    if(voltar==1){
                        ExluirCliente();
                    }if(voltar==0){
                        menuExibicao();
                    }else{
                        System.out.println("Opcao Invalida!!");
                    }            
        }
        }catch (Exception e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERRO,Não existe esse id do carro para ser excluido!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }
    }
    public void EditarCarro(){
        List<Carro> listaTodosCarros = todosControleCarro.listarCarro();
        try {
            for(int i=0;i<listaTodosCarros.size();i++){
            System.out.println("Id do Carro: " + i);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Nome carro: " + listaTodosCarros.get(i).getNome());
            System.out.println("Marca: " + listaTodosCarros.get(i).getMarca());
            System.out.println("Placa: "+ listaTodosCarros.get(i).getPlacaCarro());
            System.out.println("Valor para alugar: " + listaTodosCarros.get(i).getValor());
            System.out.println("--------------------------------------------------------------");
        }
            System.out.println("================================");
            System.out.println("Escolha o id do carro que deseja Editar: ");
            int idEditar = leitor.nextInt();
            
            if(idEditar>-1){
                System.out.println("Informe o nome do carro: Obs:sem espaço");
                String nomeCarro = leitor.next();
                leitor.nextLine();
                System.out.println("Informe a marca do carro: ");
                String marcaCarro = leitor.next();
                leitor.nextLine();
                System.out.println("Informe a placa do carro: ");
                String placaCarro = leitor.next();
                leitor.nextLine();
                System.out.println("Informe o valor da locacao do carro");
                Double valorCarro = leitor.nextDouble();
                leitor.nextLine();
                Carro carroEditar = new Carro(nomeCarro, marcaCarro, placaCarro, valorCarro);
                    boolean confirmacao = todosControleCarro.modificarCarro(idEditar, carroEditar);
                        if(confirmacao){
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("Carro Editado com sucesso!!!");
                            System.out.println("--------------------------------------------------------------");
                            menuExibicao();
                        }else{
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("erro, Carro não Editado!!!");
                            System.out.println("--------------------------------------------------------------");
                            menuExibicao();
                }
            }
        } catch (Exception e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERRO,Não existe esse id do carro para ser editado!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }
    }
    ///////////////////////////////////LOCACAO////////////////////
    public void alocarCarro(){
        List<Cliente> listaCliente = todosControleCliente.listarCliente();
        try {
            for(int i=0;i<listaCliente.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Id Cliente: " + i);
            System.out.println("Nome do Cliente: " + listaCliente.get(i).getNome());
            System.out.println("Cpf: " + listaCliente.get(i).getCpf());
            System.out.println("Data de nascimento: " + listaCliente.get(i).getDataNacimento());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("================================");
            System.out.println("Escolha o id do usuario que desejar fazer a locacao de carro: ");
            int idCliente = leitor.nextInt();
            if(idCliente>-1){
                List<Carro> listaTodosCarros = todosControleCarro.listarCarro();
       
                for(int i=0;i<listaTodosCarros.size();i++){
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Id Carro: " + i);
                    System.out.println("Nome carro: " + listaTodosCarros.get(i).getNome());
                    System.out.println("Marca: " + listaTodosCarros.get(i).getMarca());
                    System.out.println("Placa: "+ listaTodosCarros.get(i).getPlacaCarro());
                    System.out.println("Valor para alugar: " + listaTodosCarros.get(i).getValor());
                    System.out.println("--------------------------------------------------------------");
                }
                    System.out.println("================================");
                    System.out.println("Escolha o id do carro que deseja alocar: ");
                    int idcarro = leitor.nextInt();
                    boolean confirmacaoLocacao = todosControleLocacao.adicionarLocacao(idCliente, idcarro);
                    if(confirmacaoLocacao){
                        System.out.println("--------------------------------------------------------------");                        
                        System.out.println("Alocação realizada com sucesso!!!");
                        System.out.println("--------------------------------------------------------------");
                        menuExibicao();
                    }
                    else{
                        System.out.println("--------------------------------------------------------------");                        
                        System.out.println("Erro, a locacao não foi realizada com exito!!!");
                        System.out.println("--------------------------------------------------------------");
                        menuExibicao();
                    }
            }
        } catch (Exception e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERRO,Não existe esse id do usuario ou carro para ser alocado!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }
        
    }
    public void devolverCarro(){
        List<LocacaoCarro> todosLocacoesExitente = todosControleLocacao.listarLocacao();
        try {
            for(int i=0;i<todosLocacoesExitente.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Id Locação: " + i);
            System.out.println("Nome do Cliente: " + todosLocacoesExitente.get(i).getClienteAluguel().getNome());
            System.out.println("Cpf do Cliente: " + todosLocacoesExitente.get(i).getClienteAluguel().getCpf());
            System.out.println("Nome do Carro: " + todosLocacoesExitente.get(i).getCarroCliente().getNome());
            System.out.println("Placa do Carro: " + todosLocacoesExitente.get(i).getCarroCliente().getPlacaCarro());
            System.out.println("Valor do alugeul: " + todosLocacoesExitente.get(i).getCarroCliente().getValor());           
            System.out.println("--------------------------------------------------------------");
        }
            System.out.println("================================");
            System.out.println("Escolha o id da Alocacao que deseja Devolver: ");
            int idRemover = leitor.nextInt();
            /////
             boolean confirmacao = todosControleLocacao.removerLocacao(idRemover);
                if(confirmacao){
                   System.out.println("--------------------------------------------------------------");
                   System.out.println("Carro devolvido!!");
                   System.out.println("--------------------------------------------------------------"); 
                   menuExibicao();
               }else{
                   System.out.println("--------------------------------------------------------------");
                   System.out.println("Erro, Carro não devolvido!!");
                   System.out.println("--------------------------------------------------------------"); 
                   menuExibicao();
               }
            int voltar = 7;
            while(voltar!= 0 || voltar !=1){
                System.out.println("================================");
                System.out.println("Deseja devolver mais algum carro? 1 = sim ou 0 = não");
                voltar = leitor.nextInt();
                    if(voltar==1){
                        ExluirCliente();
                    }if(voltar==0){
                        menuExibicao();
                    }else{
                        System.out.println("Opcao Invalida!!");
                    }            
            }
        } catch (Exception e) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("ERRO,Não existe esse id do carro para ser excluido!!!");
            System.out.println("--------------------------------------------------------------");
            menuExibicao();
        }
    }
    public void listarLocacoes(){
        List<LocacaoCarro> todosLocacoesExitente = todosControleLocacao.listarLocacao();
        for(int i=0;i<todosLocacoesExitente.size();i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println("Nome do Cliente: " + todosLocacoesExitente.get(i).getClienteAluguel().getNome());
            System.out.println("Cpf do Cliente: " + todosLocacoesExitente.get(i).getClienteAluguel().getCpf());
            System.out.println("Nome do Carro: " + todosLocacoesExitente.get(i).getCarroCliente().getNome());
            System.out.println("Placa do Carro: " + todosLocacoesExitente.get(i).getCarroCliente().getPlacaCarro());
            System.out.println("Valor do alugeul: " + todosLocacoesExitente.get(i).getCarroCliente().getValor());           
            System.out.println("--------------------------------------------------------------");
        }
        menuExibicao();
    }    
}
