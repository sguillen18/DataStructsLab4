package Lab4;
import java.io.* ;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception{
		
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
		
		File file = new File("c://temp//lab4ListOfWords.txt");
		  
		//Create the file
		if (file.createNewFile())
		{
		    System.out.println("File is created!");
		} else {
		    System.out.println("File already exists.");
		}
		 
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write("Test data");
		  
		String st; 
		while (sc.hasNext()) {
			  st = sc.next();
			  if(st.contains(".") || st.contains("?") || st.contains("\'") || st.contains(",") || st.contains(":") || st.contains(";") || st.contains("!") || st.contains("\"")) {
				  LinkedList <Character>  stList = new LinkedList <Character>();
				  char[] stArray = st.toCharArray();
				  
				  for(int i = 0; st.length() > i; i++) { 
					  stList.add(stArray[i]);
				  }
				  
				  if(stList.contains('.')) {stList.remove((Character)'.');}
				  if(stList.contains('?')) {stList.remove((Character)'?');}
				  if(stList.contains('\'')) {stList.remove((Character)'\'');}
				  if(stList.contains(',')) {stList.remove((Character)',');}
				  if(stList.contains(':')) {stList.remove((Character)':');}
				  if(stList.contains(';')) {stList.remove((Character)';');}
				  if(stList.contains('!')) {stList.remove((Character)'!');}
				  if(stList.contains('\"')) {stList.remove((Character)'\"');}
				  if(stList.contains('\'')) {stList.remove((Character)'\'');}
				  
				  String noApost = "";
				  for(int i = 0; (stList.getLength() - 1) > i; i++) { 
					  noApost += stList.getEntry(i);
				  }
				  
				  st = noApost;
			  }
			  linkedList.add(st);
			  writer.write(st);
			  System.out.println(st);
			  
		}
		writer.close();
		sc.close();
		
	}

}
