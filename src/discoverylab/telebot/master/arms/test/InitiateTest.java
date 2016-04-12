package discoverylab.telebot.master.arms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import discoverylab.telebot.master.arms.TelebotMasterArmsTCPVoiceComponent;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPVoiceController;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPVoiceView;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPVoiceController.DataListener;

public class InitiateTest {

	@Test
	public void testInitiate() 
	{
		TelebotMasterArmsTCPVoiceView view = new TelebotMasterArmsTCPVoiceView();
		TelebotMasterArmsTCPVoiceController controller = new TelebotMasterArmsTCPVoiceController(view);
		
		DataListener listener = controller.new DataListener();
		
		int portNumber = 6666;
		TelebotMasterArmsTCPVoiceComponent telebotMasterArms = new TelebotMasterArmsTCPVoiceComponent(listener, portNumber);
		
		telebotMasterArms.initiate();
		boolean serverLaunched = telebotMasterArms.serverLaunched();
		
		assertEquals(true, serverLaunched);
		System.out.println("Tested initiate()");

	}

}
