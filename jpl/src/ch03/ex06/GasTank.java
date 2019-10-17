package ch03.ex06;

public class GasTank extends EnergySource {
    private int mEnergyValue;

    @Override
    public boolean empty() {
        return mEnergyValue <= 0;
    }

    @Override
    public void supplyEnergy() {
        mEnergyValue = 100;
    }
}
