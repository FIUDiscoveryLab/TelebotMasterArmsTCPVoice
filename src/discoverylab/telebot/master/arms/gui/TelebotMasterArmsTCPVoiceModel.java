package discoverylab.telebot.master.arms.gui;

public class TelebotMasterArmsTCPVoiceModel 
{
	private int portNumber = 6666;
	private int commandCount = 0;
	private String command = "none";
	private boolean isConnected = false;
	private boolean portFlag = false;
	
	public int getPortNumber()
	{
		return portNumber;
	}
	
	public void setPortNumberFlag(boolean flag)
	{
		portFlag = flag;
	}
	
	public boolean getPortNumberFlag()
	{
		return portFlag;
	}
	
	public boolean getConnectionStatus()
	{
		return isConnected;
	}
	
	public void setConnectionStatus(boolean isConnected)
	{
		this.isConnected = isConnected;
	}
	
	public void setPortNumber(int portNumber)
	{
		this.portNumber = portNumber;
	}
	
	public String getCommand()
	{
		return command;
	}
	
	public void setCommand(String command)
	{
		this.command = command;
	}
	
	public int getCommandCount()
	{
		return commandCount;
	}
	
	public void setCommandCount()
	{
		commandCount++;
	}
}
