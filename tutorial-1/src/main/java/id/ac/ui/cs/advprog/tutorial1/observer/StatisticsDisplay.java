package id.ac.ui.cs.advprog.tutorial1.observer;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;

    public StatisticsDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            float thisTemp = weatherData.getTemperature();
            ++numReadings;
            if (thisTemp > maxTemp) {
                maxTemp = thisTemp;
            }
            if (thisTemp < minTemp) {
                minTemp = thisTemp;
            }
            tempSum += thisTemp;
            display();
        }
    }
}
