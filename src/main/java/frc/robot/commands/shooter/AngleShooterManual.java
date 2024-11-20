package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.ShooterAngleSubsystem;

public class AngleShooterManual extends Command {
   private ShooterAngleSubsystem shooterAngleSubsystem;
  private double speed;

  public AngleShooterManual(ShooterAngleSubsystem shooterAngleSubsystem, double speed) {
    this.shooterAngleSubsystem = shooterAngleSubsystem;
    this.speed = speed; 
    
    addRequirements(this.shooterAngleSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    this.shooterAngleSubsystem.setMotor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    this.shooterAngleSubsystem.stopMotor();
  }
}

