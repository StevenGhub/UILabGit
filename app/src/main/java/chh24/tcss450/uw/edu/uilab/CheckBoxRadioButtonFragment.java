package chh24.tcss450.uw.edu.uilab;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxRadioButtonFragment extends Fragment implements View.OnClickListener {

    private OnCheckFragmentInteractionListener mListener;
    private boolean mCheck = false;

    public CheckBoxRadioButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_check_box_radio_button, container, false);
        RadioButton rb = (RadioButton) v.findViewById(R.id.radioYes);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        rb = (RadioButton) v.findViewById(R.id.radioNo);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        Button b = (Button) v.findViewById(R.id.submit);
        b.setOnClickListener(v1 -> onClick(v));
        return v;
    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        GradientDrawable bg = (GradientDrawable) getActivity()
                .findViewById(R.id.radioGroup).getBackground();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioYes:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.yes));
                    mCheck = true;
                break;
            case R.id.radioNo:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.no));
                    mCheck = false;
                break;
            default:
                Log.wtf("", "Shouldn't happen");
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        GradientDrawable bg = (GradientDrawable)
                getActivity().findViewById(R.id.radioGroup).getBackground();
        bg.setColor(getResources().getColor(R.color.fill));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCheckFragmentInteractionListener) {
            mListener = (OnCheckFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onClick(View theView) {
        if (mListener != null && mCheck) {
            String message = "You choose ";
            if (((CheckBox) theView.findViewById(R.id.checkMeat)).isChecked())
                message += "meat";
            if (((CheckBox) theView.findViewById(R.id.checkChe)).isChecked())
                message += ", Cheese";
            if (((CheckBox) theView.findViewById(R.id.checkVeg)).isChecked())
                message += ", Vegetable";
            if (((CheckBox) theView.findViewById(R.id.checkSauce)).isChecked())
                message += ", Sauce";

            if (message.length() < 12)
                message += "nothing";
            message += ".";
            mListener.onCheckFragmentInteraction(message);
        }
    }

    public interface OnCheckFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCheckFragmentInteraction(String message);
    }
}
