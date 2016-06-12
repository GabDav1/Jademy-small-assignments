import java.util.Scanner;

//Small program coded at the beggining of Jademy Code School, it prints out a "Christmas tree" in the console that takes 
//height and width input from the keyboard.

public class PrintTree {

	public static void main(String[] args) {

		String[][] matrice = new String[citesteTst("numarul de linii")][citesteTst("numarul de coloane")];
		String a = " ";
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {

				if (j == matrice[i].length / 2) {
					matrice[i][j] = "*";

				} else
					matrice[i][j] = " ";
			}

			for (int j = 0; j < matrice.length; j++) {
				if (matrice[i][j] == "*" && i <= matrice.length / 2) {

					matrice[i][j - i] = "*";
					matrice[i][j + i] = "*";
					for (int u = j - i; u < j + i; u++) {
						matrice[i][u] = "*";
					}
					break;
				}

			}
			if (i == matrice.length / 2) {
				for (int j = 0; j < matrice.length; j++) {
					matrice[i][j] = "*";
				}
			}
		}

		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println("");
		}

	}

	public static int citesteTst(String s) {
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		int nr = sc.nextInt();
		return nr;
	}
}
