package pk.com.convexhull;


import java.util.ArrayList;

public class ConvexHull03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<Dot> GetConvexHullDots(ArrayList<Dot> list){
		ArrayList<Dot> listLeft = new ArrayList<Dot>();
		ArrayList<Dot> listRight = new ArrayList<Dot>();
		
		Dot max = list.get(Dot.FindMaxX(list));
		Dot min = list.get(Dot.FindMinX(list));
		int x = (max.getX() - min.getX())/2;

		for(int i=0; i<list.size(); i++){
			if(list.get(i).getX()<=x){
				listLeft.add(list.get(i));
			}else{
				listRight.add(list.get(i));
			}
		}
		if(listLeft.size()>3){
			listLeft = GetConvexHullDots(listLeft);
		
			listRight = GetConvexHullDots(listRight);
		}
		list = listLeft;
		for(int i=0; i<listRight.size(); i++){
			list.add(listRight.get(i));
		}
		
		list = ConvexHull02.GetConvexHullDots(list);
		return list;
	}

}

