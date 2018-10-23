package Lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		AList<Integer> testList = new AList<Integer>();
		LinkedList <String> linkedList = new LinkedList <String>();
		
		testList.add(5);
		testList.add(6);
		testList.printList();
		
		AList<Character> testListChar = new AList<Character>();
		LinkedList <Character> linkedListChar = new LinkedList <Character>();
		
		testListChar.add('f');
		testListChar.add('o');
		testListChar.add('x');
		testListChar.add(',');
		
		linkedListChar.add('\'');
		linkedListChar.add('f');
		linkedListChar.add('o');
		linkedListChar.add('x');
		linkedListChar.add(',');
		
		for(int i = 0; i < (testListChar.getLength()); i++) {
			System.out.print(testListChar.getEntry(i));
		}
		System.out.print('\n');
		
		System.out.println("testListChar has x: " + testListChar.contains('x'));
		
		testListChar.remove((Character) 'x');
		
		for(int i = 0; i < (testListChar.getLength()); i++) {
			System.out.print(testListChar.getEntry(i));
		}
		System.out.print('\n');
		
		System.out.println("testListChar has x: " + testListChar.contains('x'));
		
		for(int i = 0; i < (linkedListChar.getLength()); i++) {
			System.out.print(linkedListChar.getEntry(i));
		}
		System.out.print('\n');
		
		System.out.println("linkedListChar contains \': " + linkedListChar.contains('\''));
		System.out.println("linkedListChar has x: " + linkedListChar.contains('x'));
		
		linkedListChar.remove((Character)'x');
		
		for(int i = 0; i < (linkedListChar.getLength()); i++) {
			System.out.print(linkedListChar.getEntry(i));
		}
		System.out.print('\n');
		
		linkedListChar.remove((Character)'\'');
		for(int i = 0; i < (linkedListChar.getLength()); i++) {
			System.out.print(linkedListChar.getEntry(i));
		}
		System.out.print('\n');
		
		System.out.println("testListChar has x" + linkedListChar.contains('x'));
		
		File inFile = new File("C:\\Users\\hillg2\\Documents\\2018 Fall\\Data Structures\\Lab\\foxandcat.txt");
		
		Scanner sc = new Scanner(inFile);
		
		AList<String> arrayList = new AList<>();
		LinkedList<String>  linkList = new LinkedList<>();

		//Write Content
		//FileWriter writer = new FileWriter(file);
		//writer.write("Test data");
		  
		String st; 
		while (sc.hasNext()) {
			  st = sc.next();
			  String f="";
				
				for(int i=0;i<st.length();i++) {
					if(Character.isAlphabetic(st.charAt(i))){
						f+=st.charAt(i);
					}
				}
				
				if(!f.equals("")) {
					arrayList.add(f);
					linkList.add(f);
				}
			}
			
			
			int length = linkList.getLength();
			
			for(int i=0;i<length;i++) {
				System.out.println(linkList.getEntry(i)+" "+arrayList.getEntry(i));
			}
			
			System.out.println("\n");
			
			AList<String> removeWords = new AList<>();
			
			//remove all words starting with a
			for(int i=0;i<length;i++) {
				
				String entry = linkList.getEntry(i);
				
				if(entry.toLowerCase().charAt(0)=='a') {
					removeWords.add(entry);
				}
			}
			
			for(int i=0;i<removeWords.getLength();i++) {
				
				arrayList.remove(removeWords.getEntry(i));
				linkList.remove(removeWords.getEntry(i));
				
			}
			
			System.out.println("new length: \narraylist: " +arrayList.getLength() +" \nlinkedlist: "+linkList.getLength());
			
			length=linkList.getLength();
			
			//ouput indices for to and be
			System.out.println("\nindices of 'to':");
			for(int i=0;i<length;i++) {
				if(linkList.getEntry(i).toLowerCase().equals("to")) {
					System.out.print(i+" ");
				}
				if(arrayList.getEntry(i).toLowerCase().equals("to")) {
					System.out.print(i+" ");
				}
			}
			
			System.out.println("\nindices of 'be':");
			for(int i=0;i<length;i++) {
				if(linkList.getEntry(i).toLowerCase().equals("be")) {
					System.out.print(i+" ");
				}
				if(arrayList.getEntry(i).toLowerCase().equals("be")) {
					System.out.print(i+" ");
				}
			}
			
			
			//change all fox to elephant
			
			
			for(int i=0;i<length;i++) {
				
				if(linkList.getEntry(i).toLowerCase().equals("fox")) {
					linkList.remove(i);
					linkList.add(i, "elephant");
					arrayList.remove(i);
					arrayList.add(i, "elephant");
				}
				
			}
			
			
			
			//print modified lists to text file
			PrintWriter writer1 = new PrintWriter("test2.txt", "UTF-8");
			
			for(int i=0;i<length;i++) {
				writer1.println(linkList.getEntry(i)+" "+arrayList.getEntry(i));
			}
			writer1.close();
			
			//clear lists
			linkList.clear();
			arrayList.clear();
			
			System.out.println("\nList lengths after clear: "+linkList.getLength()+" "+arrayList.getLength());
		sc.close();
		
	}

}
