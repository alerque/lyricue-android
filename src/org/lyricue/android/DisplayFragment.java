package org.lyricue.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DisplayFragment extends Fragment {
	private static final String TAG = Lyricue.class.getSimpleName();

	Lyricue activity = null;
	View v = null;
	String bookname = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = (Lyricue) getActivity();
		v = (View) inflater.inflate(R.layout.display, null);
		Button b = (Button) v.findViewById(R.id.buttonDisplayMain);
		b.setOnClickListener(new DisplayOnClickListener());
		b = (Button) v.findViewById(R.id.buttonDisplayOSD);
		b.setOnClickListener(new DisplayOnClickListener());

		return v;
	}

	public class DisplayOnClickListener implements OnClickListener {
		@Override
		public void onClick(View vi) {
			Log.i(TAG, "onClickBible");
			EditText text = (EditText) v.findViewById(R.id.editDisplay);
			String textString = text.getText().toString();
			switch (vi.getId()) {
			case R.id.buttonDisplayMain:
				activity.ld.runCommand_noreturn("preview", "", textString);
				break;
			case R.id.buttonDisplayOSD:
				activity.ld.runCommand_noreturn("osd", "default", textString);

				break;
			}
		}
	}

}
