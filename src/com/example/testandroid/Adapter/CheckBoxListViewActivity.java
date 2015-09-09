package com.example.testandroid.Adapter;

import java.util.ArrayList;

import com.example.testandroid.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;

public class CheckBoxListViewActivity extends Activity{
	
	private ListView mListView;
	private CheckBoxadapter mAdapter;
	private ArrayList<String> mArrayList;
	
	private CustomMultiChoiceModeListener mListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_list_view);
		for(int i = 0 ; i < 10; i++){
			mArrayList.add("test: "+i);
		}
		mListView = (ListView) findViewById(R.id.check_box_listview);
		
		mAdapter = new CheckBoxadapter(this, mArrayList, mListView);
		mListView.setAdapter(mAdapter);
		mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		
		mListener = new CustomMultiChoiceModeListener();
		mListView.setMultiChoiceModeListener(mListener);
	}
	
	class CustomMultiChoiceModeListener implements MultiChoiceModeListener{

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.check_box_list_view, menu);
			//http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1105/1906.html
			return false;
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onItemCheckedStateChanged(ActionMode mode, int position,
				long id, boolean checked) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
