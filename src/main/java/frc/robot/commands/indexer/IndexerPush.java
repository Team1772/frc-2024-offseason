package frc.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.indexer.IndexerSubsystem;

public class IndexerPush extends Command {
    private final IndexerSubsystem indexerSubsystem;

    public IndexerPush(IndexerSubsystem indexerSubsystem) {
        this.indexerSubsystem = indexerSubsystem;
        addRequirements(indexerSubsystem);
    }
    
@Override
public void initialize() {
}

@Override
public void execute() {
    indexerSubsystem.setMotor(-0.6);
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
