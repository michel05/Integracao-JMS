package br.com.hojeti.Integracao;

import java.net.URL;
import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.apache.activemq.util.Handler;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AplicationController implements Initializable {

	@FXML
	private TextArea logSincronizacao;
	@FXML
	private Button initSincronizacao;

	public void initialize(URL url, ResourceBundle bundle) {
		initSincronizacao.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					iniciarSincronizacao();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void iniciarSincronizacao() throws Exception {

//		Thread thread = new Thread() {
//			public void run() {
				try {

					InitialContext context = new InitialContext();
					ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

					Connection connection = factory.createConnection();
					connection.start();
					Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

					Destination fila = (Destination) context.lookup("sincronizacao");
					MessageConsumer consumer = session.createConsumer(fila);


					consumer.setMessageListener(new MessageListener() {

						public void onMessage(Message message) {

							TextMessage textMessage = (TextMessage) message;

							try {
								logSincronizacao.appendText("\n " + textMessage.getText());
							} catch (JMSException e1) {
								e1.printStackTrace();
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
//		};
//
//		thread.start();
//	}

}
