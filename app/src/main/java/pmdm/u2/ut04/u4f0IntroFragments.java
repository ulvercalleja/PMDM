package pmdm.u2.ut04;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import pmdm.u2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link u4f0IntroFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class u4f0IntroFragments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public u4f0IntroFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment u4f0IntroFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static u4f0IntroFragments newInstance(String param1, String param2) {
        u4f0IntroFragments fragment = new u4f0IntroFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView tvClick;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_u4f0_intro_fragments, container, false);
        tvClick = layout.findViewById(R.id.u4f0tvClick);
        tvClick.setOnClickListener((View V)->{
            Random random = new Random();

            // Generar valores aleatorios para los componentes RGB
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            // Construir el color con los componentes generados
            int color = Color.rgb(red, green, blue);
            layout.setBackgroundColor(color);
        });
        return layout;
    }
}