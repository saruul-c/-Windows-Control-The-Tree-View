module org.example.tree_view {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.tree_view to javafx.fxml;
    exports org.example.tree_view;
}