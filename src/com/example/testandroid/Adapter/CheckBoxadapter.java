package com.example.testandroid.Adapter;

import java.util.ArrayList;

import com.example.testandroid.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

public class CheckBoxadapter extends BaseAdapter{

	Context mContext;
	ArrayList<String> mArrayList;
	ListView mListView;
	
	LayoutInflater inflater;
	private boolean isShowCheckBox = false;
	
	public CheckBoxadapter(Context context, ArrayList<String> arrayList, ListView listView){
		this.mContext = context;
		this.mArrayList = arrayList;
		this.mListView = listView;
		inflater = LayoutInflater.from(mContext);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListView.getCount();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mArrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		holder = new ViewHolder();
		if(convertView == null){
			convertView = inflater.inflate(R.layout.activity_check_box_list_view, parent, false);
			holder.textView = (TextView) convertView.findViewById(R.id.row_text);
			holder.checkBox = (CheckBox) convertView.findViewById(R.id.row_checkBox);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(mArrayList.get(position));
		if(isShowCheckBox ){
			holder.checkBox.setVisibility(View.GONE);
		}
		if(mListView.isItemChecked(position)){
			holder.checkBox.setChecked(true);
		}else{
			holder.checkBox.setChecked(false);
		}
		holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					mListView.setItemChecked(position, true);
				}else{
					mListView.setItemChecked(position, false);
				}
			}
		});
		
		return null;
	}
	
	class ViewHolder {
		TextView textView;
		CheckBox checkBox;
	}
	
}