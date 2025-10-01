/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula2;

import java.util.Scanner;


public class ExerciciosJava {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                
        System.out.println("*---- Cálculo da Média ----*");
        System.out.println("Nome do aluno:");
        String name = input.next();
        
        System.out.println("Digite a nota 1:");
        float n1 = input.nextFloat();
        System.out.println("Digite a nota 2:");
        float n2 = input.nextFloat();
        System.out.println("Digite a nota 3:");
        float n3 = input.nextFloat();
        System.out.println("Faltas: ");
        byte faltas = input.nextByte();
        float media = (n1 + n2 + n3) / 3;
        
        System.out.println("Média: " + media);
        
        if (faltas > 18) {
            System.out.println("Reprovado por falta");
        } else if (media < 6) {
            System.out.println("Nota de recuperação:");
            float nRecuperacao = input.nextFloat();
            media = (media + nRecuperacao) / 2;
            System.out.println("Media recuperação: " + media);
                       
            if (media >= 6) {
                System.out.println("Aprovado por recuperação");
            } else {
                System.out.println("Reprovado");
            }
        } else {
            System.out.println("Aprovado!");
        }
    }
}
