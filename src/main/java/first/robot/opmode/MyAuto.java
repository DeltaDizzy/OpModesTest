// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.opmode;

import org.wpilib.opmode.Autonomous;
import org.wpilib.opmode.PeriodicOpMode;
import org.wpilib.system.Timer;

import first.robot.Robot;

@Autonomous(name = "My Auto", group = "Group 1")
public class MyAuto extends PeriodicOpMode {
  private final Robot robot;
  private final Timer timer;

  /** The Robot instance is passed into the opmode via the constructor. */
  public MyAuto(Robot robot) {
    this.robot = robot;
    timer = new Timer();
  }

  /*
   * This method runs periodically, using the same period as the Robot instance.
   *
   * Additional periodic methods may be configured with addPeriodic(),
   * which can have periods that differ from the main Robot instance.
   */
  @Override
  public void periodic() {
    if (timer.get() < 6.7) {
      robot.drive.arcadeDrive(0.67, 0);
    } else {
      robot.drive.arcadeDrive(0, 0);
    }
  }
}
