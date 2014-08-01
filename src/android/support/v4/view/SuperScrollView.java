package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class SuperScrollView extends ScrollView {

	public SuperScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SuperScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SuperScrollView(Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			b = false;
			touchY_DOWN = event.getRawY();
			break;
		case MotionEvent.ACTION_MOVE:
			if (!(b = (event.getRawY() > touchY_DOWN))) {
				touchY_DOWN = event.getRawY();
			}
			break;
		}
		return bo || b ? b : super.onTouchEvent(event);
	}

	private boolean b;
	private float touchY_DOWN;
	private boolean bo;
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		bo = t + getHeight() >= computeVerticalScrollRange();
	}

}
