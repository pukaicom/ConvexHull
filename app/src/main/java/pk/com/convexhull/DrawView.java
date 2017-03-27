package pk.com.convexhull;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

class DrawView extends View{

	
	ArrayList<Dot> list = new ArrayList<Dot>();
	ArrayList<Dot> listResult = new ArrayList<Dot>();
	int n;

	public void setN(int n) {
		this.n = n;
	}

	public ArrayList<Dot> GetList() {
		
		return this.list;
	}

	public void setList(ArrayList<Dot> list) {
		ArrayList<Dot> list1 = new ArrayList<Dot>();
		for(int i=0; i<list.size(); i++){
			list1.add(list.get(i));
		}
		this.list = list1;
	}

	public void setlistResult(ArrayList<Dot> listResult) {
		
		this.listResult = listResult;
	}
	public DrawView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	protected void onDraw(Canvas canvas){
		Paint p = new Paint();
		p.setColor(Color.BLACK);
		if (list.size()!=0) {
			for (int i = 0; i < list.size(); i++) {
				int x = list.get(i).getX() + 30;
				int y = list.get(i).getY() + 30;
				float radius = 5;
				canvas.drawCircle( x, y,radius, p);// СԲ 
			}
		}

		p.setColor(Color.RED);
		p.setStrokeWidth(5.0f);
		canvas.drawLine(20,20,20,  20, p);// ����  
		if (listResult.size() != 0) {
			listResult.add(listResult.get(0));
			for (int i = 1; i < listResult.size(); i++) {
				canvas.drawLine(listResult.get(i - 1).getX() + 30,
						listResult.get(i - 1).getY() + 30, listResult.get(i)
						.getX() + 30, listResult.get(i).getY() + 30, p);// ����  
			}
		}
	}
	
}