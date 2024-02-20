package MediScore;

public class Main
{
    public static void main(String[] args)
    {
        Patient patient1 = new Patient(Patient.AirOrOxygen.Air, Patient.Consciousness.Alert, 15, 95, 37.10f);
        System.out.println(patient1.toString());

        Patient patient2 = new Patient(Patient.AirOrOxygen.Oxygen, Patient.Consciousness.Alert, 17, 95, 37.1f);
        System.out.println(patient2.toString());

        Patient patient3 = new Patient(Patient.AirOrOxygen.Oxygen, Patient.Consciousness.CVPU, 23, 88, 38.483f);
        System.out.println(patient3.toString());
    }
}
