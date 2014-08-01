package cmu.edu.haoranc.movietab.movie;


import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import cmu.edu.haoranc.movietab.R;

public class MovieDetailFragment extends Fragment {
	

    private FragmentActivity myContext;
	private View rootView;
	private ListView STList;
	Image movieImg;
	TextView title;
	TextView director;
	TextView release;
	TextView genre;
	TextView synopsis;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        
        title = (TextView) rootView.findViewById(R.id.Title);
		director = (TextView) rootView.findViewById(R.id.Director);
		release = (TextView) rootView.findViewById(R.id.Release);
		genre = (TextView) rootView.findViewById(R.id.Genre);
		synopsis = (TextView) rootView.findViewById(R.id.Synopsis);
		
		title.setText("DAWN OF THE PANET OF THE APES");
		director.setText("Director: Matt Reeves");
//		release.setText("Release Date: Fri,Jul 11,2014");
//		genre.setText("Genre: Action, Drama, Sci-Fri");
//		synopsis.setText("Synopsis: A growing nation........");
		
		btn1 = (Button) rootView.findViewById(R.id.button1);
		btn2 = (Button) rootView.findViewById(R.id.button2);
		btn3 = (Button) rootView.findViewById(R.id.button3);
		btn4 = (Button) rootView.findViewById(R.id.button4);
		btn5 = (Button) rootView.findViewById(R.id.button5);
		
		btn1.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        refreshSTList(v);
		    }
		});
        refreshSTList(rootView);
        return rootView;
    }
    
    
    public void refreshSTList(View view) {
    	
    	ShowTimeList showtimelist_data[] = new ShowTimeList[] {
				new ShowTimeList("AMC LOEWS WATERFROUNT 22"), new ShowTimeList("CINEMAGIC MANOR THEATERS"),
				new ShowTimeList("SOUTHSIDE WORKS CINEMA") };

		ShowTimeAdapter adapter = new ShowTimeAdapter(myContext, R.layout.fragment_showtime_row,
				showtimelist_data);
		STList = (ListView) rootView.findViewById(R.id.STlistView);
		STList.setAdapter(adapter);
		STList.setOnItemClickListener(new android.widget.ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String theaterName = ((TextView) view.findViewById(R.id.title)).getText().toString();
				TheaterDetailFragment fragment = new TheaterDetailFragment(theaterName);
				FragmentTransaction transaction = myContext.getSupportFragmentManager().beginTransaction();
				
				// Replace whatever is in the fragment_container view with this fragment,
	        	// and add the transaction to the back stack so the user can navigate back
	        	transaction.replace(R.id.movie_fragment_container, fragment);
	        	transaction.addToBackStack(null);
	        	
	        	// Commit the transaction
	        	transaction.commit();
				
			}
		
	    });
    	
    }
    
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}

