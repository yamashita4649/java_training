package ch04.ex01;

public class GasTank implements EnergySource {
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
