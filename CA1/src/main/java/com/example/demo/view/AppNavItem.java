package com.example.demo.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.dom.Element;
import java.util.Optional;

/**
 * A menu item for the {@link AppNav} component.
 * <p>
 * Can contain a label and/or an icon and links to a given {@code path}.
 */
@JsModule("@vaadin-component-factory/vcf-nav")
@Tag("vcf-nav-item")
public class AppNavItem extends Component {

  /**
   * Creates a new menu item using the given label that links to the given view.
   *
   * @param label
   *            the label for the item
   * @param view
   *            the view to link to
   */
  public AppNavItem(String label, Class<? extends Component> view) {
    setLabel(label);
  }

  /**
   * Adds menu item(s) inside this item, creating a hierarchy.
   *
   * @param appNavItems
   *            the menu item(s) to add
   * @return this item for chaining
   */
  public AppNavItem addItem(AppNavItem... appNavItems) {
    for (AppNavItem appNavItem : appNavItems) {
      appNavItem.getElement().setAttribute("slot", "children");
      getElement().appendChild(appNavItem.getElement());
    }

    return this;
  }

  /**
   * Gets the label for the item.
   *
   * @return the label or null if no label has been set
   */
  public String getLabel() {
    return getExistingLabelElement().map(Element::getText).orElse(null);
  }

  /**
   * Set a textual label for the item.
   * <p>
   * The label is also available for screen rader users.
   *
   * @param label
   *            the label to set
   * @return this instance for chaining
   */
  public AppNavItem setLabel(String label) {
    getLabelElement().setText(label);
    return this;
  }

  private Optional<Element> getExistingLabelElement() {
    return getElement().getChildren().filter(child -> !child.hasAttribute("slot")).findFirst();
  }

  private Element getLabelElement() {
    return getExistingLabelElement().orElseGet(() -> {
      Element element = Element.createText("");
      getElement().appendChild(element);
      return element;
    });
  }

  private int getIconElementIndex() {
    for (int i = 0; i < getElement().getChildCount(); i++) {
      if ("prefix".equals(getElement().getChild(i).getAttribute("slot"))) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Sets the icon for the item.
   * <p>
   * Can also be used to set a custom component to be shown in front of the label.
   *
   * @param icon
   *            the icon to show
   * @return this instance for chaining
   */
  public AppNavItem setIcon(Component icon) {
    icon.getElement().setAttribute("slot", "prefix");
    int iconElementIndex = getIconElementIndex();
    if (iconElementIndex != -1) {
      getElement().setChild(iconElementIndex, icon.getElement());
    } else {
      getElement().appendChild(icon.getElement());
    }
    return this;
  }

  /**
   * Sets the icon using a CSS class for the item.
   * <p>
   * Can also be used to set a custom component to be shown in front of the label.
   *
   * @param iconClass
   *            the CSS class to use for showing the icon
   * @return this instance for chaining
   */
  public AppNavItem setIconClass(String iconClass) {
    Span icon = new Span();
    icon.setClassName(iconClass);
    setIcon(icon);
    return this;
  }

}
