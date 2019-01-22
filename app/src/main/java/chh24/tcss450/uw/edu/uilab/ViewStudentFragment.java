package chh24.tcss450.uw.edu.uilab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewStudentFragment extends Fragment {


    public ViewStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_student, container, false);
    }

    public void updateContent (String theS, String theKey) {

        if (theKey.equals("studentID")) {
            TextView tv = getActivity().findViewById(R.id.studentID);
            tv.setText(theS);
        } else if (theKey.equals("studentName")) {
            TextView tv = getActivity().findViewById(R.id.studentName);
            tv.setText(theS);
        } else {
            TextView tv = getActivity().findViewById(R.id.studentDetails);
            tv.setText(theS);
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        if (getArguments() != null) {
            String id = getArguments().getString(getString(R.string.studentViewID));
            updateContent(id, "studentID");
            String name = getArguments().getString(getString(R.string.studentViewName));
            updateContent(name, "studentName");
            String detail = getArguments().getString(getString(R.string.studentViewDetail));
            updateContent(detail, "studentDetails");
        }
    }
}
