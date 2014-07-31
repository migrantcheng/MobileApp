package cmu.edu.haoranc.movietab.message;

import java.util.List;

import com.parse.ParseObject;

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
    private List<ParseObject> data;
    private static LayoutInflater inflater=null;
    
    public MessageListAdapter(Activity a, List<ParseObject> d) {
    	activity = a;
    	data = d;
    	inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	@Override
	public int getCount() {
		return data.size();
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
        
        TextView username = (TextView)vi.findViewById(R.id.message_user); 
        TextView showtime = (TextView)vi.findViewById(R.id.message_showtime); 
        showtime.setText(data.get(position).getParseObject("likedlist").getString("showtime") 
        		+ " - " + data.get(position).getParseObject("likedlist").getString("theater"));
        TextView likedId = (TextView)vi.findViewById(R.id.message_id); 
        likedId.setText(data.get(position).getObjectId());
        System.out.println("In adpater " + likedId.getText());
        ParseObject obj = data.get(position);
        if (obj.getString("fromuser").equals("Haoran Cheng")) {
        	username.setText("To " + obj.getString("touser"));
        } else {
        	username.setText("From " + obj.getString("fromuser"));
        }
 
        return vi;
	}

}
