package revisions;
import java.io.*;

public class ParseAndCut {
	//Outputs the first c2 chars of each line of the input file
	public static void outputCutChars (File f, int c2) throws IOException {
		BufferedReader br = null;
		StringReader sr = null;
		
		try {
			br = new BufferedReader(new FileReader(f));
			String s = br.readLine();
			
			while (s != null) {
				sr = new StringReader(s);
				int c = sr.read();
				for (int i=0;i<c2; i++) {
					if (c != -1) {
						System.out.print((char)c);
						c=sr.read();
					}
					else break;
				}
				System.out.println();
				s = br.readLine();
			}
		} finally {
			if (br != null) br.close();
			if (sr != null) sr.close();
		}
	}
	
	//Outputs chars c1 to c2 of each line of the input file
	public static void outputCutChars2 (File f, int c1, int c2) throws IOException {
		BufferedReader br = null;
		StringReader sr = null;
		
		if (c1>c2) {
			int temp = c1;
			c1 = c2;
			c2 = temp;
		}
		
		try {
			br = new BufferedReader(new FileReader(f));
			String s = br.readLine();
			
			while (s != null) {
				sr = new StringReader(s);
				int c = sr.read();
				int nb=0;
				for (int i=0; i<c1; i++) {
					nb++;
					c = sr.read();
				}
				for (int i=c1;i<c2; i++) {
					if (c != -1) {
						System.out.print((char)c);
						c=sr.read();
					}
					else break;
				}
				System.out.println();
				s = br.readLine();
			}
		} finally {
			if (br != null) br.close();
			if (sr != null) sr.close();
		}
	}
		
	//Outputs chars c1 to c2 of each line of the input file the name of which is a string
	public static void outputCutChars2 (String file, int c1, int c2) throws IOException {
		File f1 = new File(file);
		outputCutChars2 (f1, c1, c2);
			
	}
	
	public static void main(String[] args) throws IOException {
		//FileReader f = new FileReader("123456.txt");
		File f1 = new File("123456.txt");
		outputCutChars(f1, 3);
		outputCutChars2("123456.txt",2,5);
		outputCutChars2 (f1, 1,2);
		outputCutChars2 (f1, 3,0);
	}
}
