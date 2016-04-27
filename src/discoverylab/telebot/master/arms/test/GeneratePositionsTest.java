package discoverylab.telebot.master.arms.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static discoverylab.util.logging.LogUtils.*;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;
import discoverylab.telebot.master.arms.TelebotMasterArmsTCPVoiceComponent;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPVoiceController.DataListener;

public class GeneratePositionsTest {
	public static String TAG = makeLogTag(GeneratePositionsTest.class);
	
	private DataListener listener;
	int portNumber = 6666;
	
	TelebotMasterArmsTCPVoiceComponent telebotMasterArms = new TelebotMasterArmsTCPVoiceComponent(listener, portNumber);
	
	@Before
	public void setUp()
	{
		telebotMasterArms.initiate();
		telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE, TMasterToArms.class);
		telebotMasterArms.initiateDataWriter();
	}

	@Test
	public void generatePositionsTest() {

		String commandSH = "SH";
		
		LOGI(TAG, "Shield: ");
		telebotMasterArms.generatePositions(commandSH);
		LOGI(TAG, "Tested generatePositions with Shield Command\n");
		
		String commandST = "ST";

		LOGI(TAG, "Stop: ");
		telebotMasterArms.generatePositions(commandST);
		LOGI(TAG, "Tested generatePositions with Stop Command\n");
		
		String commandRT = "RT";

		LOGI(TAG, "Rest: ");
		telebotMasterArms.generatePositions(commandRT);
		LOGI(TAG, "Tested generatePositions with Rest Command\n");
	}

}
