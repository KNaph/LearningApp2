package com.example.kylephan.learningapp2;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kylephan.learningapp2.dummy.DummyContent;


public class DetailFragment extends Fragment {

    public static final String DETAIL_PARAM = "detail_param";
    private DummyContent.DummyItem mFragmentItem;


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

    public static DetailFragment getDetailFragment(DummyContent.DummyItem item) {
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
            mFragmentItem = (DummyContent.DummyItem) getArguments().getSerializable(DETAIL_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        if (mFragmentItem == null) {
            mFragmentItem = DummyContent.ITEMS.get(0);
        }
        TextView fragmentItemId = (TextView) v.findViewById(R.id.fragment_item_id);
        fragmentItemId.setText(mFragmentItem.id);
        TextView fragmentItemTitle = (TextView) v.findViewById(R.id.fragment_item_title);
        fragmentItemTitle.setText(mFragmentItem.title);
        TextView fragmentItemDesc = (TextView) v.findViewById(R.id.fragment_item_desc);
        fragmentItemDesc.setText(mFragmentItem.shortDesc);

        return v;
    }

    public void updateCourseItemView(DummyContent.DummyItem item) {
        TextView fragmentItemId = (TextView) getActivity().findViewById(R.id.fragment_item_id);
        fragmentItemId.setText(item.id);
        TextView fragmentItemTitle = (TextView) getActivity().findViewById(R.id.fragment_item_title);
        fragmentItemTitle.setText(item.title);
        TextView fragmentItemDesc = (TextView) getActivity().findViewById(R.id.fragment_item_desc);
        fragmentItemDesc.setText(item.shortDesc);

    }
}
