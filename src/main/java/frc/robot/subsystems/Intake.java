package subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase{
    
    private static Intake instance;

    private HSTalon intakeMotor;

    private static DoubleSolenoid solenoid;

    private static final int FORWARD_CHANNEL_ID = 0;

    private static final int REVERSE_CHANNEL_ID = 0;

    private static final int INTAKE_MOTOR_ID = 0;

    private static final boolean INVERT = false;

    private Intake() {
        intakeMotor = new HSTalon(INTAKE_MOTOR_ID);
        intakeMotor.setInverted(INVERT);

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_CHANNEL_ID, REVERSE_CHANNEL_ID);
        
    }

    public HSTalon getMotor() {
        return intakeMotor;

    }

    public void setOutput(double output) {
        intakeMotor.set(ControlMode.PercentOutput, output);

    }

    public void toggleSolenoid() {
        if (solenoid.get() == Value.kReverse) {
            solenoid.set(Value.kForward);
        } else {
        solenoid.set(Value.kReverse);
        }
    }


    public static Intake getInstance() {
        if(instance == null) {
            instance = new Intake();

        }
        return instance;
    }

}
