package frc.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.indexer.IndexerSubsystem;
import frc.robot.subsystems.intake.IntakeJointSubsystem;

public class IndexerPull extends Command {

    private final IndexerSubsystem indexerSubsystem;

    public IndexerPull(IndexerSubsystem indexerSubsystem) {
        this.indexerSubsystem = indexerSubsystem;
        addRequirements(indexerSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        indexerSubsystem.setMotor(0.6);
    }

    @Override
    public void end(boolean interrupted) {
        indexerSubsystem.stopMotor();
    
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
