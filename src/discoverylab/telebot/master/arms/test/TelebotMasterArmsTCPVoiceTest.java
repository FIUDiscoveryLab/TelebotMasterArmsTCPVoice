package discoverylab.telebot.master.arms.test;

import discoverylab.telebot.master.arms.gui.*;
import static discoverylab.util.logging.LogUtils.*;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;
import discoverylab.telebot.master.arms.TelebotMasterArmsTCPVoiceComponent;

public class TelebotMasterArmsTCPVoiceTest {

	public static String TAG = makeLogTag("TelebotMasterArmsTCPVoiceTest");
	
	public static void main(String args []) {
		
		TelebotMasterArmsTCPVoiceView view = new TelebotMasterArmsTCPVoiceView();

		TelebotMasterArmsTCPVoiceController controller = new TelebotMasterArmsTCPVoiceController(view);
		
		view.setVisible(true);

	}
}
