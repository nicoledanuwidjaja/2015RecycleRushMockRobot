// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc692.RecycledRushRobot.subsystems;

import org.usfirst.frc692.RecycledRushRobot.RobotMap;
import org.usfirst.frc692.RecycledRushRobot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Elevator extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput elevatorLevelTopLoadLimit = RobotMap.elevatorelevatorLevelTopLoadLimit;
    DigitalInput elevatorLevelStepLimit = RobotMap.elevatorelevatorLevelStepLimit;
    DigitalInput elevatorLevelGroundLimit = RobotMap.elevatorelevatorLevelGroundLimit;
    DoubleSolenoid flapperRelease = RobotMap.elevatorflapperRelease;
    DoubleSolenoid backstopRelease = RobotMap.elevatorbackstopRelease;
    SpeedController elevatorPlatformUpDownMotor = RobotMap.elevatorelevatorPlatformUpDownMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    private static final int movingUp = 1;
    private static final int movingDown = -1;
    private static final int donePosition = 0;
    //these are constants to state that the elevator is moving in Up/Down direction 
    //AC 1/19/15
    
    private int elevatorState;
    //variable that is set to a constant to tell state
    //AC 1/19/15
    
    public void setElevatorMovingUp()
    {
    	elevatorState = movingUp;
    }
    //elevator is moving up
    //AC 1/19/15
    
    public void setElevatorMovingDown()
    {
    	elevatorState = movingDown;
    }
    //elevator is moving down
    //AC 1/19/15
    
    public void setDonePosition()
    {
    	elevatorState = donePosition;
    }

    //elevator is at done position
    //done position is intended floor
    //AC 1/19/15
    
    public boolean isMovingUp()
    {
    	if(elevatorState == 1)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    //boolean to check if elevator is moving up 
    //true = up 
    //AC 1/19/15
    
    public boolean isMovingDown()
    {
    	if (elevatorState == -1)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    //boolean to check if elevator is moving down
    //true = down
    //AC 1/19/15
    
    public void releaseFlap()
    {
    	flapperRelease.set(Value.kForward);
    }
    // causes flapper to release totes
    // EV 1/15/2015
    
    public void backstopUp()
    {
    	backstopRelease.set(Value.kForward);
    }
    // causes backstop to go up
    // ND 1/15/2015
    
    public void backstopDown()
    {
    	backstopRelease.set(Value.kReverse);
    }
    // causes backstop to go down
    // ND 1/15/2015
    
    public boolean onGroundFloor()
    {
    	if(elevatorLevelGroundLimit.get() == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    //returns true when pressed
    //indicates whether platform is on ground level
    //when pressed elevator stops
    //AC 1/15/15
    
    public boolean onStepLevel()
    {
    	if(elevatorLevelStepLimit.get() == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    //returns true when pressed
    //indicates whether platform is on step level
    //when pressed elevator stops
    //AC 1/16/15
    
    public boolean onTopLoadLevel()
    {
    	if(elevatorLevelStepLimit.get() == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    //returns true when pressed
    //when pressed elevator stops
    //indicates whether platform is on topLoad level
    //AC 1/16/15
    
    public void elevatorUp()
    {
    	elevatorPlatformUpDownMotor.set(1.0);
    }
    //elevator goes up when called at 100% speed
    //AC 1/16/15
    
    public void elevatorDown()
    {
    	elevatorPlatformUpDownMotor.set(-1.0);
    }
    //elevator platform goes down at 100% speed
    //AC 1/16/15
    
    public void elevatorStop()
    {
    	elevatorPlatformUpDownMotor.set(0.0);
    }
    //elevator platform stops
    //AC 1/16/15
    
    /*
     * Elevator Steps(Top --> Bottom):
     * Top Load
     * Step
     * Ground
     * AC 1/16/15
     */
    
    public void takeJoystickValue(double x)
    {
    	elevatorPlatformUpDownMotor.set(x);
    }
    //takes value from joystick and inputs in elevator motor\
    //AC 1/24/15  
}

