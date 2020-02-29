//Richmond Code
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  private Joystick m_Stick;
  private Joystick TwoJstick;
  private static final int LeftDeviceMasterID = 5; //Masters: 6 and 8
  private static final int LeftDeviceFollowerID= 3;
  private static final int RightDeviceMasterID = 4;
  private static final int RightDeviceFollowerID=2;
  private static final int IntakeID=1;
  private static final int RampRollerID=10;
  private static int statetracker=0;

  private CANSparkMax m_LeftMotorMaster;
  private CANSparkMax m_LeftMotorFollower;
  private CANSparkMax m_RightMotorMaster;
  private CANSparkMax m_RightMotorFollower;
  private CANSparkMax m_Intake;
  private TalonFX m_RampRoller;
  @Override
  public void robotInit() {
  /**
   * SPARK MAX controllers are intialized over CAN by constructing a CANSparkMax object
   * 
   * The CAN ID, which can be configured using the SPARK MAX Client, is passed as the
   * first parameter
   * 
   * The motor type is passed as the second parameter. Motor type can either be:
   *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless
   *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushed
   * 
   * The example below initializes four brushless motors with CAN IDs 1 and 2. Change
   * these parameters to match your setup
   */

    m_RampRoller= new TalonFX(RampRollerID);

    m_LeftMotorMaster = new CANSparkMax(LeftDeviceMasterID, MotorType.kBrushless);
    m_LeftMotorFollower = new CANSparkMax(LeftDeviceFollowerID, MotorType.kBrushless);
    m_RightMotorMaster = new CANSparkMax(RightDeviceMasterID, MotorType.kBrushless);
    m_RightMotorFollower = new CANSparkMax(RightDeviceFollowerID, MotorType.kBrushless);
    m_Intake= new CANSparkMax(IntakeID, MotorType.kBrushless);
    m_RightMotorMaster.restoreFactoryDefaults();
    m_LeftMotorMaster.restoreFactoryDefaults();
    m_Intake.restoreFactoryDefaults();
    m_RightMotorFollower.follow(m_RightMotorMaster);
    m_LeftMotorFollower.follow(m_LeftMotorMaster);
    m_RightMotorMaster.setInverted(true);

    

    
    //m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);

   
    

    
    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
  
    
    

    
    //m_rightMotor.restoreFactoryDefaults();

    //m_myRobot = new DifferentialDrive(m_Motor, m_rightMotor);

    
    TwoJstick= new Joystick(0);
    m_Stick = new Joystick(1);
    //m_RightStick = 

  }
  
  @Override
  public void teleopPeriodic() {
    //m_myRobot.tankDrive(m_Stick.getY(), m_rightStick.getY());

    //double rightPower = m_Stick.getRawAxis(1) - m_Stick.getRawAxis(0); //1-y axis 0-x axis
    //double leftPower = m_Stick.getRawAxis(1) + m_Stick.getRawAxis(0);
    //m_LeftMotorMaster.set(leftPower*0.5);
    //m_RightMotorMaster.set(rightPower*0.5);
    //Read the y axis on the left joystick
    double leftpower = TwoJstick.getRawAxis(1);  //<-- Experiment to find the exact //axis value //Read the y axis on the right joystick
    double rightpower = TwoJstick.getRawAxis(5); // <-- find the right axis number
    double intakePower= m_Stick.getRawAxis(1);
    m_LeftMotorMaster.set(-leftpower);
    m_RightMotorMaster.set(-rightpower); 
    m_Intake.set(-intakePower*0.5);
    //m_RampRoller.set(ControlMode.PercentOutput, intakePower);
    /*if(m_Stick.getRawButton(6)){
      m_Intake.set(-0.1);
    }
    else if(!m_Stick.getRawButton(6)){
      m_Intake.stopMotor();
    }
    else if(m_Stick.getRawButton(4)){
      m_Intake.set(0.1);
    }*/

    //this works but it was rejected since the Falcon motor was not operational :(
    /*if(m_Stick.getRawButtonPressed(6)){
      m_Intake.stopMotor();
      m_Intake.set(0.2);
    }
    if(m_Stick.getRawButtonPressed(4)){
      m_Intake.stopMotor();
      m_Intake.set(-0.2);
    }
    if(m_Stick.getRawButton(3)){
      m_Intake.stopMotor();
    }*/
    

    /*
    if(m_Stick.getRawButtonPressed(1)){ //Checks if pressed since last time
      statetracker++;
      statetracker=statetracker%2;
      if(statetracker == 1){
        m_RampRoller.set(ControlMode.PercentOutput, 0.1); //Percent Output sets it as between -1 and 1
        
        //m_Intake.set(0.05);
      }
      else{
        m_RampRoller.set(ControlMode.PercentOutput, 0);
        //m_Intake.stopMotor();
      }
    
    }*/




    //if(TwoJstick.get)
    //if(m_Stick.getRawButton(1)){
      //statetracker += 1;
      //statetracker = statetracker % 2;
      //if(statetracker==1){
        //m_Intake.set(-0.05);
      //}
      //else{
        //m_Intake.stopMotor();
      //}
    //}

  }
}








     
  
    