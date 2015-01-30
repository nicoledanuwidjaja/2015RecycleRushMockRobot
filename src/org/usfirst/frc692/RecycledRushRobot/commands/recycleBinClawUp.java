// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc692.RecycledRushRobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc692.RecycledRushRobot.Robot;

/**
 *
 */
public class  recycleBinClawUp extends Command {

    public recycleBinClawUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.recycleBinClaw);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	 * for now default value for top is 390
    	 * not sure if this works
    	 * copied from 1678 code no github
    	 * AC 1/17/15
    	 */
    	if(Robot.recycleBinClaw.getRawCount() < 390)
    	{
    		Robot.recycleBinClaw.winchUp();
    	}
    	else
    	{
    		Robot.recycleBinClaw.winchStop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       if(Robot.recycleBinClaw.getRawCount() == 0.0)
       {
    	   return true;
       }
       else 
       {
    	   return false;
       }
    }
    // if recycle bin claw is on top level, then command stops
    // ND 1/17/15

    // Called once after isFinished returns true
    protected void end() {
    	Robot.recycleBinClaw.winchStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//NEEDS AN INTERRUPT!
    }
    //goes all the way up (robot claw)
    //top default is 100 until we start testing
    //AC 1/17/15
}
