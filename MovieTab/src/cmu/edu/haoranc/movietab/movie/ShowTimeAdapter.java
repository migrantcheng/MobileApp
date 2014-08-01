package cmu.edu.haoranc.movietab.movie;


import cmu.edu.haoranc.movietab.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class ShowTimeAdapter extends ArrayAdapter<ShowTimeList> {
	Context context; 
    int layoutResourceId;    
    ShowTimeList data[] = null;
    
    public ShowTimeAdapter(Context context, int layoutResourceId, ShowTimeList[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ShowtimeHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new ShowtimeHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.title);
            
            row.setTag(holder);
        }
        else
        {
            holder = (ShowtimeHolder)row.getTag();
        }
        
        ShowTimeList showtime = data[position];
        holder.txtTitle.setText(showtime.title);
        
        return row;
    }
    
    static class ShowtimeHolder
    {
        TextView txtTitle;
    }
}
