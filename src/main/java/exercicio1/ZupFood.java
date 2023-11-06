package exercicio1;

import java.util.Scanner;

public class ZupFood {
    private Menu menu;
    private Scanner sc;
    private Alimento alimento;
    private String nomeUsuario;
    private boolean continuar;

    public ZupFood(){
        menu = new Menu();
        sc = new Scanner(System.in);
    }

    public void setContinuar(){
        this.continuar = true;
    }

    //Metodo de compra
    public void compar(){

        System.out.println("Qual é o seu nome? ");
        nomeUsuario = sc.nextLine();
        System.out.println("Bem vindo(a) a ZupFood " + nomeUsuario);


        while (true){
            alimento = new Alimento();
            setContinuar();

            do {
               adicionaTipoAlimento();
            }while (continuar);
            setContinuar();

            do {
                adicionaNomeAlimento();
            }while (continuar);
            setContinuar();

            do {
                if (alimento.getTipoAlimento().equalsIgnoreCase("verdura") ||
                alimento.getTipoAlimento().equalsIgnoreCase("grãos")){
                    adicionaGramasAlimento();
                } else if (alimento.getTipoAlimento().equalsIgnoreCase("legumes") ||
                        alimento.getTipoAlimento().equalsIgnoreCase("outros")) {
                    adicionaUnidadesAlimento();
                }
            }while (continuar);
            menu.adicionar(alimento);
            System.out.println("Deseja adicionar mais algum item ? 1 - sim 2 - não");
            if (sc.nextInt() == 2) break;

        }
        menu.mostrarCarrinho();

    }

    //metodo adiciona alimento
    public void adicionaTipoAlimento(){
        try {
            System.out.println("Qual é o tipo de alimento deseja adicionar? ");
            menu.getOpcoesTipoAlimento();
            alimento.setTipoAlimento(menu.verificarTipoAlimento(sc.nextLine()));
            continuar = false;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    //metodo que adiciona o nome do alimento
    public void adicionaNomeAlimento(){
        try {
            System.out.println("Qual é o nome do Alimento: ");
            alimento.setNomeAlimento(sc.nextLine());
            menu.vericaNome(alimento.getNomeAlimento());
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }

    //Adiciona as gramas de uma alimento (verduras ou grãos)
    public void adicionaGramasAlimento(){
        try {
            System.out.println("Quantas gramas de " + alimento.getNomeAlimento() +
                    "deseja adicionar ?");
            String valorGrama = sc.next();
            alimento.setQuantidadeDouble(menu.verificarGramas(valorGrama));
            continuar = false;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    //Adiciona as unidades de um alimento (legumes e outros)
    public void adicionaUnidadesAlimento(){
        try {
            System.out.println("Qual a quantidade e " + alimento.getNomeAlimento() +
                    "dejeja adicionar? ");
            String valorUnidade = sc.next();
            alimento.setQuantidadeInteiro(menu.verificarUnidades(valorUnidade));
            continuar = false;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
