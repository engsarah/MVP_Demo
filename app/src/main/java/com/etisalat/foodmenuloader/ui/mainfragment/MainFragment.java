package com.etisalat.foodmenuloader.ui.mainfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.etisalat.foodmenuloader.R;
import com.etisalat.foodmenuloader.ui.bases.BaseFragment;
import com.etisalat.foodmenuloader.ui.foodmenu.FoodMenuFragment;
import com.etisalat.foodmenuloader.ui.imageloader.ImageLoader;

/**
 * MainFragment which is first displayed upon starting
 * the app, contains main controlls for the rest of the app
 */
public class MainFragment extends BaseFragment<MainFragmentPresenterImpl> implements MainFragmentMvpView {


    private MainFragmentController mController;
    private MainFragmentPresenterImpl mPresenter;

    private Button displayMenuBtn;
    private Button imageLoaderBtn;

    /*
    Creating single MainFragment instance
     */
    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected MainFragmentPresenterImpl setupPresenter() {
        return new MainFragmentPresenterImpl( this, mController);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //bind the fragment layout xml
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mPresenter = setupPresenter();
        mController = new MainFragmentController(mPresenter, this);
        displayMenuBtn = (Button) view.findViewById(R.id.btn_display_Menu);
        imageLoaderBtn = (Button) view.findViewById(R.id.btn_image_loader);

        /**
         * Respond to user click events
         */
        displayMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFoodMenuFragment();
            }
        });
        imageLoaderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoImageLoaderActivity();
            }
        });
        return view;

    }

    //Load FoodMenuFragment
    public void gotoFoodMenuFragment() {

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                .replace(R.id.fragmentContainer, FoodMenuFragment.newInstance())
                .commit();

    }

    //Navigate to ImageLoader Activity
    public void gotoImageLoaderActivity() {
        Intent intent = new Intent(getActivity(), ImageLoader.class);
        startActivity(intent);

    }


}
