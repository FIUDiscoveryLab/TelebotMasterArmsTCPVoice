package discoverylab.telebot.master.arms;

import static discoverylab.util.logging.LogUtils.*;
import discoverylab.telebot.master.arms.configurations.MasterArmsVoiceConfig;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPVoiceController.DataListener;

import com.rti.dds.infrastructure.InstanceHandle_t;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArmsDataWriter;
import discoverylab.telebot.master.core.component.CoreMasterTCPComponent;
import discoverylab.telebot.master.core.socket.CoreServerSocket;


public class TelebotMasterArmsTCPVoiceComponent extends CoreMasterTCPComponent implements CoreServerSocket.SocketEventListener{
	
	public static String TAG = makeLogTag(TelebotMasterArmsTCPVoiceComponent.class);
	
	private int defaultSpeed = 100;
	private TMasterToArmsDataWriter writer;
	private DataListener listener;
	TMasterToArms instance = new TMasterToArms();
	InstanceHandle_t instance_handle = InstanceHandle_t.HANDLE_NIL;
	
	public TelebotMasterArmsTCPVoiceComponent(DataListener listener, int portNumber) {
		super(portNumber);
		this.listener = listener;
	}
	
	/**
	 * Cast the Writer to our Arms DataWriter
	 * This allows us to publish the appropriate Topic data
	 */
	public void initiateDataWriter(){
		writer = (TMasterToArmsDataWriter) getDataWriter();
	}
	
	public String writeServoData(int servoID, int servoPosition, int servoSpeed)
	{
		instance.servoId = servoID;
		instance.servoPositon = servoPosition;
		instance.servoSpeed = servoSpeed;
		writer.write(instance, instance_handle);
		String data = instance.servoId + " " + instance.servoPositon + " " + instance.servoSpeed;
		
		return data;
	}
	
	public void generatePositions(String command)
	{
		String data;
		
		if(command.equals("ST"))
		{
			data = writeServoData(10, MasterArmsVoiceConfig.STOP_SERVO_10, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(11, MasterArmsVoiceConfig.STOP_SERVO_11, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(20, MasterArmsVoiceConfig.STOP_LEFT_SERVO_20, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(21, MasterArmsVoiceConfig.STOP_LEFT_SERVO_21, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(22, MasterArmsVoiceConfig.STOP_LEFT_SERVO_22, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(23, MasterArmsVoiceConfig.STOP_LEFT_SERVO_23, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(24, MasterArmsVoiceConfig.STOP_LEFT_SERVO_24, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(25, MasterArmsVoiceConfig.STOP_LEFT_SERVO_25, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(30, MasterArmsVoiceConfig.STOP_RIGHT_SERVO_30, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(31, MasterArmsVoiceConfig.STOP_RIGHT_SERVO_31, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(32, MasterArmsVoiceConfig.STOP_RIGHT_SERVO_32, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(33, MasterArmsVoiceConfig.STOP_RIGHT_SERVO_33, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(34, MasterArmsVoiceConfig.STOP_RIGHT_SERVO_34, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(35, MasterArmsVoiceConfig.STOP_RIGHT_SERVO_35, defaultSpeed);
			LOGI(TAG, data);
		}
		else if(command.equals("SH"))
		{
			data = writeServoData(10, MasterArmsVoiceConfig.SHIELD_SERVO_10, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(11, MasterArmsVoiceConfig.SHIELD_SERVO_11, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(20, MasterArmsVoiceConfig.SHIELD_LEFT_SERVO_20, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(21, MasterArmsVoiceConfig.SHIELD_LEFT_SERVO_21, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(22, MasterArmsVoiceConfig.SHIELD_LEFT_SERVO_22, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(23, MasterArmsVoiceConfig.SHIELD_LEFT_SERVO_23, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(24, MasterArmsVoiceConfig.SHIELD_LEFT_SERVO_24, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(25, MasterArmsVoiceConfig.SHIELD_LEFT_SERVO_25, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(30, MasterArmsVoiceConfig.SHIELD_RIGHT_SERVO_30, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(31, MasterArmsVoiceConfig.SHIELD_RIGHT_SERVO_31, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(32, MasterArmsVoiceConfig.SHIELD_RIGHT_SERVO_32, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(33, MasterArmsVoiceConfig.SHIELD_RIGHT_SERVO_33, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(34, MasterArmsVoiceConfig.SHIELD_RIGHT_SERVO_34, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(35, MasterArmsVoiceConfig.SHIELD_RIGHT_SERVO_35, defaultSpeed);
			LOGI(TAG, data);
		}
		else if(command.equals("RT"))
		{
			data = writeServoData(10, MasterArmsVoiceConfig.REST_SERVO_10, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(11, MasterArmsVoiceConfig.REST_SERVO_11, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(20, MasterArmsVoiceConfig.REST_LEFT_SERVO_20, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(21, MasterArmsVoiceConfig.REST_LEFT_SERVO_21, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(22, MasterArmsVoiceConfig.REST_LEFT_SERVO_22, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(23, MasterArmsVoiceConfig.REST_LEFT_SERVO_23, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(24, MasterArmsVoiceConfig.REST_LEFT_SERVO_24, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(25, MasterArmsVoiceConfig.REST_LEFT_SERVO_25, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(30, MasterArmsVoiceConfig.REST_RIGHT_SERVO_30, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(31, MasterArmsVoiceConfig.REST_RIGHT_SERVO_31, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(32, MasterArmsVoiceConfig.REST_RIGHT_SERVO_32, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(33, MasterArmsVoiceConfig.REST_RIGHT_SERVO_33, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(34, MasterArmsVoiceConfig.REST_RIGHT_SERVO_34, defaultSpeed);
			LOGI(TAG, data);
			
			data = writeServoData(35, MasterArmsVoiceConfig.REST_RIGHT_SERVO_35, defaultSpeed);
			LOGI(TAG, data);	
		}
	}
	
	@Override
	public synchronized void callback(String data) { //try synchronized
		
		LOGI(TAG, "DATA: " + data );
		listener.changeText(data);
		generatePositions(data);
	}

	/**
	 * CallbackInterface
	 * @author Irvin Steve Cardenas
	 * 
	 * Callback interface to retrieve parsed Data Object
	 * Purpose: GUI or other components can implement this to receive a  YEIDataModel object object
	 *
	 */
	public interface CallbackInterface{
		public void callback(String data);
	}
}
