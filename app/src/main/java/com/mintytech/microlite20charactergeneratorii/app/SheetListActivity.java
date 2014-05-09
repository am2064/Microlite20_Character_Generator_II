package com.mintytech.microlite20charactergeneratorii.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.activeandroid.util.Log;
import com.mintytech.microlite20charactergeneratorii.app.dummy.DummyContent;


/**
 * An activity representing a list of Characters. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link SheetDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link SheetListFragment} and the item details
 * (if present) is a {@link SheetDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link SheetListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class SheetListActivity extends FragmentActivity
        implements SheetListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_list);

        if (findViewById(R.id.sheet_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((SheetListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.sheet_list))
                    .setActivateOnItemClick(true);
        }
        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link SheetListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(Long id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putLong(SheetDetailFragment.ARG_ITEM_ID, id);
            SheetDetailFragment fragment = new SheetDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.sheet_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, SheetDetailActivity.class);
            detailIntent.putExtra(SheetDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    public void addCharacter(MenuItem m) {
        startActivity(new Intent(this, ChooseRollActivity.class));
    }

}
