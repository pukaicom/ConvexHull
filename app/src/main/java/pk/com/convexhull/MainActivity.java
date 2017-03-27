package pk.com.convexhull;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private Button creatDotsButton;
    private Button enumAllButton;
    private Button grahamScanButton;
    private Button devidedButton;

    private EditText dotsNum;
    private TextView runningTime;
    private LinearLayout draw;
    private int n = 0;
    // private final DrawView drawView =new DrawView(this);

    ArrayList<Dot> listIn = new ArrayList<Dot>();
    ArrayList<Dot> listResult = new ArrayList<Dot>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creatDotsButton = (Button) findViewById(R.id.creatDots);
        enumAllButton = (Button) findViewById(R.id.enumAll);
        grahamScanButton = (Button) findViewById(R.id.grahamScan);
        devidedButton = (Button) findViewById(R.id.Devided);
        dotsNum = (EditText) findViewById(R.id.dotsNum);
        runningTime = (TextView) findViewById(R.id.runningTime);
        draw = (LinearLayout) findViewById(R.id.draw);

        // drawView.setMinimumHeight(500);
        // drawView.setMinimumWidth(300);
        // drawView.invalidate();
        // draw.addView(drawView);

        ButtonOnClickListener listener = new ButtonOnClickListener();
        creatDotsButton.setOnClickListener(listener);
        enumAllButton.setOnClickListener(listener);
        grahamScanButton.setOnClickListener(listener);
        devidedButton.setOnClickListener(listener);
        // init();
    }

    private void Generatedots() {
        listResult.clear();
        final DrawView view = new DrawView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);
        n = Integer.parseInt(dotsNum.getText().toString());
        listIn = Dot.GenerateDots(n);
        view.setList(listIn);
        view.setlistResult(listResult);
        view.invalidate();

        draw.removeAllViews();
        draw.addView(view);
    }

    private void GetByEnum() {
        final DrawView view = new DrawView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);

        long startTime = System.currentTimeMillis();
        listResult = ConvexHull01.GetConvexHullDots(listIn);
        long endTime = System.currentTimeMillis();
        String runingTime = Long.toString(endTime - startTime);

        runningTime.setText(runingTime);
        view.setList(listIn);
        view.setlistResult(listResult);
        view.invalidate();
        draw.removeAllViews();
        draw.addView(view);
    }

    private void GetByGraham() {
        final DrawView view = new DrawView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);

        ArrayList<Dot> list = new ArrayList<Dot>();
        for (int i = 0; i < listIn.size(); i++) {
            list.add(listIn.get(i));
        }
        long startTime = System.currentTimeMillis();
        listResult = ConvexHull02.GetConvexHullDots(list);
        long endTime = System.currentTimeMillis();
        String runingTime = Long.toString(endTime - startTime);

        runningTime.setText(runingTime);
        view.setList(listIn);
        view.setlistResult(listResult);
        view.invalidate();
        draw.removeAllViews();
        draw.addView(view);
    }

    private void GetByDevided() {
        final DrawView view = new DrawView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);

        long startTime = System.currentTimeMillis();
        listResult = ConvexHull03.GetConvexHullDots(listIn);
        long endTime = System.currentTimeMillis();
        String runingTime = Long.toString(endTime - startTime);

        runningTime.setText(runingTime);
        view.setList(listIn);
        view.setlistResult(listResult);
        view.invalidate();
        draw.removeAllViews();
        draw.addView(view);
    }

    class ButtonOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.creatDots){
                Generatedots();
            }else {
                if (listIn == null || listIn.isEmpty()) {
                    return;
                }
                switch (v.getId()) {
                    case R.id.enumAll:
                        GetByEnum();
                        break;
                    case R.id.grahamScan:
                        GetByGraham();
                        break;
                    case R.id.Devided:
                        GetByDevided();
                        break;
                }
            }
        }

    }

    // /************************************************
    // * ª≠Õºµƒ¿‡
    // **************************************************/
    //
    // class DrawView extends View{
    //
    // public DrawView(Context context) {
    // super(context);
    // // TODO Auto-generated constructor stub
    // }
    // protected void onDraw(Canvas canvas){
    // Paint p = new Paint();
    // if (listIn.size()!=0) {
    // for (int i = 0; i < listIn.size(); i++) {
    // int x = listIn.get(i).getX() + 20;
    // int y = listIn.get(i).getY() + 20;
    // float radius = 2;
    // canvas.drawCircle(radius, x, y, p);// –°‘≤
    // }
    // }
    //
    //
    // if (listResult.size() != 0) {
    // listResult.add(listResult.get(0));
    // for (int i = 1; i < listResult.size(); i++) {
    // canvas.drawLine(listResult.get(i - 1).getX() + 20,
    // listResult.get(i - 1).getY() + 20, listResult.get(i)
    // .getX() + 20, listResult.get(i).getY() + 20, p);// ª≠œﬂ
    // }
    // }
    // }
    //
    // }

}
