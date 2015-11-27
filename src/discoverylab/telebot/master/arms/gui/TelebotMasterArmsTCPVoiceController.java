package discoverylab.telebot.master.arms.gui;

import java.awt.event.ActionListener;

import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;

import java.awt.event.ActionEvent;

import discoverylab.telebot.master.arms.TelebotMasterArmsTCPVoiceComponent;


public class TelebotMasterArmsTCPVoiceController 
{
	private TelebotMasterArmsTCPVoiceView view;
	private TelebotMasterArmsTCPVoiceModel model;
	private TelebotMasterArmsTCPVoiceComponent telebotMasterArms;
	
	public TelebotMasterArmsTCPVoiceController(TelebotMasterArmsTCPVoiceView view, 
			TelebotMasterArmsTCPVoiceModel model)
	{
		this.view = view;
		this.model = model;
		
		this.view.addConnectListener(new ConnectListener());
	}
	
	class ConnectListener implements ActionListener
	{
		boolean portFlag = false;
		
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				int portNumber = view.getPortNumber();
				
				telebotMasterArms = new TelebotMasterArmsTCPVoiceComponent(portNumber);

				// 1. INITIATE Slave Component DEVICE
				telebotMasterArms.initiate();
					
				// 2. INITIATE Transmission PROTOCOL
				telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
											, TMasterToArms.class);
									
				// 3. INITIATE DataWriter
				telebotMasterArms.initiateDataWriter();	
				
//				model.setPortNumber(portNumber);
//				model.setPortNumberFlag(true);
//				view.setCommand(telebotMasterArms.getCommand());
//				view.setCommandCount(telebotMasterArms.getCommandCount());

			}
			catch(NumberFormatException exception)
			{
				view.displayErrorMessage("Please enter a valid port number.");
			}
		}
	}
	
}
