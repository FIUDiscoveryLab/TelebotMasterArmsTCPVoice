package discoverylab.telebot.master.arms.gui;

import java.awt.event.ActionListener;

import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;

import java.awt.event.ActionEvent;

import discoverylab.telebot.master.arms.TelebotMasterArmsTCPVoiceComponent;
import discoverylab.telebot.master.core.socket.CoreServerSocket;




public class TelebotMasterArmsTCPVoiceController
{
	private TelebotMasterArmsTCPVoiceView view;
	private TelebotMasterArmsTCPVoiceComponent telebotMasterArms;
	
	public TelebotMasterArmsTCPVoiceController(TelebotMasterArmsTCPVoiceView view)
	{
		this.view = view;
		this.view.addConnectListener(new ConnectListener());
	}
	
	public class DataListener
	{
		public void changeText(String data)
		{
			String command = data;
			view.setCommandText(command);
		}
	}
	
	class ConnectListener implements ActionListener
	{	
		DataListener listener = new DataListener();
		
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				int portNumber = view.getPortNumber();
				
				telebotMasterArms = new TelebotMasterArmsTCPVoiceComponent(listener, portNumber);

				// 1. INITIATE Slave Component DEVICE
				telebotMasterArms.initiate();
					
				// 2. INITIATE Transmission PROTOCOL
				telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
											, TMasterToArms.class);
									
				// 3. INITIATE DataWriter
				telebotMasterArms.initiateDataWriter();	
			}
			catch(NumberFormatException exception)
			{
				view.displayErrorMessage("Please enter a valid port number.");
			}
		}
	}
	
}
