package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Alimento {
    private String tipoAlimento;
    private double quantidadeDouble;
    private int quantidadeInteiro;
    private String nomeAlimento;

    List<Alimento> verduras = new ArrayList<>();
    List<Alimento> legumes = new ArrayList<>();
    List<Alimento> graos = new ArrayList<>();
    List<Alimento> outros = new ArrayList<>();

    public Alimento(String tipoAlimento, double quantidadeDouble, String nomeAlimento) {
        this.tipoAlimento = tipoAlimento;
        this.quantidadeDouble = quantidadeDouble;
        this.nomeAlimento = nomeAlimento;
    }

    public Alimento(String tipoAlimento, int quantidadeInteiro, String nomeAlimento) {
        this.tipoAlimento = tipoAlimento;
        this.quantidadeInteiro = quantidadeInteiro;
        this.nomeAlimento = nomeAlimento;
    }

    public Alimento() {
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public double getQuantidadeDouble() {
        return quantidadeDouble;
    }

    public void setQuantidadeDouble(double quantidadeDouble) {
        this.quantidadeDouble = quantidadeDouble;
    }

    public int getQuantidadeInteiro() {
        return quantidadeInteiro;
    }

    public void setQuantidadeInteiro(int quantidadeInteiro) {
        this.quantidadeInteiro = quantidadeInteiro;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    //Getters das Listas

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

    //Metodos que set nas listas de forma separada
    public void setListaSeparadas(List<Alimento> alimentos){
        for (Alimento alimento: alimentos) {
            if (alimento.getTipoAlimento().equalsIgnoreCase("verdura")){
                verduras.add(alimento);
            } else if (alimento.getTipoAlimento().equalsIgnoreCase("legumes")) {
                legumes.add(alimento);
            } else if (alimento.getTipoAlimento().equalsIgnoreCase("graos")) {
                graos.add(alimento);
            } else if (alimento.getTipoAlimento().equalsIgnoreCase("outros")) {
                outros.add(alimento);
            }
        }
    }

    //Mostra as infos em decimais (verduras, grãos)
    public void mostraInfoEmDecimal(List<Alimento> alimentos){
        for (Alimento alimento: alimentos){
            System.out.println("Tipo: " + alimento.getTipoAlimento());
            System.out.println("Nome: " + alimento.getNomeAlimento());
            System.out.println("Quantidade: " + alimento.getQuantidadeDouble());
        }
    }

    //Mostra as infos em unidades inteiras (Legumes, outros)
    public void mostraInfoEmUnidadesInteiras(List<Alimento> alimentos){
        for (Alimento alimento: alimentos){
            System.out.println("Tipo: " + alimento.getTipoAlimento());
            System.out.println("Nome: " + alimento.getNomeAlimento());
            System.out.println("Quantidade: " + alimento.getQuantidadeInteiro());
        }
    }
}
