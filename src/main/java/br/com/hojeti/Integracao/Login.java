package br.com.hojeti.Integracao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

	private static Stage stage;
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
		
		Login.stage = stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void fecharAplicacao() {
		System.exit(0);
	}

	public static Stage getStage() {
		return stage;
	}

}
