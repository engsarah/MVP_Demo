package com.etisalat.foodmenuloader.ui.bases;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.etisalat.foodmenuloader.R;

/**
 * Base Fragment class should be extended by any fragment through
 * out the application
 * @param <T>
 */
public abstract class BaseFragment<T extends BasePresenter> extends
        Fragment implements BasePresenterListener {
    private ProgressDialog progressDialog;
    protected T presenter;
    protected FragmentActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = setupPresenter();
    }

    protected abstract T setupPresenter();

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            if (getActivity() == null) return;
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage(getResources().getString(
                    R.string.pleasewait));
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    if (getActivity() != null)
                        getActivity().finish();
                }
            });
        }
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (getActivity() != null && !getActivity().isFinishing() && progressDialog != null
                && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (FragmentActivity) activity;
    }
}
