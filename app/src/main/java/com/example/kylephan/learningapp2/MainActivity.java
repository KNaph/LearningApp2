package com.example.kylephan.learningapp2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kylephan.learningapp2.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new ItemFragment())
                    .commit();
        }
    }



    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        // Capture the course fragment from the activity layout
        DetailFragment detailFragment = (DetailFragment)
                getFragmentManager().findFragmentById(R.id.fragDetail_frag);

        if (detailFragment != null) {
            // If courseDetail frag is available, we're in two-pane layout...

            // Call a method in the course detail fragment to update its content
            detailFragment.updateCourseItemView(item);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected student
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back

            detailFragment =
                    detailFragment.getDetailFragment(item);

            FragmentTransaction transaction = getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }

    }
}
