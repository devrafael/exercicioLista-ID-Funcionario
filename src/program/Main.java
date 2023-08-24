package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Func;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int nFunc, idAumento, id, cont=0;
		String nome;
		double aumentoSalario, salario;
		
		
		System.out.println("Quantos funcionários serão cadastrados: ");
		nFunc = sc.nextInt();
		sc.nextLine();//LIMPAR BUFFER DE ENTRADA
		
		List <Func> listDados = new ArrayList<>();
				
		for (int i = 0; i < nFunc; i++) {
			
			System.out.printf("\n~~FUNCIONÁRIO #%s~~%n",(i+1));
			System.out.print("ID: ");
			id = sc.nextInt();	
			sc.nextLine();
			
				while(verificaRepeticao(listDados, id)) { //VERIFICA SE O ID JÁ FOI DIGITADO
				System.out.println("ID já digitada. Tente novamente!");
				id = sc.nextInt();
				sc.nextLine();
				}
				
			System.out.print("Nome: ");
			nome = sc.nextLine();
			System.out.print("Salário: ");
			salario = sc.nextDouble();
			
			Func funcionario = new Func(id, nome, salario);
			
			listDados.add(funcionario);
		
		}
		System.out.print("Digite o ID do funcionário que receberá o aumento: ");
		idAumento = sc.nextInt();
		sc.nextLine();
		
		//ETAPA 2: VERIFICA O ID E ADICIONA, QUANDO POSSÍVEL, O AUMENTO SALARIAL
		
		Func verificaID = listDados.stream().filter(x -> x.getId() == idAumento).findFirst().orElse(null);
		if (verificaID == null) {
			System.out.println("Este ID de funcionário não existe!\n");
		} else {
			System.out.print("Digite a porcentagem de aumento: ");
			aumentoSalario = sc.nextDouble();
			verificaID.aumentoSalario(aumentoSalario);
			
		}
		
		//ETAPA 3: IMPRESSÃO DOS DADOS 
		System.out.println("\n==LISTA DE FUNCIONÁRIOS==");
		
		for (Func func : listDados) {
			while(cont<nFunc) {
				cont++;
				System.out.println(cont+": " + func);
			}
			
		}
		sc.close();
	}
	
	public static Boolean verificaRepeticao(List<Func> listDados, int id) {
		Func verificaRepeticao = listDados.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return verificaRepeticao != null;
	}

}