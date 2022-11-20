package com.example.demo.view;

import com.vaadin.flow.component.applayout.AppLayout;

public class MainBodyLayout extends AppLayout {
  public MainBodyLayout() {
    createNavigation();
  }

  private AppNav createNavigation() {
    AppNav nav = new AppNav();

    nav.addItem(new AppNavItem("", MainView.class));

    return nav;
  }
}
