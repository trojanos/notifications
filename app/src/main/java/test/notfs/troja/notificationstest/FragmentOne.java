package test.notfs.troja.notificationstest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {
    Button createNewNotf;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_one, container, false);
        initView(v);
        return  v;
    }

    private void initView(View v) {
        createNewNotf = (Button) v.findViewById(R.id.button_Create_notification);



    }

    @Override
    public String toString() {
        return "1";
    }
}
