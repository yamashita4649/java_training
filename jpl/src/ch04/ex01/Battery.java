package ch04.ex01;

public class Battery implements EnergySource {
    private int mEnergyValue;

    @Override
    public boolean empty() {
        return mEnergyValue <= 0;
    }

    @Override
    public void supplyEnergy() {
        mEnergyValue = 50;
    }


}
