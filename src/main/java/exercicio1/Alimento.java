package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Alimento {

    //Atributos
    private String tipoAlimento;
    private double quantidaDouble;
    private int quantidadeInteiro;
    private String nomeDoAlimento;

    List<Alimento> verduras = new ArrayList<>();
    List<Alimento> legumes = new ArrayList<>();
    List<Alimento> graos = new ArrayList<>();
    List<Alimento> outros = new ArrayList<>();

    //Construtores


    public Alimento(String tipoAlimento, double quantidaDouble, String nomeDoAlimento) {
        this.tipoAlimento = tipoAlimento;
        this.quantidaDouble = quantidaDouble;
        this.nomeDoAlimento = nomeDoAlimento;
    }

    public Alimento(String tipoAlimento, int quantidadeInteiro, String nomeDoAlimento) {
        this.tipoAlimento = tipoAlimento;
        this.quantidadeInteiro = quantidadeInteiro;
        this.nomeDoAlimento = nomeDoAlimento;
    }

    public Alimento() {
    }

    //Getters and Setters
    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public double getQuantidaDouble() {
        return quantidaDouble;
    }

    public void setQuantidaDouble(double quantidaDouble) {
        this.quantidaDouble = quantidaDouble;
    }

    public int getQuantidadeInteiro() {
        return quantidadeInteiro;
    }

    public void setQuantidadeInteiro(int quantidadeInteiro) {
        this.quantidadeInteiro = quantidadeInteiro;
    }

    public String getNomeDoAlimento() {
        return nomeDoAlimento;
    }

    public void setNomeDoAlimento(String nomeDoAlimento) {
        this.nomeDoAlimento = nomeDoAlimento;
    }

    //Getters das listas

    public List<Alimento> getVerduras() {
        return verduras;
    }

    public List<Alimento> getLegumes() {
        return legumes;
    }

    public List<Alimento> getGraos() {
        return graos;
    }

    public List<Alimento> getOutros() {
        return outros;
    }

    //método que da um set nas lista de forma separada
    public void setListasSeparadas(List<Alimento> alimentos){

        for (Alimento alimento:alimentos){
            if (alimento.getTipoAlimento().equalsIgnoreCase("verdura")){
                verduras.add(alimento);
            }else if (alimento.getTipoAlimento().equalsIgnoreCase("legumes")){
                legumes.add(alimento);
            }else if (alimento.getTipoAlimento().equalsIgnoreCase("grãos")){
                graos.add(alimento);
            }else if (alimento.getTipoAlimento().equalsIgnoreCase("outros")){
                outros.add(alimento);
            }
        }
    }

    //método que mostra as informações em decimal(Verduras e grãos)
    public void mostraInfoEmDecimal(List<Alimento> alimentos){
        for (Alimento alimento:alimentos){
            System.out.println("Tipo: " + alimento.getTipoAlimento());
            System.out.println("Nome: " + alimento.getNomeDoAlimento());
            System.out.println("Quantidade: " + alimento.getQuantidaDouble());
        }
    }

    //método que mostra as informações em unidades inteira(Legumes e outros)
    public void mostraInfoEmUnidadesInteiras(List<Alimento> alimentos){

        for (Alimento alimento:alimentos){
            System.out.println("Tipo: " + alimento.getTipoAlimento());
            System.out.println("Nome: " + alimento.getNomeDoAlimento());
            System.out.println("Quantidade: " + alimento.getQuantidadeInteiro() );
        }

    }
}