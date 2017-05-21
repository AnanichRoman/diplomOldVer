package com.example.nowel.android_training_roman_ananich;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nowel on 01.04.2017.
 */
//TEST__TEST__TEST__TEST__TEST__TEST__TEST__TEST__TEST__TEST__TEST__
public class ListAdapter2 extends BaseAdapter implements Filterable{
    private Context context;
    private int category;
    private String name;
    private String image_name;
    private String category_name;
    private int resId=0;
    private int price;
    private ArrayList<Test> arrayList;
    private ArrayList<Test> arrayListSave;
    private static LayoutInflater inflater = null;

    public ListAdapter2(Context context, ArrayList<Test> arrayList) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.arrayList=arrayList;
        this.arrayListSave=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.list_row_test,parent,false);
        }
        TextView titleText= (TextView) convertView.findViewById(R.id.textViewT_itemTitle);
        TextView typeText= (TextView) convertView.findViewById(R.id.textViewT_itemType);
        ImageView img= (ImageView) convertView.findViewById(R.id.row_imageT);
        Button open=(Button) convertView.findViewById(R.id.button_openT);
        String title=arrayList.get(position).getTitle();
        String type=arrayList.get(position).getType();
        switch (type){

            case "Normal":  resId= this.context.getResources().getIdentifier("icon_test", "drawable", "com.example.nowel.android_training_roman_ananich");

                break;
            case "Text":  resId= this.context.getResources().getIdentifier("icon_text", "drawable", "com.example.nowel.android_training_roman_ananich");

                break;
        }

        titleText.setText(title);
        typeText.setText(type);
        img.setImageResource(resId);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                if (v.getId() == R.id.button_add){
                    Toast.makeText(context,"Addd", Toast.LENGTH_SHORT).show();
                }

           }
        });

        final int pos=position;

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TestActivity.class);
                Test item = arrayList.get(pos);
                intent.putExtra("test",item);
                context.startActivity(intent);

            }
        });

        return convertView;
    }

    public void filter(String charText) {

        if (charText.length() == 0) {
            arrayList.clear();
            arrayList.add(new Test());
            arrayList.addAll(arrayListSave);
        }
        else
        {
           arrayList.clear();
            for (Test wp : arrayListSave)
            {
                if (wp.getTitle().contains(charText))
                {
                    arrayList.add(new Test());
                    arrayList.add(new Test());
                    arrayList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                arrayList = (ArrayList<Test>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<Lesson> FilteredArrList = new ArrayList<Lesson>();


                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = arrayListSave.size();
                    results.values = arrayListSave;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < arrayListSave.size(); i++) {
                        String data = arrayListSave.get(i).getTitle();
                        if (data.toLowerCase().startsWith(constraint.toString())) {
                            FilteredArrList.add(new Lesson());
                           }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }



}
