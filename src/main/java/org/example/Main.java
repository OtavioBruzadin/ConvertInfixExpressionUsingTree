package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            int section = 0;
            String infixExpression = "";
            ExpressionTree tree;
            tree = new ExpressionTree();
            Scanner scanner = new Scanner(System.in);

            boolean used2option = false;


            while (section != 5) {
                System.out.println("Qual seção deseja acessar?: ");
                section = scanner.nextInt();
                scanner.nextLine();

                if (section == 1) {
                    try {
                        System.out.println("Qual o valor da expressao infixa ?: ");
                        String infixExpressionInput = scanner.nextLine().replaceAll("[\\s\\t]+", "");;
                        infixExpression = infixExpressionInput;

                    }catch (Exception Exception){
                        System.out.println("Epa, parece que a expressao inserida é invalida, tente novamente");
                    }
                }
//                String expression = "0.5*3/0.25";
                if (section == 2) {
                    try {
                        tree.createExpressionTree(infixExpression);
                        System.out.println("Arvore de expressão gerada com sucesso");
                        used2option = true;
                    }catch (Exception Exception){
                        System.out.println("Epa, insira uma expressao valida antes utilizando a opcao 1");
                    }
                }
                if (section == 3) {
                    if(used2option == true) {
                        tree.printInOrder();
                        tree.printPostOrder();
                        tree.printPreOrder();
                    }else{
                        System.out.println("Epa,utilize primeiro a opção 2");
                    }
                }
                if (section == 4) {
                    if(used2option == true) {
                        tree.evaluate();
                    }else{
                        System.out.println("Epa,utilize primeiro a opção 2");
                    }
                }
            }
        }catch (Exception exception){
            System.out.println("Epa algo deu errado ;-; tente novamente!");
        }
        System.out.println("Obrigado por utilizar nosso Software UwU");
    }
}