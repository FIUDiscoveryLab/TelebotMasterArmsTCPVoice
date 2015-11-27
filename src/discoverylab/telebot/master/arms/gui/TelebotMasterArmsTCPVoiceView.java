package discoverylab.telebot.master.arms.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelebotMasterArmsTCPVoiceView extends JFrame
{
	private JLabel portLabel = new JLabel("Port: ");
	private JTextField port = new JTextField("6666");
	private JButton connect = new JButton("Connect");
	private JLabel commandLabel = new JLabel("Command Given: ");
	private JLabel command = new JLabel("None");
	private JLabel commandCountLabel = new JLabel("Number of Commands: ");
	private JLabel commandNumber = new JLabel("0");
	
	public TelebotMasterArmsTCPVoiceView()
	{
		JPanel viewPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 150);
		
		viewPanel.add(portLabel);
		viewPanel.add(port);
		viewPanel.add(connect);
		viewPanel.add(commandLabel);
		viewPanel.add(command);
		viewPanel.add(commandCountLabel);
		viewPanel.add(commandNumber);
		
		this.add(viewPanel);
	}
	
	public int getPortNumber()
	{
		return Integer.parseInt(port.getText());
	}
	
	public void setPortNumber(int portNumber)
	{
		port.setText(Integer.toString(portNumber));
	}
	
//	public void setConnectButton(boolean isConnected)
//	{
//		if(isConnected)
//		{
//			connect.setText("Disconnect");
//		}
//		else
//		{
//			connect.setText("Connect");
//		}
//	}
	
	public void setCommandCount(int commandCount)
	{
		commandNumber.setText(Integer.toString(commandCount));
	}
	
	public void setCommand(String commandText)
	{
		command.setText(commandText);
	}
		
	void addConnectListener(ActionListener e)
	{
		connect.addActionListener(e);
	}
	
	void displayErrorMessage(String error)
	{
		JOptionPane.showMessageDialog(this, error);
	}
}
