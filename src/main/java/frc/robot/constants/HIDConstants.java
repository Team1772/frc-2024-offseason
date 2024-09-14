package frc.robot.constants;

public final class HIDConstants {

        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;

        public final class Driver {

            public static final double JOYSTICK_LEFT_X_AXIS_MODIFIER = 0.8;
            public static final double JOYSTICK_LEFT_Y_AXIS_MODIFIER = 0.8;
            public static final double JOYSTICK_RIGHT_X_AXIS_MODIFIER = 0.8;
            public static final double JOYSTICK_RIGHT_Y_AXIS_MODIFIER = 0.8;

        }

        public static class Operator {

          public static final double JOYSTICK_LEFT_X_DEADBAND = 0.2;
          public static final double JOYSTICK_LEFT_Y_DEADBAND = 0.2;
          public static final double JOYSTICK_RIGHT_X_DEADBAND = 0.2;
          public static final double JOYSTICK_TURN_CONSTANT = 6;
          
        }
    }
