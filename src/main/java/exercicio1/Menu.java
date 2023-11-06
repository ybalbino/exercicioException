package exercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {

    //Atributos

    Alimento alimento = new Alimento();
    private List<Alimento> carrinho;
    private Scanner entrada;
    private HashMap<String, String> opcoesTipoAlimento;
    private String tipo;

    //Método Menu
    public Menu(){
        carrinho = new ArrayList<>();
        entrada = new Scanner(System.in);
        opcoesTipoAlimento = new HashMap<>();
        opcoesTipoAlimento.put("1", "Verdura");
        opcoesTipoAlimento.put("2", "Legumes");
        opcoesTipoAlimento.put("3", "Grãos");
        opcoesTipoAlimento.put("4", "Outros");
    }

    public void getOpcoesTipoAlimento(){
        for (String chaveTipo:opcoesTipoAlimento.keySet()){
            System.out.println(chaveTipo + " - " + opcoesTipoAlimento.get(chaveTipo));
        }
    }

    //método que verifica o tipo de alimento e estoura uma exceção caso seja inválido.
    public String verificarTipoAlimento(String tipo){
        if(!(opcoesTipoAlimento.containsValue(tipo) ||
                opcoesTipoAlimento.containsKey(tipo))){
            throw new IllegalArgumentException("Tipo de alimento inválido");
        }else {
            if (opcoesTipoAlimento.containsValue(tipo)){
                this.tipo = tipo;
            }else if (opcoesTipoAlimento.containsKey(tipo)){
                this.tipo = opcoesTipoAlimento.get(tipo);
            }
            return this.tipo;
        }
    }

    //método que adiciona verduras e grãos por gramas
    public void adicionarPorGramas(String tipo, String nome, double grama){
        carrinho.add(new Alimento(tipo, grama, nome));
    }

    //método que adiciona legumes e outros por quantidade
    public void adicionarPorQuantidade(String tipo, String nome, int quantidade){
        carrinho.add(new Alimento(tipo, quantidade, nome));
    }

    //método adiciona o alimento pronto
    public void adicionar(Alimento alimentoPronto){
        carrinho.add(alimentoPronto);
    }

    //método que verifica valor vazio
    public void verificaValorVazio(String valor){
        if (valor.equalsIgnoreCase("")) throw new
                UnsupportedOperationException("Não é permitido valor vazio");
    }

    //métodos que verifica se a quantidade do alimento está correta seguindo o que foi selecionado
    public int verificarUnidades(String quantidade){

        if (!quantidade.matches("[0-9]+")){
            throw new NumberFormatException("Para " + tipo + ", a quantidade deve " +
                    " ser informada com unidades inteiras positivas");
        }
        return Integer.parseInt(quantidade);
    }

    public double verificarGramas(String quantidade){

        if (!quantidade.matches("[0-9.]+")){
            throw new NumberFormatException("Para " + tipo + ", a quantidade deve" +
                    " ser informada com ponto e deve ser um número positivo.");
        }
        return Double.parseDouble(quantidade);
    }

    public void verificaNome(String nome){
        if (nome.equalsIgnoreCase("")) throw new
                UnsupportedOperationException("Não é permitido nome vazio");
    }

    //método mostra as informações do carrinho
    public void mostrarCarrinho(){

        alimento.setListasSeparadas(carrinho);

        System.out.println("--VERDURAS-- ");
        alimento.mostraInfoEmDecimal(alimento.getVerduras());

        System.out.println("--LEGUMES--");
        alimento.mostraInfoEmUnidadesInteiras(alimento.getLegumes());

        System.out.println("--GRÃOS--");
        alimento.mostraInfoEmDecimal(alimento.getGraos());

        System.out.println("--OUTROS--");
        alimento.mostraInfoEmUnidadesInteiras(alimento.getOutros());

        System.out.println("Quantidade de verduras: " + alimento.getVerduras().size());
        System.out.println("Quantidade de legumes: " + alimento.getLegumes().size());
        System.out.println("Quantidade de grãos: " + alimento.getGraos().size());
        System.out.println("Quantidade de outros: " + alimento.getOutros().size());
    }



}
