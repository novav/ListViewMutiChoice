package com.example.testandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class ActivityDialog extends Activity implements OnClickListener{
	private Button mCancelButton;
	private Button mOkButton;
	private TextView mContentTextView;
	public static final int sDIALOG_OK = 0x20;
	public static final int sDIALOG_CANCEL = 0x20+1;
	private Intent mIntent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rlk_activity_dialog);
		mCancelButton = (Button) this.findViewById(R.id.dialog_cancel);
		mOkButton = (Button) this.findViewById(R.id.dialog_ok);
		mContentTextView = (TextView) this.findViewById(R.id.dialog_content);
		
		mOkButton.setOnClickListener(this);
		mCancelButton.setOnClickListener(this);
		
		mIntent = getIntent();
		String content = mIntent.getStringExtra("content");
		if(content != null){
			mContentTextView.setText(content);
		}
	}
	@Override  
	public boolean onTouchEvent(MotionEvent event){  
	    finish();  
	    return true;  
	}  
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialog_cancel:
			setResult(sDIALOG_CANCEL, mIntent);
			finish();
			break;
		case R.id.dialog_ok:
			setResult(sDIALOG_OK, mIntent);
			finish();
			break;
		default:
			break;
		}
		finish();
	}
}
