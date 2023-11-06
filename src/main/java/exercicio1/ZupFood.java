package exercicio1;

import java.util.Scanner;

public class ZupFood {

    //Atributos
    private Menu menu;
    private Scanner entrada;
    private Alimento alimento;
    private String nomeUsuario;
    private boolean continuar;

    public ZupFood(){
        menu = new Menu();
        entrada = new Scanner(System.in);
    }

    public void setContinuar(){
        this.continuar = true;
    }

    //método de compra
    public void comprar(){

        System.out.println("Qual é o seu nome? ");
        nomeUsuario = entrada.nextLine();
        System.out.println("Bem vinde ao nosso ZupFood " + nomeUsuario);

        String tipo = "";
        String nome = "";

        while (true){

            alimento = new Alimento();
            setContinuar();

            do {
                addTipoDeAlimento();
            }while (continuar);
            setContinuar();

            do {
                addNomeDoAlimento();
            }while (continuar);
            setContinuar();

            do {
                if (alimento.getTipoAlimento().equalsIgnoreCase("verdura") ||
                        alimento.getTipoAlimento().equalsIgnoreCase("grãos")){
                    addGramasDoAlimento();
                }else if (alimento.getTipoAlimento().equalsIgnoreCase("legumes") ||
                        alimento.getTipoAlimento().equalsIgnoreCase("outros")){
                    addUnidadeDoAlimento();
                }
            }while (continuar);
            menu.adicionar(alimento);
            System.out.println("Você deseja adicionar mais algum item? 1-sim 2-não");
            if (entrada.nextInt() == 2) break;

        }
        menu.mostrarCarrinho();

    }
    //método que adiciona um alimento na compra
    public void addTipoDeAlimento(){
        try{
            System.out.println("Qual é o tipo de alimento que deseja adicionar? ");
            menu.getOpcoesTipoAlimento();
            alimento.setTipoAlimento(menu.verificarTipoAlimento(entrada.nextLine()));
            continuar = false;
        }catch (IllegalArgumentException e){
            System.out.println(e.getCause());
        }
    }

    //método que adiciona o nome de um alimento na compra
    public void addNomeDoAlimento(){
        try{
            System.out.println("Qual é o nome do alimento? ");
            alimento.setNomeDoAlimento(entrada.nextLine());
            menu.verificaNome(alimento.getNomeDoAlimento());
            continuar = false;
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }

    //método que adiciona as gramas de um alimento(Verdura ou  Grãos)
    public void addGramasDoAlimento(){
        try{
            System.out.println("Quantas gramas de " + alimento.getNomeDoAlimento() + " deseja adicionar?");
            String valorGrama = entrada.next();
            alimento.setQuantidaDouble(menu.verificarGramas(valorGrama));
            continuar = false;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    //método que adiciona as unidades de um alimento(Legumes e Outros)
    public void addUnidadeDoAlimento(){
        try{
            System.out.println("Qual a quantidade de " + alimento.getNomeDoAlimento() + " deseja adicionar?");
            String valorUnidade = entrada.next();
            alimento.setQuantidadeInteiro(menu.verificarUnidades(valorUnidade));
            continuar = false;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
