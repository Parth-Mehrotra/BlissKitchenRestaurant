package com.parth.bliss.menumanager;

import com.parse.ParseObject;
import com.parse.Parse;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CheckedTextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseExpandableListAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MenuManager extends Activity {
	private SparseArray<DishGroup> groups;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Parse.initialize(this, "oaZEhvpdjUWDQZjG4zr60avFlkH7qg8wpSssnSqQ", "i21rRuoA6dZahGZy10kGLCPIWbVY9ULTrPfSNX3x");
		groups = new SparseArray<DishGroup>();
		createData();
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.menu_list);
		DishAdapter adapter = new DishAdapter(this, groups);
		listView.setAdapter(adapter);
		setupControlButtons();
	}

	private void setupControlButtons() {
		findViewById(R.id.menu_add).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addButtonPressed();
			}
		});
		findViewById(R.id.menu_add).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				removeButtonPressed();
			}
		});
		findViewById(R.id.menu_add).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				refreshButtonPressed();
			}
		});
	}

	private void addButtonPressed() {
		
	}
	private void removeButtonPressed() {

	}
	private void refreshButtonPressed() {

	}

	public void createData() {
		for (int i = 0; i < 5; i++) {
			DishGroup group = new DishGroup(System.currentTimeMillis() + "", "Test " + i);
			for (int j = 0; j < 5; j++) {
				group.dishes().add(new DishModel(System.currentTimeMillis() + "", "S", "S", "S"));
			}
			groups.append(i, group);
		}
	}

	private class DishAdapter extends BaseExpandableListAdapter {
		private SparseArray<DishGroup> groups;
		private LayoutInflater inflater;
		private Activity activity;

		public DishAdapter(Activity activity, SparseArray<DishGroup> groups) {
			this.activity = activity;
			this.groups = groups;
			inflater = activity.getLayoutInflater();
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return groups.get(groupPosition).dishes().get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return 0;
		}

		@Override
		public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
			final DishModel _children = (DishModel) getChild(groupPosition, childPosition);
			final String children = _children.getTitle();
			TextView text = null;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.itemmodel, null);
			}
			text = (TextView) convertView.findViewById(R.id.dishName);
			text.setText(children);
			convertView.setTag(_children);

			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					System.out.println(((DishModel) v.getTag()).getObjectID());
					//Intent intent = new Intent(this, GroupDetail.class);
					//intent.putExtra
				}
			});
			return convertView;
		}

		@Override
		public void onGroupExpanded(int groupPosition) {
			System.out.println(groups.get(groupPosition).getObjectID());
			super.onGroupExpanded(groupPosition);
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return groups.get(groupPosition).dishes().size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			return groups.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return groups.size();
		}

		@Override
		public void onGroupCollapsed(int groupPosition) {
			super.onGroupCollapsed(groupPosition);
		}

		@Override
		public long getGroupId(int groupPosition) {
			return 0;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.listgroup, null);
			}

			CheckedTextView ctv = (CheckedTextView) convertView.findViewById(R.id.category);
			DishGroup group = (DishGroup) getGroup(groupPosition);
			ctv.setText(group.getName());
			ctv.setChecked(isExpanded);
			//convertView.setOnClickListener(new OnClickListener() {
			//	@Override
			//	public void onClick(View v) {
			//		System.out.println(v.getTag());
			//	}
			//});
			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return false;
		}
	}
}
