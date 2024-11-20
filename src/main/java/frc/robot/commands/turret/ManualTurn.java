package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.turret.TurretSubsystem;

public class ManualTurn extends Command {
  private TurretSubsystem turretSubsystem;
  private double speed;

  public ManualTurn(TurretSubsystem turretSubsystem, double speed) {
    this.turretSubsystem = turretSubsystem;
    this.speed = speed; 
    
    addRequirements(this.turretSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    this.turretSubsystem.setMotor(speed);

  }

  @Override
  public void end(boolean interrupted) {
    this.turretSubsystem.stopMotor();
  }
}
