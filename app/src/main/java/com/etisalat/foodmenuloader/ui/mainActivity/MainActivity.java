package com.etisalat.foodmenuloader.ui.mainActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import com.etisalat.foodmenuloader.R;
import com.etisalat.foodmenuloader.ui.bases.BaseActivity;
import com.etisalat.foodmenuloader.ui.mainfragment.MainFragment;

/**
 * This is the main application starting point
 */
public class MainActivity extends BaseActivity<MainActivityPresenterImpl> implements MainViewInt {

    private MainActivityPresenterImpl mPresenter;
    private MainController controller;
    private LinearLayout fragmentContainer;

    /**
     * Upon MainActivity Creation, Load MainFragment in the main activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fragmentContainer = (LinearLayout) findViewById(R.id.fragmentContainer);
        //Attaching MainFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, MainFragment.newInstance());
        fragmentTransaction.addToBackStack("MainFragment");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        mPresenter = setupPresenter();
        controller = new MainController(mPresenter, this);

    }

    /**
     * setup presnter refrences
     * @return presenter
     */
    @Override
    protected MainActivityPresenterImpl setupPresenter() {
        return new MainActivityPresenterImpl(this, controller);
    }


    /**
     * Callback to the main activity to diplay snackbar
     * whenever needed in case of connection problems
     * @param errorMessage
     */
    @Override
    public void showSnackBar(String errorMessage) {
        super.showSnackbar(errorMessage, findViewById(R.id.main_view));
    }

}
