package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeEaterSubsystem;

public class IntakeEatsNoteComand extends Command {

    private final IntakeEaterSubsystem intakeEaterSubsystem;

    public 
    IntakeEatsNoteComand(IntakeEaterSubsystem intakeEaterSubsystem) {
        this.intakeEaterSubsystem = intakeEaterSubsystem;
        addRequirements(intakeEaterSubsystem);
    }

    @Override
    public void initialize(){
        intakeEaterSubsystem.setMotors(0);
    }

    @Override
    public void execute(){
        intakeEaterSubsystem.setMotors(50);
    }

    @Override
    public void end(boolean interrupted){
        intakeEaterSubsystem.setMotors(0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }


}



