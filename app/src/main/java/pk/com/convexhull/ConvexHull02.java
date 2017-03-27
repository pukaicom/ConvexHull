package pk.com.convexhull;


import java.util.ArrayList;


public class ConvexHull02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	public static ArrayList<Dot> GetConvexHullDots(ArrayList<Dot> list){
		list = SortByAngel(list);
		list.add(list.get(0));
		ArrayList<Dot> result = new ArrayList<Dot>();
		Stack.Push(result, list.get(0));
		Stack.Push(result, list.get(1));
		for(int i=2; i<list.size(); i++){
			if(Dot.IsUp(result.get(result.size()-2), result.get(result.size()-1), list.get(i))){
				Stack.Push(result, list.get(i));
				for (int p = 0; p < result.size(); p++) {
					Dot o = result.get(p);
				}
			}else {
				if(result.size()==2){
					Stack.Push(result, list.get(i));
				}else{
					Stack.Pop(result);
					i--;
				}
				for (int p = 0; p < result.size(); p++) {
					Dot o = result.get(p);
				}

			}
		}
		
		return result;
	}

	public static ArrayList<Dot> SortByAngel(ArrayList<Dot> listDot) {

		ArrayList<Line> listLine = new ArrayList<Line>();

		listLine = DotToLine(listDot);
		listLine = Line.QuickSort(listLine, 0, listLine.size()-1);
		listLine = Line.DeleteSameTanLines(listLine);
		listDot = LineToDot(listLine);

		return listDot;
	}
	public static ArrayList<Line> DotToLine(ArrayList<Dot> listDot) {
		ArrayList<Line> listLine = new ArrayList<Line>();
		int minX = Dot.FindMinX(listDot);
		Dot minDot = listDot.get(minX);
		listDot.remove(minDot);
		
		
		for (int i = 0; i < listDot.size(); i++) {
			listLine.add(new Line(minDot, listDot.get(i)));
		}

		return listLine;
	}

	public static ArrayList<Dot> LineToDot(ArrayList<Line> listLine) {
		ArrayList<Dot> listDot = new ArrayList<Dot>();
		listDot.add(listLine.get(0).getA());
		for (int i = 0; i < listLine.size(); i++) {
			listDot.add(listLine.get(i).getB());
		}
		return listDot;
	}

}
