package ex01;
import java.util.Scanner;
public class Somar2 {
	public static int sum(int n1, int n2) {
		int total = 0;
		total = n1+n2;
		return total;
	}
	
	public static void show_sum(int total) {
		System.out.println("Soma = " + total);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("X =");
		int n1 = sc.nextInt();
		System.out.println("Y =");
		int n2 = sc.nextInt();
		int soma = sum(n1,n2);
		show_sum(soma);
		sc.close();
	}
}

