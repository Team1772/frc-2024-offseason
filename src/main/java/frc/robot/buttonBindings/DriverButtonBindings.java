package frc.robot.buttonBindings;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.core.util.oi.SmartController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.swervedrive.drivebase.AbsoluteDriveAdv;
import frc.robot.constants.ControllerConstants;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class DriverButtonBindings {

  private final SwerveSubsystem drivetrain;
  public static SmartController driver;

  public DriverButtonBindings(SwerveSubsystem drivetrain) {
    this.drivetrain = drivetrain;
    DriverButtonBindings.driver = new SmartController(ControllerConstants.kDriverControllerPort);

    this.buttonBindingsDrivetain();
  }

  public void buttonBindingsDrivetain() {
    drivetrain.setDefaultCommand(
        !RobotBase.isSimulation() ? driveFieldOrientedAnglularVelocity() : driveFieldOrientedDirectAngleSim());
  }

  private Command driveFieldOrientedAnglularVelocity() {
    return drivetrain.driveCommand(
        () -> -MathUtil.applyDeadband((driver.getLeftY() * 0.8), OperatorConstants.LEFT_Y_DEADBAND),
        () -> -MathUtil.applyDeadband((driver.getLeftX() * 0.8), OperatorConstants.LEFT_X_DEADBAND),
        () -> -driver.getRightX() * 0.8);
  }

  private AbsoluteDriveAdv closedAbsoluteDriveAdv() {
    return new AbsoluteDriveAdv(drivetrain,
        () -> -MathUtil.applyDeadband(driver.getLeftY(),
            OperatorConstants.LEFT_Y_DEADBAND),
        () -> -MathUtil.applyDeadband(driver.getLeftX(),
            OperatorConstants.LEFT_X_DEADBAND),
        () -> -MathUtil.applyDeadband(driver.getRightX(),
            OperatorConstants.RIGHT_X_DEADBAND),
        driver.getYButton(),
        driver.getAButton(),
        driver.getXButton(),
        driver.getBButton());
  }

  private Command driveFieldOrientedDirectAngle() {
    return drivetrain.driveCommand(
        () -> MathUtil.applyDeadband(driver.getLeftY() * 1,
            OperatorConstants.LEFT_Y_DEADBAND),
        () -> MathUtil.applyDeadband(driver.getLeftX() * 1,
            OperatorConstants.LEFT_X_DEADBAND),
        () -> driver.getRightX(),
        () -> driver.getRightY());
  }

  private Command driveFieldOrientedDirectAngleSim() {
    return drivetrain.simDriveCommand(
        () -> MathUtil.applyDeadband(driver.getLeftY() * 0.8,
            OperatorConstants.LEFT_Y_DEADBAND),
        () -> MathUtil.applyDeadband(driver.getLeftX() * 0.8,
            OperatorConstants.LEFT_X_DEADBAND),
        () -> driver.getRightX());
  }

}