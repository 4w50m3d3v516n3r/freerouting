package app.freerouting.gui;

import app.freerouting.management.TextManager;
import app.freerouting.management.analytics.FRAnalytics;

import javax.swing.*;

/**
 * Popup Menu used in the interactive select state.
 */
class PopupMenuMain extends PopupMenuDisplay
{

  /**
   * Creates a new instance of MainPopupMenu
   */
  PopupMenuMain(BoardFrame p_board_frame)
  {
    super(p_board_frame);
    TextManager tm = new TextManager(this.getClass(), p_board_frame.get_locale());

    // add the item for selecting items

    JMenuItem popup_select_item_menuitem = new JMenuItem();
    popup_select_item_menuitem.setText(tm.getText("select_item"));
    popup_select_item_menuitem.addActionListener(evt -> board_panel.board_handling.select_items(board_panel.right_button_click_location));
    popup_select_item_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("popup_select_item_menuitem", popup_select_item_menuitem.getText()));

    this.add(popup_select_item_menuitem, 0);

    // Insert the start route item.

    JMenuItem popup_start_route_menuitem = new JMenuItem();
    popup_start_route_menuitem.setText(tm.getText("start_route"));
    popup_start_route_menuitem.addActionListener(evt -> board_panel.board_handling.start_route(board_panel.right_button_click_location));
    popup_start_route_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("popup_start_route_menuitem", popup_start_route_menuitem.getText()));

    this.add(popup_start_route_menuitem, 1);

    // Insert the create_obstacle_menu.

    JMenu create_obstacle_menu = new JMenu();

    create_obstacle_menu.setText(tm.getText("create_keepout"));

    JMenuItem popup_create_tile_menuitem = new JMenuItem();
    popup_create_tile_menuitem.setText(tm.getText("tile"));
    popup_create_tile_menuitem.addActionListener(evt -> board_panel.board_handling.start_tile(board_panel.right_button_click_location));
    popup_create_tile_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("popup_create_tile_menuitem", popup_create_tile_menuitem.getText()));

    create_obstacle_menu.add(popup_create_tile_menuitem);

    JMenuItem popup_create_circle_menuitem = new JMenuItem();
    popup_create_circle_menuitem.setText(tm.getText("circle"));
    popup_create_circle_menuitem.addActionListener(evt -> board_panel.board_handling.start_circle(board_panel.right_button_click_location));
    popup_create_circle_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("popup_create_circle_menuitem", popup_create_circle_menuitem.getText()));

    create_obstacle_menu.add(popup_create_circle_menuitem);

    JMenuItem popup_create_polygon_menuitem = new JMenuItem();
    popup_create_polygon_menuitem.setText(tm.getText("polygon"));
    popup_create_polygon_menuitem.addActionListener(evt -> board_panel.board_handling.start_polygonshape_item(board_panel.right_button_click_location));
    popup_create_polygon_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("popup_create_polygon_menuitem", popup_create_polygon_menuitem.getText()));

    create_obstacle_menu.add(popup_create_polygon_menuitem);

    JMenuItem popup_add_hole_menuitem = new JMenuItem();
    popup_add_hole_menuitem.setText(tm.getText("hole"));
    popup_add_hole_menuitem.addActionListener(evt -> board_panel.board_handling.start_adding_hole(board_panel.right_button_click_location));
    popup_add_hole_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("popup_add_hole_menuitem", popup_add_hole_menuitem.getText()));

    create_obstacle_menu.add(popup_add_hole_menuitem);

    this.add(create_obstacle_menu, 2);

    // Insert the pin swap item.

    if (board_panel.board_handling.get_routing_board().library.logical_parts.count() > 0)
    {
      // the board contains swappable gates or pins
      JMenuItem popup_swap_pin_menuitem = new JMenuItem();
      popup_swap_pin_menuitem.setText(tm.getText("swap_pin"));
      popup_swap_pin_menuitem.addActionListener(evt -> board_panel.board_handling.swap_pin(board_panel.right_button_click_location));
      popup_swap_pin_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("popup_swap_pin_menuitem", popup_swap_pin_menuitem.getText()));

      this.add(popup_swap_pin_menuitem, 3);
    }
  }
}