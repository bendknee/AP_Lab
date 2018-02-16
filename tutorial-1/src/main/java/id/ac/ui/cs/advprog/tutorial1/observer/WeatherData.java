package id.ac.ui.cs.advprog.tutorial1.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity,
                                float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        // TODO Complete me!
        return 0f;
    }

    public void setTemperature(float temperature) {
        // TODO Complete me!
    }

    public float getHumidity() {
        // TODO Complete me!
        return 0f;
    }

    public void setHumidity(float humidity) {
        // TODO Complete me!
    }

    public float getPressure() {
        // TODO Complete me!
        return 0f;
    }

    public void setPressure(float pressure) {
        // TODO Complete me!
    }
}
