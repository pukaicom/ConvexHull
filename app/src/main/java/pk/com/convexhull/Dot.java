package pk.com.convexhull;


import java.util.ArrayList;

public class Dot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dot d0 = new Dot(44, 409);
		Dot d1 = new Dot(297, 93);
		Dot d2 = new Dot(333, 270);
		Dot d3 = new Dot(541, 339);
		Dot d4 = new Dot(1, 1);
		Dot d5 = new Dot(0, 0);
		
		
		System.out.println(IsInside(d0, d1, d2, d3));
		System.out.println(IsInside(d0, d2, d1, d3));
		System.out.println(IsInside(d1, d0, d2, d3));
		System.out.println(IsInside(d1, d2, d0, d3));
		System.out.println(IsInside(d2, d0, d1, d3));
		System.out.println(IsInside(d2, d1, d0, d3));
		System.out.println(IsInside(d3, d2, d0, d1));
		System.out.println(Inside(d2, d3, d1, d0));
	}

	private int x;
	private int y;
	private boolean flag;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public Dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.flag = false;
	}
	
	/***************************************************************
	 * 
	 * d2d0�������Ƿ���d1d0��������ʱ���Ϸ������Ϸ��򷵻�true
	 * 
	 ***************************************************************/
	public static boolean IsUp(Dot d0, Dot d1, Dot d2) {
		int x0 = d0.getX();
		int y0 = d0.getY();
		int x1 = d1.getX();
		int y1 = d1.getY();
		int x2 = d2.getX();
		int y2 = d2.getY();
		boolean isUp;
		if ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0) {
			isUp = true;
		} else {
			isUp = false;
		}
		return isUp;
	}
	
	/***************************************************************
	 * 
	 * ������n���㡣
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> GenerateDots(int n) {
		ArrayList<Dot> list = new ArrayList<Dot>();
		for (int i = 0; i < n; i++) {
			Dot a = new Dot((int) (Math.random() * 1040),
					(int) (Math.random() * 1350));
			list.add(a);
		}

		return list;
	}
	/***************************************************************
	 * 
	 * �Ƿ�Ϊͬһ���㡣
	 * 
	 ***************************************************************/
	
	public static boolean IsSameDot(Dot a, Dot b){
		if(a.getX()==b.getX()&&a.getY()==b.getY()){
			return true;
		}else{
			return false;
		}
	}

	/***************************************************************
	 * 
	 * d1d0��d2d0�Ƿ��ߣ������򷵻�true
	 * 
	 ***************************************************************/
	public static boolean IsColineation(Dot d0, Dot d1, Dot d2) {
		int x0 = d0.getX();
		int y0 = d0.getY();
		int x1 = d1.getX();
		int y1 = d1.getY();
		int x2 = d2.getX();
		int y2 = d2.getY();
		boolean isColineation;
		if ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0) {

			isColineation = true;// б�߹���

		} else {

			isColineation = false;// б�߲�����

		}
		return isColineation;
	}
	/***************************************************************
	 * 
	 * ���������е㡣
	 * 
	 ***************************************************************/
	public static int GetMiddleDot(Dot d1, Dot d2, Dot d3) {
		int i = 0;
		if (((d2.getX() - d1.getX()) == 0) && ((d3.getX() - d1.getX()) == 0)) {
			if ((d1.getY() < d2.getY() && d1.getY() > d3.getY())
					|| (d1.getY() > d2.getY() && d1.getY() < d3.getY())) {
				i = 1;
			} else if ((d2.getY() < d1.getY() && d2.getY() > d3.getY())
					|| (d2.getY() > d1.getY() && d2.getY() < d3.getY())) {
				i = 2;
			} else if ((d3.getY() < d2.getY() && d3.getY() > d1.getY())
					|| (d3.getY() > d2.getY() && d3.getY() < d1.getY())) {
				i = 3;
			}
		} else {
			if ((d1.getX() < d2.getX() && d1.getX() > d3.getX())
					|| (d1.getX() > d2.getX() && d1.getX() < d3.getX())) {
				i = 1;
			} else if ((d2.getX() < d1.getX() && d2.getX() > d3.getX())
					|| (d2.getX() > d1.getX() && d2.getX() < d3.getX())) {
				i = 2;
			} else if ((d3.getX() < d2.getX() && d3.getX() > d1.getX())
					|| (d3.getX() > d2.getX() && d3.getX() < d1.getX())) {
				i = 3;
			}
		}
		return i;
	}
	
	/***************************************************************
	 * 
	 * �ж��ĸ����Ƿ���һ��������������㹹�ɵ������֮�ڣ�����У�����true��û�з���false��
	 * 
	 ***************************************************************/
	public static boolean IsInside(Dot d1, Dot d2, Dot d3, Dot d4) {
		boolean inside = false;

		if (IsUp(d1, d2, d4) && IsUp(d2, d3, d4) && IsUp(d3, d1, d4)) {
			inside = true;// ���d4����d1��d2��d3��ɵ������ߵ���ʱ���Ϸ�����d4���������
		} else if (!IsUp(d1, d2, d4) && !IsUp(d2, d3, d4) && !IsUp(d3, d1, d4)) {
			inside = true;
		}
		

		return inside;
	}
	
	/***************************************************************
	 * 
	 * �ж��ĸ����Ƿ���һ��������������㹹�ɵ������֮�ڣ����û�У�����0��������򷵻���Ӧ����š�
	 * 
	 ***************************************************************/
	public static int Inside(Dot d1, Dot d2, Dot d3, Dot d4) {
		int i = 0;

		if (IsInside(d1, d2, d3, d4)) {
			i = 4;
		} else if (IsInside(d1, d2, d4, d3)) {
			i = 3;
		} else if (IsInside(d1, d4, d3, d2)) {
			i = 2;
		} else if (IsInside(d4, d2, d3, d1)) {
			i = 1;
		}

		return i;
	}
	
	
	/***************************************************************
	 * 
	 * ��͹����������
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> OrderFinalDots(ArrayList<Dot> list) {
		ArrayList<Dot> listUp = new ArrayList<Dot>();
		ArrayList<Dot> listDown = new ArrayList<Dot>();

		int maxX = FindMaxX(list);
		int minX = FindMinX(list);
		
		Dot maxDot = list.get(maxX);
		Dot minDot = list.get(minX);
		list.remove(minDot);
		list.remove(minDot);
		for (int i = 0; i < list.size(); i++) {
			if (IsUp(minDot, maxDot, list.get(i))) {
				listUp.add(list.get(i));
			} else {
				listDown.add(list.get(i));
			}

		}
		listUp = QuickSort(listUp, 0, listUp.size() - 1);
		listUp = SortY(listUp);
		listUp = InvertOrder(listUp);
		
		for (int i = 0; i < listUp.size(); i++) {
			Dot a = listUp.get(i);
		}
		listDown = QuickSort(listDown, 0, listDown.size() - 1);
		listDown = SortY(listDown);
		for (int i = 0; i < listDown.size(); i++) {
			Dot a = listDown.get(i);

		}

		list.clear();

		list.add(minDot);
		for (int i = 0; i < listDown.size(); i++) {
			list.add(listDown.get(i));
		}
		list.add(maxDot);
		for (int i = 0; i < listUp.size(); i++) {
			list.add(listUp.get(i));
		}
		return list;
	}
	public static int FindMaxX(ArrayList<Dot> list) {
		int max = list.get(0).getX();
		int maxDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getX() > max) {
				max = list.get(i).getX();
				maxDot = i;
			}
		}
		return maxDot;
	}


	public static int FindMinX(ArrayList<Dot> list) {
		int min = list.get(0).getX();
		int minDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getX() < min) {
				min = list.get(i).getX();
				minDot = i;
			}
		}
		return minDot;
	}

	public static int FindMaxY(ArrayList<Dot> list) {
		int max = list.get(0).getY();
		int maxDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getY() > max) {
				max = list.get(i).getY();
				maxDot = i;
			}
		}
		return maxDot;
	}

	public static ArrayList<Dot> GetYLeft(ArrayList<Dot> list) {
		ArrayList<Dot> listUp = new ArrayList<Dot>();
		ArrayList<Dot> listDown = new ArrayList<Dot>();

		int maxY = FindMaxY(list);
		int minY = FindMinY(list);
		
		Dot maxDot = list.get(maxY);
		Dot minDot = list.get(minY);
		list.remove(minDot);
		list.remove(minDot);
		for (int i = 0; i < list.size(); i++) {
			if (IsUp(minDot, maxDot, list.get(i))) {
				listUp.add(list.get(i));
			} else {
				listDown.add(list.get(i));
			}

		}
		listUp = QuickSort(listUp, 0, listUp.size() - 1);
		listUp = SortX(listUp);
		listUp = InvertOrder(listUp);
		

		list.clear();

		return listUp;
	}

	public static ArrayList<Dot> GetYRight(ArrayList<Dot> list) {
		ArrayList<Dot> listUp = new ArrayList<Dot>();
		ArrayList<Dot> listDown = new ArrayList<Dot>();

		int maxY = FindMaxY(list);
		int minY = FindMinY(list);
		
		Dot maxDot = list.get(maxY);
		Dot minDot = list.get(minY);
		list.remove(minDot);
		list.remove(minDot);
		for (int i = 0; i < list.size(); i++) {
			if (IsUp(minDot, maxDot, list.get(i))) {
				listUp.add(list.get(i));
			} else {
				listDown.add(list.get(i));
			}

		}
		
		
		listDown = QuickSort(listDown, 0, listDown.size() - 1);
		listDown = SortX(listDown);

		list.clear();

		list.add(minDot);
		for (int i = 0; i < listDown.size(); i++) {
			list.add(listDown.get(i));
		}
		list.add(maxDot);
//		for (int i = 0; i < listUp.size(); i++) {
//			list.add(listUp.get(i));
//		}
		return listDown;
	}

	public static int FindMinY(ArrayList<Dot> list) {
		int min = list.get(0).getY();
		int minDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getY() < min) {
				min = list.get(i).getY();
				minDot = i;
			}
		}
		return minDot;
	}
	
	/***************************************************************
	 * 
	 * ��list�еĳ�Ա����Y�����Ĵ�С����Ŀ�������
	 * 
	 ***************************************************************/

	public static ArrayList<Dot> QuickSortY(ArrayList<Dot> list, int start,
			int end) {
		int i, j;
		i = start;
		j = end;
		if ((list == null) || (list.size() == 0))
			return list;
		while (i < j) {
			while (i < j && list.get(i).getY() <= list.get(j).getY()) {
				j--;
			}
			if (i < j) {
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			while (i < j && list.get(i).getY() < list.get(j).getY()) {
				i++;
			}
			if (i < j) {
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		if (i - start > 1) {
			QuickSort(list, start, i - 1);
		}
		if (end - j > 1) {
			QuickSort(list, j + 1, end);
		}
		return list;
	}
	
	
	
	/***************************************************************
	 * 
	 * ��list�еĳ�Ա����x�����Ĵ�С����Ŀ�������
	 * 
	 ***************************************************************/

	public static ArrayList<Dot> QuickSort(ArrayList<Dot> list, int start,
			int end) {
		int i, j;
		i = start;
		j = end;
		if ((list == null) || (list.size() == 0))
			return list;
		while (i < j) {
			while (i < j && list.get(i).getX() <= list.get(j).getX()) { // ������start�±�����Ϊkey���Ҳ�ɨ��
				j--;
			}
			if (i < j) { // �Ҳ�ɨ�裬�ҳ���һ����keyС�ģ�����λ��
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			while (i < j && list.get(i).getX() < list.get(j).getX()) { // ���ɨ�裨��ʱa[j]�д洢��keyֵ��
				i++;
			}
			if (i < j) { // �ҳ���һ����key��ģ�����λ��
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		if (i - start > 1) {
			// �ݹ���ã���keyǰ����������
			QuickSort(list, start, i - 1);
		}
		if (end - j > 1) {
			QuickSort(list, j + 1, end); // �ݹ���ã���key������������
		}
		return list;
	}

	/***************************************************************
	 * 
	 * �Կ��ź�list��y��������
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> SortY(ArrayList<Dot> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getX() == list.get(i + 1).getX()) {
				if (list.get(i).getY() > list.get(i + 1).getY()) {
					Dot temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}
			}
		}
		return list;

	}

	public static ArrayList<Dot> SortX(ArrayList<Dot> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getY() == list.get(i + 1).getY()) {
				if (list.get(i).getX() > list.get(i + 1).getX()) {
					Dot temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}
			}
		}
		return list;

	}


	public static ArrayList<Dot> InvertOrder(ArrayList<Dot> list) {
		ArrayList<Dot> list1 = new ArrayList<Dot>();
		for (int i = list.size() - 1; i >= 0; i--) {
			list1.add(list.get(i));
		}
		return list1;
	}
	
}

