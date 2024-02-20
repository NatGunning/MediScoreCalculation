package MediScore;

import java.text.DecimalFormat;

public class Patient {
    public enum AirOrOxygen {Air, Oxygen}

    private AirOrOxygen airState;

    public enum Consciousness {Alert, CVPU}

    private Consciousness consciousnessState;
    private int respRange;
    private int sp02;
    private float temp;

    public Patient(AirOrOxygen airState, Consciousness consciousnessState, int respRange, int sp02, float temp) {
        this.airState = airState;
        this.consciousnessState = consciousnessState;
        this.respRange = respRange;
        this.sp02 = sp02;
        this.temp = temp;
    }

    public int getAirStateScore() {
        return switch (this.airState) {
            case Air -> 0;
            case Oxygen -> 2;
        };
    }

    public int getConsciousnessStateScore() {
        return switch (this.consciousnessState) {
            case Alert -> 0;
            case CVPU -> 3;
        };
    }

    public int getRespRangeScore() {
        if (this.respRange >= 9 && this.respRange <= 11) {
            return 1;
        } else if (this.respRange >= 12 && this.respRange <= 20) {
            return 0;
        } else if (this.respRange >= 21 && this.respRange <= 24) {
            return 2;
            // values under 9 or above 25 return a score of 3
        } else return 3;
    }

    public int getSp02Score() {
        if (this.sp02 <= 83) {
            return 3;
        } else if (this.sp02 == 84 || this.sp02 == 85) {
            return 2;
        } else if (this.sp02 == 86 || this.sp02 == 87) {
            return 1;
        } else
        {
            //If the patient doesn't take oxygen, any higher value returns a score of 0
            if (this.airState.equals(AirOrOxygen.Air))
            {
                    return 0;

                } else{ //If the patient does take oxygen
                    if (this.sp02 <= 92) {
                        return 0;
                    } else if (this.sp02 == 93 || this.sp02 == 94) {
                        return 1;
                    } else if (this.sp02 == 95 || this.sp02 == 96) {
                        return 2;
                    } else { //if the SpO2 value is higher than 96
                        return 3;
                    }
                }
            }
        }

        public float configTemp()
        {
            DecimalFormat oneDP = new DecimalFormat("#.#");
            this.temp = Float.parseFloat(oneDP.format(this.temp));
            return this.temp;
        }

    public int getTempScore()
    {
        configTemp();
        if (this.temp <= 35.0)
        {
            return 3;
        } else if (this.temp >= 35.1 && this.temp <= 36.0)
        {
            return 1;
        } else if (this.temp >= 36.1 && this.temp <= 38.0)
        {
            return 0;
        } else if (this.temp >= 38.1 && this.temp <= 39.0)
        {
            return 1;
        }
        else return 2;
    }

    public int getMediScore()
    {
        return getAirStateScore() + getConsciousnessStateScore() + getRespRangeScore() + getSp02Score() + getTempScore();
    }

    @Override
    public String toString()
    {
        return String.format("%-20s %-20s %-5s","Property","Observation","Score")+"\n"
               + String.format("%-20s %-20s %-5s","Air or Oxygen?", this.airState , this.getAirStateScore())+"\n"
                + String.format("%-20s %-20s %-5s","Consciousness" , this.consciousnessState , this.getConsciousnessStateScore())+"\n"
                + String.format("%-20s %-20s %-5s","Respiration Range" , this.respRange , this.getRespRangeScore())+"\n"
                + String.format("%-20s %-20s %-5s","SpO2" , this.sp02 , this.getSp02Score())+"\n"
                + String.format("%-20s %-20s %-5s","Temperature" , configTemp(), this.getTempScore())+"\n"
                + "This patient's final Medi score is: " + getMediScore()+"\n";
    }
}
