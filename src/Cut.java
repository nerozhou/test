import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Cut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new FileReader(new File(args[0]))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(args[1]))));
		int count = 0;
		
		while (in.hasNextLine()) {
			count++;
			
			if (count >= 132) {
				out.println(in.nextLine());
			} else {
				in.nextLine();
			}
		}
		
		in.close();
		out.close();
		System.out.println("done!");
	}

}
