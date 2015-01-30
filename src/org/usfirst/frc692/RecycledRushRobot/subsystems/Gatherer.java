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
public class Gatherer extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid gathererInOutPiston = RobotMap.gatherergathererInOutPiston;
    DoubleSolenoid gathererUpDownPiston = RobotMap.gatherergathererUpDownPiston;
    DigitalInput gathererDeployedLimit = RobotMap.gatherergathererDeployedLimit;
    DigitalInput gathererToteDetectionLimit = RobotMap.gatherergathererToteDetectionLimit;
    DigitalInput gathererRetractedLimit = RobotMap.gatherergathererRetractedLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void gathererPistonOut()
    {
    	gathererInOutPiston.set(Value.kForward);
    }
    // sets solenoid value to forward so that air is relayed forward by the solenoid
    // causes gatherer to extend out
    // AC 1/12/15
    
    public void gathererPistonIn()
    {
    	gathererInOutPiston.set(Value.kReverse);
    }
    // sets solenoid value to reverse so that air is relayed reverse by the solenoid 
    // causes gatherer to retract in
    // AC 1/12/15
    
    public void gathererPistonDown()
    {
    	gathererUpDownPiston.set(Value.kForward);
    }
    // causes gatherer to go down 
    // AC 1/12/15
    
    public void gathererPistonUp()
    {
    	gathererUpDownPiston.set(Value.kReverse);
    }
    // causes gatherer to go up 
    // AC 1/12/15
    
    public boolean gathererDeployed()
    {
    	if (gathererDeployedLimit.get() == false)
    		return true;
    	else
    		return false;
    }
    // check to see if limit switch is not pressed
    // when not pressed, it will return true
    // when activated gatherer is in gathering position
    // EV 1/15/2015
    
    public boolean toteDetector()
    {
    	if (gathererToteDetectionLimit.get() == true)
    		return true;
    	else
    		return false;
    }
    // check to see if limit switch is pressed
    // when it is pressed, return true
    // tote is prepared to be lifted
    // stops conveyer belt movement
    // ND 1/15/2015
    
    public boolean isGathererReadyToRetract()
    {
    	if(gathererRetractedLimit.get() == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    // checks to see if gatherer is all the way out so it is ready to retract
    // when pressed it returns true
    // elevator should not run when this is activated 
    // tote should be dropped when pressed??
    //also activates caterpillar to take in tote
    // AC 1/15/15
    
}

