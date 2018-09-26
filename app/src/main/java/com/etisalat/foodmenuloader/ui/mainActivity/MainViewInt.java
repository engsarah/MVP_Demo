package com.etisalat.foodmenuloader.ui.mainActivity;

import com.etisalat.foodmenuloader.ui.bases.BasePresenterListener;

/*
  View interface
 */
public interface MainViewInt extends BasePresenterListener{

    public void showSnackBar(String errorMessage);
}
