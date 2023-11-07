package exercicio2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class CasaDeCambio {
    private Conversao conversao = new Conversao();
    private Scanner entrada;

    public CasaDeCambio() {
        entrada = new Scanner(System.in);
    }

    //metodo que vai interagir com usuario
    public void trocaDeMoeda() {
        do {
            String tipoMoeda = "";
            BigDecimal valor = new BigDecimal(0);

            boolean continuar = true;

            do {
                try {

                    System.out.println("Boas vindas ao conversor de moedas!");
                    System.out.println("Digite tipo de moeda que deseja converter: ");
                    tipoMoeda = entrada.nextLine();
                    conversao.verificaTipoDeMoeda(tipoMoeda);
                    continuar = false;
                    System.out.println("No momento só convertemos em real R$");

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (continuar);

            continuar = true;

            do {

                try {
                    System.out.println("Digite o valor que deseja converter: ");
                    valor = BigDecimal.valueOf(entrada.nextDouble());
                    conversao.verificaValorInserido(valor);
                    continuar = false;

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } while (continuar);
            exibirConversao(tipoMoeda, valor);


        } while (desejaFazerOutraConversao());

    }

    public boolean desejaFazerOutraConversao() {
        System.out.println("Deseja fazer outra conversão? (S/N)");
        String resposta = entrada.next();

        if (resposta.equalsIgnoreCase("S")) {
            entrada.nextLine(); // Limpa o buffer do Scanner
            return true;
        } else {
            return false;
        }
    }


    //metodo exibe o resultado da conversão
    public void exibirConversao(String moeda, BigDecimal valor) {
        System.out.println("A(O) " + moeda + " na cotação atual de hoje " + LocalDate.now() +
                " está em " + conversao.getMoedas().get(moeda) + " o valor que pediu para " +
                "convertero de " + valor + " em reais é ");
        System.out.printf("R$ %.2f\n", conversao.realizaConversaoDasMoedas(valor));
    }


}

