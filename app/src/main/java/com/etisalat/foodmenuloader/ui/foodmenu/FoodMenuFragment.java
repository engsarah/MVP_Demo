package com.etisalat.foodmenuloader.ui.foodmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.etisalat.foodmenuloader.R;
import com.etisalat.foodmenuloader.adapter.MenuItemsAdapter;
import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.ui.bases.BaseFragment;
import com.etisalat.foodmenuloader.ui.mainActivity.MainActivity;

import java.util.List;

/**
 * This Fragment is responsible for displaying list of pizza items
 */
public class FoodMenuFragment extends BaseFragment<FoodMenuPresenterImpl> implements FoodMenuMvpView {

    public static final String TAG = "FoodMenuFragment";


    private FoodMenuFragmentController mController;
    private FoodMenuPresenterImpl mPresenter;
    private RecyclerView itemsListRecycler;
    private Button refreshBtn;
    private TextView titleTxtView;
    private TextView noDateAvailableTxtView;

    Context mContext;

    private RecyclerView.Adapter recyclerView_Adapter;

    private RecyclerView.LayoutManager recyclerViewLayoutManager;

    /**
     *
     * @return instance of the FoodMenuFragment
     */
    public static FoodMenuFragment newInstance() {
        Bundle args = new Bundle();
        FoodMenuFragment fragment = new FoodMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    /**
     *
     * @return mPresenter instance
     */
    @Override
    protected FoodMenuPresenterImpl setupPresenter() {
        return new FoodMenuPresenterImpl(this, mController);
    }

    /**
     * bind layout xml and use presenter to retrieve data from backend
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //bind the layout xml
        View view = inflater.inflate(R.layout.fragment_menu_items, container, false);
        refreshBtn = (Button) view.findViewById(R.id.refresh_btn);
        //Initialize pizza items recycler view
        itemsListRecycler = (RecyclerView) view.findViewById(R.id.items_list);

        recyclerViewLayoutManager = new LinearLayoutManager(this.getActivity());
        itemsListRecycler.setLayoutManager(recyclerViewLayoutManager);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        titleTxtView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        noDateAvailableTxtView  = (TextView) view.findViewById(R.id.errorTxTVw);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Setup controller class
        mController = new FoodMenuFragmentController(mPresenter, this);

        //call the presenter to retrive menu data from the backend
        mPresenter = setupPresenter();
        mPresenter.getMenuItems();

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter = setupPresenter();
                mPresenter.getMenuItems();

            }
        });

        return view;

    }


    /**
     * a callback to diplay list of item
     * @param itemsList
     */
    @Override
    public void displayFoodMenuItems(List<Item> itemsList) {


        recyclerView_Adapter = new MenuItemsAdapter(this.getActivity(), itemsList);

        itemsListRecycler.setAdapter(recyclerView_Adapter);

        refreshBtn.setVisibility(View.VISIBLE);

        noDateAvailableTxtView.setVisibility(View.GONE);

        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);

        itemsListRecycler.setAnimation(animation);

    }

    /**
     * a callback to display snackbar in case of network issues
     * @param errorMessage
     */
    @Override
    public void displayErrorMessage(String errorMessage) {
        ((MainActivity) getActivity()).showSnackBar(errorMessage);
        noDateAvailableTxtView.setVisibility(View.VISIBLE);
        refreshBtn.setVisibility(View.VISIBLE);



    }

    /**
     * a callback to update timestamp in the toolbar
     * @param title
     */
    @Override
    public void updateToolbarTitle(String title) {
        titleTxtView.setText(title);


    }


}
