package f22labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordBreak {
	public static ArrayList<Words> word_list=new ArrayList<Words>();
	public static ArrayList<Words> word_final=new ArrayList<Words>();
	
	public void wordBreak(String str, Set<String> dict) {
		String temp1=new String();
		if(dict.contains(str))
		{
			word_list.add(new Words(str,0,0));
			temp1+=word_list.get(word_list.size()-1).word;
			return;
		}
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				
				String pre = str.substring(i, j);
	            if(dict.contains(pre)) {
	            	word_list.add(new Words(pre,i,j));
	            }
			}
		}
		
		for(int i=0;i<word_list.size();i++) {
			for(int j=i+1;j<word_list.size();j++) {
				if(word_list.get(i).j==word_list.get(j).i)
				{
					temp1+=word_list.get(i).word+" ";
					i=j;
				}
			}
		}
		temp1+=word_list.get(word_list.size()-1).word;
		System.out.println(temp1);
	}
    public static void main(String[] args) throws FileNotFoundException {
        HashSet<String> h = new HashSet();

        //Read the Dictonary
        Scanner read = new Scanner (new File("src\\db.txt"));
        read.useDelimiter(",");
        int i=0; 
        String word;
//        Store the Words in Hashtable
        while(read.hasNext())
        {
        	++i;
        	word=read.next();
        	h.add(word);
        }
        read.close();
         
        WordBreak wb = new WordBreak();
        String str;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the Input String");
        str=in.nextLine();
        wb.wordBreak(str,h);
    }
}
