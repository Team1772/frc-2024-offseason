package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class Shoot extends Command {
   private ShooterSubsystem shooterSubsystem;
  private double speed;

  public Shoot(ShooterSubsystem shooterSubsystem, double speed) {
    this.shooterSubsystem = shooterSubsystem;
    this.speed = speed; 
    
    addRequirements(this.shooterSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    this.shooterSubsystem.setMotors(speed);

  }

  @Override
  public void end(boolean interrupted) {
    this.shooterSubsystem.stopMotors();
  }
}
