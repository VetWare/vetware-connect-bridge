package com.fifthgen.prahranvet.vetwarebridge.ui;

import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PreloadController extends Preloader {
	private Stage preloaderStage;
	private Scene scene;

	public PreloadController() {
	}

	@Override
	public void init() throws Exception {
		System.out.println("before load");
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("fxml/Preload.fxml")) ;
		System.out.println("after load1");

        Parent root1 = loader2.load();
        System.out.println("after load2");
		scene = new Scene(root1);
        System.out.println("after load3");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.preloaderStage = primaryStage;
		preloaderStage.setScene(scene);
		preloaderStage.initStyle(StageStyle.UNDECORATED);
		preloaderStage.show();
	}

	@Override
	public void handleApplicationNotification(PreloaderNotification preloaderNotificiation) {
	    if (preloaderNotificiation instanceof ProgressNotification) {
	    	//FXMLDocumentController.label.setText("");
	    }
	}

	@Override
	public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
		if (stateChangeNotification.getType() == Type.BEFORE_START) {
			preloaderStage.hide();
		}
	}
	public void unpage() {
			preloaderStage.hide();
	}

}
