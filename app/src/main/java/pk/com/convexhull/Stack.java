package pk.com.convexhull;

import java.util.ArrayList;

public class Stack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Dot> list = new ArrayList<Dot>();
		 list.add(new Dot(0 , 0));
		 System.out.println(list.size());
		 Pop(list);
		 System.out.println(list.size());
	}
	
	public static ArrayList<Dot> Pop(ArrayList<Dot> list){
		list.remove(list.size()-1);
		return list;
	}
	public static ArrayList<Dot> Push(ArrayList<Dot> list, Dot a){
		list.add(a);
		return list;
	}

}

