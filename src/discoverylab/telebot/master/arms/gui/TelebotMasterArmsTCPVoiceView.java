package discoverylab.telebot.master.arms.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelebotMasterArmsTCPVoiceView extends JFrame
{
	private JLabel labelPort = new JLabel("Port: ");
	private JTextField textPort = new JTextField("6666");
	private JButton buttonConnect = new JButton("Connect");
	
	private JLabel labelCommand = new JLabel("Command Given: ");
	private JTextField textCommand  = new JTextField("None");
	
	public TelebotMasterArmsTCPVoiceView()
	{
		JPanel viewPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 150);
		
		viewPanel.add(labelPort);
		viewPanel.add(textPort);
		viewPanel.add(buttonConnect);
		
		viewPanel.add(labelCommand);
		viewPanel.add(textCommand);
		 
		this.add(viewPanel);
	}
	
	public int getPortNumber()
	{
		return Integer.parseInt(textPort.getText());
	}
	
	public void setPortNumber(int portNumber)
	{
		textPort.setText(Integer.toString(portNumber));
	}
	
	public String getCommandText()
	{
		return textCommand.getText();
	}
	
	public void setCommandText(String command)
	{
		textCommand.setText(command);
	}
		
	void addConnectListener(ActionListener e)
	{
		buttonConnect.addActionListener(e);
	}
	
	void displayErrorMessage(String error)
	{
		JOptionPane.showMessageDialog(this, error);
	}
}
