package org.example.tree_view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TreeItem<String> rootItem = new TreeItem<>("Root");
        rootItem.setExpanded(true);

        createTreeItem(rootItem, "Microsoft", "/icons/1.png");
        createTreeItem(rootItem, "Borland", "/icons/2.png");
        createTreeItem(rootItem, "Novell", "/icons/3.png");
        createTreeItem(rootItem, "Corel", "/icons/4.png");

        TreeView<String> treeView = new TreeView<>(rootItem);

        Dialog<Void> dialog = new Dialog<>();
        dialog.getDialogPane().setContent(treeView);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();

        stage.setScene(new Scene(new StackPane(treeView), 400, 300));
        stage.setTitle("Tree View Example");
        stage.show();
    }

        private void createTreeItem(TreeItem<String> rootItem, String label, String imagePath) {
            TreeItem<String> item = new TreeItem<>(label);
            // Load the image and create an ImageView
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(16); // Adjust the size of the image as needed
            imageView.setFitHeight(16);
            item.setGraphic(imageView);

            rootItem.getChildren().add(item);

    }

    public static void main(String[] args) {
        launch();
    }
}