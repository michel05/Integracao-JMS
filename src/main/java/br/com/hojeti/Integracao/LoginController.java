package br.com.hojeti.Integracao;

import java.net.URL;
import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField txLogin;
	@FXML
	private PasswordField txSenha;
	@FXML
	private Button btEntrar, btSair;

	public void initialize(URL url, ResourceBundle bundle) {
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (txLogin.getText().equals("1") && txSenha.getText().equals("1")) {
					try {
						new Aplication().start(new Stage());
						Login.getStage().close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				System.out.println("logar");
			}
		});
		btSair.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// TODO sair da aplicação
			}
		});
	}


}
