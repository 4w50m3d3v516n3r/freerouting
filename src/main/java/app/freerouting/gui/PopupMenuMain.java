package app.freerouting.gui;

import app.freerouting.board.TestLevel;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.util.ResourceBundle;

/** Popup Menu used in the interactive select state. */
class PopupMenuMain extends PopupMenuDisplay {

  /** Creates a new instance of MainPopupMenu */
  PopupMenuMain(BoardFrame p_board_frame) {
    super(p_board_frame);
    ResourceBundle resources =
        ResourceBundle.getBundle(
            "app.freerouting.gui.PopupMenuMain", p_board_frame.get_locale());

    // add the item for selecting items

    JMenuItem select_item_item = new JMenuItem();
    select_item_item.setText(resources.getString("select_item"));
    select_item_item.addActionListener(
        evt -> board_panel.board_handling.select_items(board_panel.right_button_click_location));

    this.add(select_item_item, 0);

    // Insert the start route item.

    JMenuItem start_route_item = new JMenuItem();
    start_route_item.setText(resources.getString("start_route"));
    start_route_item.addActionListener(
        evt -> board_panel.board_handling.start_route(board_panel.right_button_click_location));

    this.add(start_route_item, 1);

    // Insert the create_obstacle_menu.

    JMenu create_obstacle_menu = new JMenu();

    create_obstacle_menu.setText(resources.getString("create_keepout"));

    JMenuItem create_tile_item = new JMenuItem();
    create_tile_item.setText(resources.getString("tile"));
    create_tile_item.addActionListener(
        evt -> board_panel.board_handling.start_tile(board_panel.right_button_click_location));

    if (board_panel.board_handling.get_routing_board().get_test_level()
        != TestLevel.RELEASE_VERSION) {
      create_obstacle_menu.add(create_tile_item);
    }

    JMenuItem create_circle_item = new JMenuItem();
    create_circle_item.setText(resources.getString("circle"));
    create_circle_item.addActionListener(
        evt -> board_panel.board_handling.start_circle(board_panel.right_button_click_location));

    create_obstacle_menu.add(create_circle_item);

    JMenuItem create_polygon_item = new JMenuItem();
    create_polygon_item.setText(resources.getString("polygon"));
    create_polygon_item.addActionListener(
        evt -> board_panel.board_handling.start_polygonshape_item(
            board_panel.right_button_click_location));

    create_obstacle_menu.add(create_polygon_item);

    JMenuItem add_hole_item = new JMenuItem();
    add_hole_item.setText(resources.getString("hole"));
    add_hole_item.addActionListener(
        evt -> board_panel.board_handling.start_adding_hole(board_panel.right_button_click_location));

    create_obstacle_menu.add(add_hole_item);

    this.add(create_obstacle_menu, 2);

    // Insert the pin swap item.

    if (board_panel.board_handling.get_routing_board().library.logical_parts.count() > 0) {
      // the board contains swappable gates or pins
      JMenuItem swap_pin_item = new JMenuItem();
      swap_pin_item.setText(resources.getString("swap_pin"));
      swap_pin_item.addActionListener(
          evt -> board_panel.board_handling.swap_pin(board_panel.right_button_click_location));

      this.add(swap_pin_item, 3);
    }
  }
}
