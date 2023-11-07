package exercicio2;

import java.math.BigDecimal;
import java.util.HashMap;

public class Conversao  {

    HashMap<String, BigDecimal> moedas = new HashMap<>();
    private String tipo;

    //Populando o HasMap
    public Conversao(){
        moedas.put("Dolar Americano", new BigDecimal("5.25"));
        moedas.put("Dolar Canadense", new BigDecimal("4.15"));
        moedas.put("Euro", new BigDecimal("6.15"));
        moedas.put("Libra Esterlina", new BigDecimal("7.50"));
    }

    //Metodo que verifica tipo da moeda
    public void verificaTipoDeMoeda(String tipoDaMoeda){

        if (!moedas.containsKey(tipoDaMoeda)) throw new IllegalArgumentException
                ("Tipo de moeda invalida");
        this.tipo = tipoDaMoeda;
    }

    //Metodo que verifica se o valor é nulo, ou menor que zero
    public void verificaValorInserido(BigDecimal valor){

        if (valor == null) throw new NumberFormatException("" +
                "Para moeda o valor monetario deve ser um numero" +
                "decimal");

        if (valor.compareTo(BigDecimal.ZERO) == 0 ||
        valor.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("" +
                "valor inválido por favor tente novamente!");
    }

    //Metodo que realiza converção das moedas
    public BigDecimal realizaConversaoDasMoedas(BigDecimal valor){
        return moedas.get(tipo).multiply(valor);
    }

    //Getter do HashMap
    public HashMap<String, BigDecimal> getMoedas() {
        return moedas;
    }
}
