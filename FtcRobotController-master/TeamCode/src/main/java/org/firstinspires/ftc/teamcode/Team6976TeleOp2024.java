package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Team6976TeleOp2024", group = "6976")
public class Team6976TeleOp2024 extends LinearOpMode {
    Team6976HM2024 robot = new Team6976HM2024();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        telemetry.addData("Say", "TeleOp Starting");
        telemetry.update();

        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.Intake.setPosition(0.3);
        robot.Intake2.setPosition(0);
        
        int count = 0;
        //robot.Lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_PARTY_PALETTE);
        waitForStart();

        while (opModeIsActive()) {
            boolean speedslow = gamepad1.right_bumper;
            double mag = speedslow ? 0.5 : 1.0;

            /* If you want a deadzone on your controller
            double y = (Math.abs(gamepad1.left_stick_y) > 0.1 ? gamepad1.left_stick_y : 0); // Remember, this is reversed!
            double x = -(Math.abs(gamepad1.left_stick_x) > 0.1 ? gamepad1.left_stick_x : 0) * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;
             */


            double y = gamepad1.left_stick_y * -1; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * -1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x * -1;

          /*  if (robot.Touched.isPressed()) {
                telemetry.addData("Touch", robot.Touched.isPressed());
                telemetry.update();
            } */

            /*
            Denominator is the largest motor power (absolute value) or 1
            This ensures all the powers maintain the same ratio, but only when
            at least one is out of the range [-1, 1] */

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.5);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

//            while(gamepad1.dpad_left) {
//                robot.DriveLeftFront.setPower(0.5);
//                robot.DriveRightFront.setPower(-0.5);
//                robot.DriveLeftBack.setPower(0.5);
//                robot.DriveRightBack.setPower(-0.5);
//            }
//
//            while(gamepad1.dpad_right) {
//                robot.DriveLeftFront.setPower(-0.5);
//                robot.DriveRightFront.setPower(0.5);
//                robot.DriveLeftBack.setPower(-0.5);
//                robot.DriveRightBack.setPower(0.5);
//            }

            telemetry.addData("RightFront", robot.DriveRightFront.getCurrentPosition());
            telemetry.addData("RightBack", robot.DriveRightBack.getCurrentPosition());
            telemetry.addData("LeftFront", robot.DriveLeftFront.getCurrentPosition());
            telemetry.addData("LeftBack", robot.DriveLeftBack.getCurrentPosition());
            telemetry.update();

            robot.DriveLeftFront.setPower(frontLeftPower * mag);
            robot.DriveLeftBack.setPower(backLeftPower * -mag);
            robot.DriveRightFront.setPower(frontRightPower * mag);
            robot.DriveRightBack.setPower(backRightPower * -mag);

            //Control Code

            boolean ArmSlow = gamepad2.x;
            double mag2 = ArmSlow ? 0.45 : 1;
            boolean ArmSuperSlow = gamepad2.y;
            double mag3 = ArmSuperSlow ? 0.4 : 1;
            boolean ArmFast = gamepad2.b;
            double mag4 = ArmFast ? 0.8 : 0.55;
            boolean ArmMax = (((gamepad2.right_bumper && gamepad2.left_bumper) && gamepad2.b));
            double mag5 = ArmMax ? 10 : 1; //10 is to max out power to 1 regardless of current power setting

            double Arm1 = gamepad2.right_stick_y;
            double Arm2b = gamepad2.left_stick_y;
            double Arm2 = gamepad2.left_stick_y;

            while(gamepad1.dpad_right){
                robot.DriveLeftFront.setPower(0.3 * mag);
                robot.DriveRightFront.setPower(-0.3 * mag);
                robot.DriveLeftBack.setPower(0.3 * mag);
                robot.DriveRightBack.setPower(-0.3 * mag);
            }
            while(gamepad1.dpad_left){
                robot.DriveLeftFront.setPower(-0.3 * mag);
                robot.DriveRightFront.setPower(0.3 * mag);
                robot.DriveLeftBack.setPower(-0.3 * mag);
                robot.DriveRightBack.setPower(0.3 * mag);
            }
            while(gamepad1.dpad_up){
                robot.DriveLeftFront.setPower(0.3 * mag);
                robot.DriveRightFront.setPower(0.3 * mag);
                robot.DriveLeftBack.setPower(-0.3 * mag);
                robot.DriveRightBack.setPower(-0.3 * mag);
            }
            while(gamepad1.dpad_down){
                robot.DriveLeftFront.setPower(-0.3 * mag);
                robot.DriveRightFront.setPower(-0.3 * mag);
                robot.DriveLeftBack.setPower(0.3 * mag);
                robot.DriveRightBack.setPower(0.3 * mag);
            }

            robot.Arm1.setPower(Arm1 * mag2 * mag3 * mag4 * mag5);
            robot.Arm2b.setPower(Arm2b * mag2 * mag3 * mag4 * mag5);
            robot.Arm2.setPower(Arm2 *mag2 * mag3 * mag4 * mag5);
             
            // left bumper is open, right bumper is close
//            while (gamepad2.right_bumper) {
//                robot.Intake.setPosition(0);
//                robot.Intake2.setPosition(0);
//                System.out.println("intake open");
//            }
//            while (gamepad2.left_bumper){
//                robot.Intake2.setPosition(0.7);
//                robot.Intake.setPosition(-0.7);
//                System.out.println("intake close");
//            }

//            if (gamepad2.left_bumper) {
//                robot.Intake.setPosition(0.3);
//                robot.Intake2.setPosition(0);
//
//            }
//
//            if (gamepad2.right_bumper) {
//                robot.Intake.setPosition(0.1);
//                robot.Intake2.setPosition(0.1);
//
//            }

            while (gamepad2.a) { //Arm Brake
                robot.Arm2.setPower(0);
                robot.Arm2b.setPower(0);
            }

//            while (((gamepad2.right_bumper && gamepad2.left_bumper) && gamepad2.b)) { //Max power for hanging
//                robot.Arm2.setPower(1);
//                robot.Arm2b.setPower(1);
            }
            //One side intake controls
            if (gamepad2.right_bumper) { //Opened
                robot.Intake.setPosition(0.1);
                robot.Intake2.setPosition(0.1);
            }



            if (gamepad2.left_bumper) { //Closed
                robot.Intake2.setPosition(0);
                robot.Intake.setPosition(0.3);
            }

//            if(gamepad2.y){
//                robot.Arm1.setPower(.9);
//            }
//            else if (gamepad2.x){
//                robot.Arm1.setPower(-1);
//            }
//            else {
//                robot.Arm1.setPower(0);
//            }
        }
    }
