package exercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Alimento alimento = new Alimento();
    private List<Alimento> carrinho;
    private Scanner sc;
    private HashMap<String, String> opcoesAlimentos;
    private String tipo;

    public Menu(){
        carrinho = new ArrayList<>();
        sc = new Scanner(System.in);
        opcoesAlimentos = new HashMap<>();
        opcoesAlimentos.put("1", "Verdura");
        opcoesAlimentos.put("2", "Legumes");
        opcoesAlimentos.put("3", "Grãos");
        opcoesAlimentos.put("4", "Outros");
    }

    public void getOpcoesTipoAlimento(){
        for (String chaveTipo: opcoesAlimentos.keySet()){
            System.out.println(chaveTipo + " - " + opcoesAlimentos.get(chaveTipo));
        }
    }

    //Metodo que verifica o tipo de alimento e retorna uma exceção para alimentos invalidos.
    public String verificarTipoAlimento(String tipo){
        if (opcoesAlimentos.containsValue(tipo) ||
                opcoesAlimentos.containsKey(tipo)){
            throw new IllegalArgumentException("Tipo de alimento inválido");
        }else {
            if (opcoesAlimentos.containsValue(tipo)){
                this.tipo = tipo;
            } else if (opcoesAlimentos.containsKey(tipo)) {
                this.tipo = opcoesAlimentos.get(tipo);
            }
            return this.tipo;
        }
    }

    //Verifica por nome
    public void vericaNome(String nome){
        if (nome.equalsIgnoreCase("")) throw new
                UnsupportedOperationException("Não é permitido nome vazio.");
    }

    //Metodo que adiciona verdura e graos por grama
    public void adicionarPorGramas(String tipo, double grama, String nome){
        carrinho.add(new Alimento(tipo, grama, nome));
    }

    //Adicionando por quantidade legumes e outros
    public void adicionarPorQuantidade(String tipo, int quantidade, String nome){
        carrinho.add(new Alimento(tipo, quantidade, nome));
    }

    //metodo que só adiciona o alimento pronto
    public void adicionar(Alimento alimentoPronto){
        carrinho.add(alimentoPronto);
    }

    //verificando valor vazio
    public void verificaValorVazio(String valor){
        if (valor.equalsIgnoreCase("")) throw new
                UnsupportedOperationException("Não é permitido o valor vazio.");
    }

    //verifica se a quantidade é positiva
    public int verificarUnidades(String quantidade){
        if (!quantidade.matches("[0-9] +")){
            throw new NumberFormatException ("Para " + tipo +
                    ", a quantidade deve ser informada com unidades " +
                    "inteiras.");
        }
        return Integer.parseInt(quantidade);
    }

    public double verificarGramas(String quantidade){
        if (!quantidade.matches("[0-9.] +")){
            throw new NumberFormatException ("Para" + tipo +
                    ", a quantidade de ser infrmada com " +
                    "ponto.");
        }
        return Double.parseDouble(quantidade);
    }

    //Metodo que mostra as infos do carrinho
    public void mostrarCarrinho(){
        alimento.setListaSeparadas(carrinho);

        System.out.println("--VERDURAS--");
        alimento.mostraInfoEmDecimal(alimento.getVerduras());

        System.out.println("--LEGUMES--");
        alimento.mostraInfoEmUnidadesInteiras(alimento.getLegumes());

        System.out.println("--GRAOS--");
        alimento.mostraInfoEmDecimal(alimento.getGraos());

        System.out.println("--OUTROS--");
        alimento.mostraInfoEmUnidadesInteiras(alimento.getOutros());

        System.out.println("Quantidade de Verduras: " + alimento.getVerduras().size());
        System.out.println("Quantidade de Legumes: " + alimento.getLegumes().size());
        System.out.println("Quantidade de Grãos: " + alimento.getGraos().size());
        System.out.println("Quantidade de Outros: " + alimento.getOutros().size());
    }

}
