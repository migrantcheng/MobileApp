package cmu.edu.haoranc.movietab.message;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cmu.edu.haoranc.movietab.R;

public class MessageListAdapter extends BaseAdapter{
	
	private Activity activity;
    private String[] data;
    private static LayoutInflater inflater=null;
    
    public MessageListAdapter(Activity a, String[] d) {
    	activity = a;
    	data = d;
    	inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.message_list_row, null);
 
        TextView title = (TextView)vi.findViewById(R.id.message_user); // title
        
        title.setText("From "+data[position]);
        
        return vi;
	}

}
