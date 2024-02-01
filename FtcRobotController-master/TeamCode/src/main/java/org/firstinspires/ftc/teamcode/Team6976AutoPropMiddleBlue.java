package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team6976AutoPropMiddleBlue", group="6976")
public class Team6976AutoPropMiddleBlue extends LinearOpMode {

    Team6976HM2024 robot = new Team6976HM2024();
    ElapsedTime Time = new ElapsedTime();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        robot.Intake.setPosition(0.3);
        robot.Intake2.setPosition(0);
        waitForStart();

        moveForward(0.4 , 1400); //moves forward
        moveBackward(0.4,1300); //backwards
        moveLeft(0.5,2200);
        moveForward(0.4 , 700); //moves forward



    }
    public void moveForward (double power, int time){
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(-power);
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void moveBackward (double power, int time){
        robot.DriveRightFront.setPower(-power);
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void moveLeft (double power, int time){
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(power );
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void moveArm (double power, int time){
        robot.Arm2.setPower(power);
        robot.Arm2b.setPower(power);
        sleep(time);
        robot.Arm2.setPower(0);
        robot.Arm2b.setPower(0);

    }

}
