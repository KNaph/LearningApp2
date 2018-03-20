package com.example.kylephan.learningapp2;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kylephan.learningapp2.Person.PersonContent;
import com.example.kylephan.learningapp2.dummy.DummyContent;


public class DetailFragment extends Fragment {

    public static final String DETAIL_PARAM = "detail_param";
    private PersonContent mFragmentItem;


    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
//        args.putSerializable(DETAIL_PARAM, item);
        fragment.setArguments(args);
        return fragment;
    }

    public static DetailFragment getDetailFragment(PersonContent item) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(DETAIL_PARAM, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFragmentItem = (PersonContent) getArguments().getSerializable(DETAIL_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
//        if (mFragmentItem == null) {
//            mFragmentItem = DummyContent.ITEMS.get(0);
//        }
        TextView detailPersonId = (TextView) v.findViewById(R.id.detail_person_id);
        detailPersonId.setText(mFragmentItem.id);
        TextView detailPersonBalance = (TextView) v.findViewById(R.id.detail_person_balance);
        detailPersonBalance.setText(mFragmentItem.balance);
        TextView detailPersonName = (TextView) v.findViewById(R.id.detail_person_name);
        detailPersonName.setText(mFragmentItem.name);
        TextView detailPersonInfo = (TextView) v.findViewById(R.id.detail_person_info);
        detailPersonInfo.setText(mFragmentItem.info);
        TextView detailPersonBio = (TextView) v.findViewById(R.id.detail_person_bio);
        detailPersonBio.setText(mFragmentItem.bio);

        return v;
    }

    public void updateCourseItemView(PersonContent item) {
        TextView detailPersonId = (TextView) getActivity().findViewById(R.id.detail_person_id);
        detailPersonId.setText(item.id);
        TextView detailPersonBalance = (TextView) getActivity().findViewById(R.id.detail_person_balance);
        detailPersonBalance.setText(item.balance);
        TextView detailPersonName = (TextView) getActivity().findViewById(R.id.detail_person_name);
        detailPersonName.setText(item.name);
        TextView detailPersonInfo = (TextView) getActivity().findViewById(R.id.detail_person_info);
        detailPersonInfo.setText(item.info);
        TextView detailPersonBio = (TextView) getActivity().findViewById(R.id.detail_person_bio);
        detailPersonBio.setText(item.bio);
    }
}
