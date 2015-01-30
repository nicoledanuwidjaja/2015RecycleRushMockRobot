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
public class  winchAtFourTotes extends Command {

    public winchAtFourTotes() {
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
    	while(Robot.recycleBinClaw.getRawCount() > 240)
    	{
    		Robot.recycleBinClaw.winchDown();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.recycleBinClaw.getRawCount() == 240)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    // Called once after isFinished returns true
    protected void end() {
    	Robot.recycleBinClaw.winchStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	while(Robot.recycleBinClaw.getRawCount() != 240)
    	{
    		Robot.recycleBinClaw.winchDown();
    	}
    	/*
    	 * winch goes down 
    	 * when interrupted it goes down until it gets to intended floor
    	 * AC 1/24/15
    	 */
    }
}
