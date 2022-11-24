package com.example.demo.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 * A navigation menu with support for hierarchical and flat menus.
 * <p>
 * Items can be added using {@link #addItem(AppNavItem)} and hierarchy can be
 * created by adding {@link AppNavItem} instances to other {@link AppNavItem}
 * instances.
 */
@JsModule("@vaadin-component-factory/vcf-nav")
@Tag("vcf-nav")
public class AppNav extends Component {

  /**
   * Creates a new menu without any label.
   */
  public AppNav() {
  }

  /**
   * Adds menu item(s) to the menu.
   *
   * @param appNavItems
   *            the menu item(s) to add
   * @return the menu for chaining
   */
  public AppNav addItem(AppNavItem... appNavItems) {
    for (AppNavItem appNavItem : appNavItems) {
      getElement().appendChild(appNavItem.getElement());
    }
    return this;
  }
}
