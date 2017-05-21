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
 *  String image_name;
 String category_name="";
 int resId=0;
 switch (category){

 case 1:  resId= this.context.getResources().getIdentifier("icon_clothing", "drawable", "com.example.nowel.android_training_roman_ananich");
 category_name="Clothing";
 break;
 case 2:  resId= this.context.getResources().getIdentifier("icon_equipment", "drawable", "com.example.nowel.android_training_roman_ananich");
 category_name="Equipment";
 break;
 case 3:  resId= this.context.getResources().getIdentifier("icon_machines", "drawable", "com.example.nowel.android_training_roman_ananich");
 category_name="Machines";
 break;
 case 4:  resId= this.context.getResources().getIdentifier("icon_bicycle", "drawable", "com.example.nowel.android_training_roman_ananich");
 category_name="Bycicles";
 break;
 }


 View vi = convertView;
 if (vi == null)
 vi = inflater.inflate(R.layout.list_row, null);
 TextView text_name = (TextView) vi.findViewById(R.id.textView_itemName);
 TextView text_category = (TextView) vi.findViewById(R.id.textView_itemCategory);
 TextView text_price = (TextView) vi.findViewById(R.id.textView_itemPrice);
 ImageView picture = (ImageView) vi.findViewById(R.id.row_image);
 text_name.setText(name);
 text_category.setText(category_name);
 text_price.setText(price);
 picture.setImageResource(resId);
 */
// __________________LESSSON !!!!!!________LLLLLLLLLLLLLLLLL
public class ListAdapter extends BaseAdapter implements Filterable{
    private Context context;
    private int category;
    private String name;
    private String image_name;
    private String category_name;
    private int resId=0;
    private int price;
    private ArrayList<Lesson> arrayList;
    private ArrayList<Lesson> arrayListSave;
    private static LayoutInflater inflater = null;

    public ListAdapter(Context context,ArrayList<Lesson> arrayList) {
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
            convertView=inflater.inflate(R.layout.list_row_lesson,parent,false);
        }
        TextView titleText= (TextView) convertView.findViewById(R.id.textViewL_itemTitle);
        TextView typeText= (TextView) convertView.findViewById(R.id.textViewL_itemType);
        ImageView img= (ImageView) convertView.findViewById(R.id.row_imageL);
        Button open=(Button) convertView.findViewById(R.id.button_openL);
        String title=arrayList.get(position).getTitle();
        final String type=arrayList.get(position).getType();
        String url="";
        String text="";
        switch (type){

            case "Video":  resId= this.context.getResources().getIdentifier("icon_video", "drawable", "com.example.nowel.android_training_roman_ananich");
                url=arrayList.get(position).getUrl();
                break;
            case "Text":  resId= this.context.getResources().getIdentifier("icon_text", "drawable", "com.example.nowel.android_training_roman_ananich");
                text=arrayList.get(position).getText();
                break;
        }

        final String urls=url;
        final String texts=text;
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
        open.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              if (type=="Video"){
                  Intent intent = new Intent(context,LessonActivityVideo.class);
                  intent.putExtra("url", urls);
                  context.startActivity(intent);
              }
              else {
                  Intent intent = new Intent(context,LessonActivityText.class);
                  intent.putExtra("text",texts);
                  context.startActivity(intent);
              }

            }
        });
        return convertView;
    }

    public void filter(String charText) {

        if (charText.length() == 0) {
            arrayList.clear();
            arrayList.add(new Lesson());
            arrayList.addAll(arrayListSave);
        }
        else
        {
           arrayList.clear();
            for (Lesson wp : arrayListSave)
            {
                if (wp.getTitle().contains(charText))
                {
                    arrayList.add(new Lesson());
                    arrayList.add(new Lesson());
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

                arrayList = (ArrayList<Lesson>) results.values; // has the filtered values
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
