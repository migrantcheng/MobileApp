package cmu.edu.haoranc.movietab.message;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cmu.edu.haoranc.movietab.R;

public class MessageFragment extends Fragment {
	
	private ListView list;
	private MessageListAdapter adapter;
	private FragmentActivity context;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);
        
        list = (ListView) rootView.findViewById(R.id.messageList);
        String[] testArr = {"Hello", "123","Hello", "123","Hello", "123","Hello", "123","Hello", "123","Hello", "123","Hello", "123"};
//        list.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, R.id.title, testArr));
        adapter = new MessageListAdapter(context, testArr);
        list.setAdapter(adapter);
        
        
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        context=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
