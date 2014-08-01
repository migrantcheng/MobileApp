package cmu.edu.haoranc.movietab.movie;

import cmu.edu.haoranc.movietab.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class TheaterDetailFragment extends Fragment {
	private FragmentActivity myContext;
	private String theaterName;
	private String movieName;
	private ListView STList;
	TextView theaterNameArea;
	TextView theaterAddress;
	TextView theaterPhone;

	public TheaterDetailFragment(String tName) {
		super();
		theaterName = tName;
		// movieName = mName;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_theater_detail,
				container, false);
		theaterNameArea = (TextView) rootView.findViewById(R.id.TheaterName);
		theaterAddress = (TextView) rootView.findViewById(R.id.TheaterAddress);
		theaterPhone = (TextView) rootView.findViewById(R.id.TheaterPhone);

		theaterNameArea.setText(theaterName);

		ShowTimeList showtimelist_data[] = new ShowTimeList[] { new ShowTimeList(
				"AMC LOEWS WATERFROUNT 22") };

		ShowTimeAdapter adapter = new ShowTimeAdapter(myContext,
				R.layout.fragment_showtime_row, showtimelist_data);
		STList = (ListView) rootView.findViewById(R.id.TMlist);
		STList.setAdapter(adapter);

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		myContext = (FragmentActivity) activity;
		super.onAttach(activity);
	}
}
